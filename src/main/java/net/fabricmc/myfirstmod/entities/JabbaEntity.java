package net.fabricmc.myfirstmod.entities;

import net.fabricmc.myfirstmod.entities.controls.SlowLookAroundControl;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class JabbaEntity extends PathAwareEntity {
    public JabbaEntity(EntityType<? extends PathAwareEntity> entityType, World world) {

        super(entityType, world);
        this.lookControl = new SlowLookAroundControl(this, 4.0F);
    }

    @Override
    protected void initGoals() {
        // The higher the priority number, the lower the priority of the goal
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new WanderAroundGoal(this, 0.25D));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));
    }

    @Override
    protected int computeFallDamage(float fallDistance, float damageMultiplier) {
        // Reduce the fall damage by increasing the damageMultiplier value
        return fallDistance > 5 ? super.computeFallDamage(fallDistance, damageMultiplier) : 0;
    }
}


