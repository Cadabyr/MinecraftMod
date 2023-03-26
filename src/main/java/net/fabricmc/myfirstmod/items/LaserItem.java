package net.fabricmc.myfirstmod.items;

import net.fabricmc.myfirstmod.entities.LaserEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LaserItem extends Item {
    public LaserItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        // Define the laser range and speed
        double range = 100.0;
        float speed = 1.5f; // Adjust this value to change the speed of the laser

        // Calculate the end position of the laser based on the player's rotation and defined range
        Vec3d direction = user.getRotationVec(1.0F).normalize();
        Vec3d endPos = direction.multiply(range).add(user.getEyePos());

        if (!world.isClient) {
            // Calculate the travel time based on the desired speed
            int travelTime = (int) (range / speed);

            // Create a LaserEntity to represent the laser beam
            LaserEntity laserEntity = new LaserEntity(world, user.getX(), user.getEyeY(), user.getZ());
            laserEntity.setOwner(user);
            laserEntity.setRadius(0.1f);
            laserEntity.setDuration(20 * travelTime); // Duration based on the travel time
            laserEntity.setWaitTime(0);
            laserEntity.setRadiusGrowth(0);
            laserEntity.setNoGravity(true);

            // Calculate the velocity based on the travel time
            Vec3d velocity = endPos.subtract(user.getEyePos()).multiply(1.0 / travelTime);
            laserEntity.setVelocity(velocity);

            world.spawnEntity(laserEntity);
        }

        return TypedActionResult.success(itemStack, user.world.isClient());
    }
}
