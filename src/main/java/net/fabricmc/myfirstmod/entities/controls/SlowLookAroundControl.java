package net.fabricmc.myfirstmod.entities.controls;

import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.mob.MobEntity;

public class SlowLookAroundControl extends LookControl {
    private final float speed;

    public SlowLookAroundControl(MobEntity entity, float speed) {
        super(entity);
        this.speed = speed;
    }

    @Override
    public void tick() {
        if (this.getTargetPitch().isPresent() && this.getTargetYaw().isPresent()) {
            float deltaYaw = this.getTargetYaw().get() - this.entity.getYaw();
            float deltaPitch = this.getTargetPitch().get() - this.entity.getPitch();
            deltaYaw = net.minecraft.util.math.MathHelper.wrapDegrees(deltaYaw);
            deltaYaw /= this.speed;
            deltaPitch /= this.speed;
            this.entity.setYaw(this.entity.getYaw() + deltaYaw);
            this.entity.setPitch(this.entity.getPitch() + deltaPitch);
        }
    }
}
