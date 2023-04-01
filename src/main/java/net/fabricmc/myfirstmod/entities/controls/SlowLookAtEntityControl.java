import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.mob.MobEntity;

public class SlowLookAtEntityControl extends LookControl {

    public SlowLookAtEntity(MobEntity mob, Class<? extends LivingEntity> targetType, float range, float speed) {
        super(mob);
    }

    public SlowLookAtEntityControl(MobEntity entity) {
        super(entity);
    }

    @Override
    public void tick() {
        LivingEntity target = this.entity.getTarget();

        if (target != null) {
            this.entity.getLookControl().lookAt(target);
            ++this.lookAtTimer;
        } else {
            this.lookAtTimer = 0;
        }
    }
}
