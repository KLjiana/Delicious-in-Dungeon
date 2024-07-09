package me.suxuan.did.entity.living_armor;

import net.minecraft.core.Direction;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LivingArmorEntity extends Monster {

	private static final EntityDataAccessor<Boolean> DATA_ATTACKING_ID = SynchedEntityData.defineId(LivingArmorEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DATA_STANDING_ID = SynchedEntityData.defineId(LivingArmorEntity.class, EntityDataSerializers.BOOLEAN);
	private final AnimationState attackAnimationState = new AnimationState();
	private int attackAnimationTicks;
	private static int attackRunning;

	public LivingArmorEntity(EntityType type, Level level) {
		super(type, level);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new LivingArmorAttackGoal());

		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(0, new NearestAttackableTargetGoal(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 30.0D)
				.add(Attributes.FOLLOW_RANGE, 20.0D)
				.add(Attributes.MOVEMENT_SPEED, 0D)
				.add(Attributes.ATTACK_DAMAGE, 6.0D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1.0D);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			if (this.isAttacking()) {
				this.attackAnimationState.start(this.tickCount);
				attackAnimationTicks = 60;
				attackRunning = 120;
			} else {
				--this.attackAnimationTicks;
			}
		}
		attackRunning = Math.max(attackRunning - 1, 0);
	}

	@Override
	protected BodyRotationControl createBodyControl() {
		return new LivingArmorRotationControl(this);
	}

	public AnimationState getAttackAnimationState() {
		return attackAnimationState;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_ATTACKING_ID, false);
		this.entityData.define(DATA_STANDING_ID, false);
	}

	public boolean isAttacking() {
		return (Boolean) this.entityData.get(DATA_ATTACKING_ID);
	}

	public void setAttacking(boolean attacking) {
		this.entityData.set(DATA_ATTACKING_ID, attacking);
	}

	public boolean isStanding() {
		return (Boolean) this.entityData.get(DATA_STANDING_ID);
	}

	public void setStanding(boolean standing) {
		this.entityData.set(DATA_STANDING_ID, standing);
	}

	class LivingArmorAttackGoal extends MeleeAttackGoal {

		private int ticksUntilNextAttack;

		public LivingArmorAttackGoal() {
			super(LivingArmorEntity.this, 1.25, true);
		}

		@Override
		public void start() {
			super.start();
		}

		@Override
		public void tick() {
			super.tick();
			this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
		}

		@Override
		protected void checkAndPerformAttack(LivingEntity enemy, double distanceSquared) {
			double reachSquared = this.getAttackReachSqr(enemy);
			if (distanceSquared <= reachSquared && this.isTimeToAttack()) {
				LivingArmorEntity.this.setAttacking(true);
				LivingArmorEntity.this.setStanding(true);

				ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

				System.out.println(enemy.getRotationVector().y);
				System.out.println(LivingArmorEntity.this.getRotationVector().y);
				double zZ = Math.cos(enemy.getRotationVector().y * Math.PI / 180);
				double xX = Math.sin(enemy.getRotationVector().y * Math.PI / 180);
				System.out.println("z: " + 2 * zZ + ", x: " + 2 * xX);
				executor.schedule(() -> {

					double x = enemy.getPosition(0).get(Direction.Axis.X) - LivingArmorEntity.this.getPosition(0).get(Direction.Axis.X);
					double z = enemy.getPosition(0).get(Direction.Axis.Z) - LivingArmorEntity.this.getPosition(0).get(Direction.Axis.Z);

					System.out.println(Math.atan2(x, z) * 180 / Math.PI);

					if (Math.abs(Math.sqrt(x * x + z * z)) <= 2.2)
						this.mob.doHurtTarget(enemy);


//					Vec3 vec = new Vec3(enemy.getPosition(0).get(Direction.Axis.X) - LivingArmorEntity.this.getPosition(0).get(Direction.Axis.X),
//							enemy.getPosition(0).get(Direction.Axis.Y) - LivingArmorEntity.this.getPosition(0).get(Direction.Axis.Y),
//							enemy.getPosition(0).get(Direction.Axis.Z) - LivingArmorEntity.this.getPosition(0).get(Direction.Axis.Z));
//					if (Math.abs(vec.get(Direction.Axis.X)) <= 1.2)
//						this.mob.doHurtTarget(enemy);

//					System.out.println(mob.xRotO + " " + mob.getPosition(0).get(Direction.Axis.X));
//					System.out.println("坐标相减： " + vec);
//					System.out.println("View Vector： " + this.mob.getViewVector(0));
//					System.out.println("Look Angle： " + this.mob.getLookAngle());

				}, 1040, TimeUnit.MILLISECONDS);

				this.resetAttackCooldown();

			} else {
				LivingArmorEntity.this.setStanding(attackRunning > 0);
				LivingArmorEntity.this.setAttacking(false);
			}
		}

		@Override
		protected void resetAttackCooldown() {
			this.ticksUntilNextAttack = this.adjustedTickDelay(60);
		}

		@Override
		protected boolean isTimeToAttack() {
			return this.ticksUntilNextAttack <= 0;
		}

		@Override
		protected int getTicksUntilNextAttack() {
			return this.ticksUntilNextAttack;
		}

		@Override
		public void stop() {
			LivingArmorEntity.this.setAttacking(false);
			super.stop();
		}

		@Override
		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return 4.3F + attackTarget.getBbWidth();
		}
	}

	class LivingArmorRotationControl extends BodyRotationControl {
		private final Mob mob;
		private int headStableTime;
		private float lastStableYHeadRot;

		public LivingArmorRotationControl(Mob pMob) {
			super(pMob);
			this.mob = pMob;
		}

		@Override
		public void clientTick() {
			if (LivingArmorEntity.this.isStanding())
				return;
			if (Math.abs(this.mob.yHeadRot - this.lastStableYHeadRot) > 15.0F) {
				this.headStableTime = 0;
				this.lastStableYHeadRot = this.mob.yHeadRot;
				this.rotateBodyIfNecessary();
			} else {
				++this.headStableTime;
				if (this.headStableTime > 10) {
					this.rotateHeadTowardsFront();
				}
			}
		}

		private void rotateBodyIfNecessary() {
			this.mob.yBodyRot = Mth.rotateIfNecessary(this.mob.yBodyRot, this.mob.yHeadRot, (float) this.mob.getMaxHeadYRot());
		}

		private void rotateHeadIfNecessary() {
			this.mob.yHeadRot = Mth.rotateIfNecessary(this.mob.yHeadRot, this.mob.yBodyRot, (float) this.mob.getMaxHeadYRot());
		}

		private void rotateHeadTowardsFront() {
			int $$0 = this.headStableTime - 10;
			float $$1 = Mth.clamp((float) $$0 / 10.0F, 0.0F, 1.0F);
			float $$2 = (float) this.mob.getMaxHeadYRot() * (1.0F - $$1);
			this.mob.yBodyRot = Mth.rotateIfNecessary(this.mob.yBodyRot, this.mob.yHeadRot, $$2);
		}
	}

}
