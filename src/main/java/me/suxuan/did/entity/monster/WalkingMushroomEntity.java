package me.suxuan.did.entity.monster;

import me.suxuan.did.entity.ModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class WalkingMushroomEntity extends Animal {

	private final AnimationState runAnimationState = new AnimationState();
	private int runAnimationTicks;

	public WalkingMushroomEntity(EntityType type, Level level) {
		super(type, level);
	}

	@Override
	protected void registerGoals() {
//		this.goalSelector.addGoal(0, new FloatGoal(this));
//		this.goalSelector.addGoal(1, new FollowParentGoal(this, 1.25D));
//		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
//		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 30.0D)
				.add(Attributes.FOLLOW_RANGE, 20.0D)
				.add(Attributes.MOVEMENT_SPEED, 0D)
				.add(Attributes.ATTACK_DAMAGE, 6.0D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1.0D);
	}

	@Nullable
	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob pOtherParent) {
		return ModEntities.WALKING_MUSHROOM.get().create(level);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			if (this.runAnimationTicks <= 0) {
				this.runAnimationTicks = this.random.nextInt(40) + 80;
				this.runAnimationState.start(this.tickCount);
			} else {
				--this.runAnimationTicks;
			}
		}
	}

	@Override
	protected void updateWalkAnimation(float pPartialTick) {
		float f;
		if (this.getPose() == Pose.STANDING) {
			f = Math.min(pPartialTick * 6.0F, 1.0F);
		} else {
			f = 0.0F;
		}
		this.walkAnimation.update(f, 0.2F);
	}

	public AnimationState getRunAnimationState() {
		return runAnimationState;
	}

}
