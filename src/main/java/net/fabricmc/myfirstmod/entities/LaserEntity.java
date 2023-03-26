package net.fabricmc.myfirstmod.entities;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class LaserEntity extends AreaEffectCloudEntity {
    private LivingEntity owner;
    public LaserEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public LaserEntity(EntityType<LaserEntity> laserEntityEntityType, World world) {
        super(laserEntityEntityType, world);
    }

    public void setOwner(LivingEntity owner) {
        this.owner = owner;
    }

    @Override
    public void tick() {
        super.tick();

        /// Calculate the next position of the ray
        Vec3d currentPosition = this.getPos();
        Vec3d direction = this.getVelocity().normalize();
        Vec3d nextPosition = currentPosition.add(direction);

        // Check if the ray has hit a solid block
        BlockPos nextBlockPos = new BlockPos(((int)nextPosition.x), (int)nextPosition.y, (int)nextPosition.z);
        if (this.world.getBlockState(nextBlockPos).isOpaque()) {
            this.discard();
            return;
        }

        // Update the position of the ray
        this.updatePosition(nextPosition.x, nextPosition.y, nextPosition.z);

        MinecraftClient.getInstance().particleManager.addParticle(ParticleTypes.FLAME, nextPosition.x, nextPosition.y, nextPosition.z, 0, 0, 0);

        // Check for collisions with entities
        if (!this.world.isClient) {
            List<Entity> collidedEntities = this.world.getOtherEntities(this, this.getBoundingBox(), entity -> !entity.equals(this.owner));

            for (Entity collidedEntity : collidedEntities) {
                if (collidedEntity instanceof LivingEntity) {
                    // Create explosion
                    this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 10.0f, World.ExplosionSourceType.TNT);

                    // Apply damage to collided entity
                    collidedEntity.damage(owner.getDamageSources().magic(), 10.0f); // 5 hearts of damage = 10 HP

                    // Remove the laser entity after collision
                    this.discard();
                    break;
                }
            }
        }
    }
}
