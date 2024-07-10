package me.suxuan.did.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import me.suxuan.did.entity.monster.LivingArmorEntity;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class LivingArmorModel<T extends LivingArmorEntity> extends HierarchicalModel<T> {

	private final ModelPart all;

	public LivingArmorModel(ModelPart root) {
		this.all = root.getChild("all");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.0F, 0.0F, 0.0175F, 0.0F, 0.0F));

		PartDefinition Lleg = all.addOrReplaceChild("Lleg", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(44, 10).addBox(-0.5F, 8.0F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition Rleg = all.addOrReplaceChild("Rleg", CubeListBuilder.create().texOffs(0, 44).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(49, 0).addBox(-4.5F, 8.0F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition up = all.addOrReplaceChild("up", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition body = up.addOrReplaceChild("body", CubeListBuilder.create().texOffs(31, 20).addBox(-3.5F, -26.0F, -2.0F, 7.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 20).addBox(-4.5F, -26.0F, -3.0F, 9.0F, 9.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 36).addBox(-4.0F, -17.0F, -3.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, -1.0F));

		PartDefinition skirt4_r1 = body.addOrReplaceChild("skirt4_r1", CubeListBuilder.create().texOffs(54, 19).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, -16.75F, -0.5F, 0.0F, 0.0F, -0.1309F));

		PartDefinition skirt3_r1 = body.addOrReplaceChild("skirt3_r1", CubeListBuilder.create().texOffs(12, 60).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.25F, -17.0F, -0.5F, 0.0F, 0.0F, 0.1309F));

		PartDefinition skirt2_r1 = body.addOrReplaceChild("skirt2_r1", CubeListBuilder.create().texOffs(42, 62).addBox(-4.5F, 0.0F, -0.5F, 7.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -17.0F, 1.5F, 0.1309F, 0.0F, 0.0F));

		PartDefinition skirt1_r1 = body.addOrReplaceChild("skirt1_r1", CubeListBuilder.create().texOffs(59, 62).addBox(-3.5F, 0.0F, -0.5F, 7.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.0F, -1.5F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head = up.addOrReplaceChild("head", CubeListBuilder.create().texOffs(13, 44).addBox(-3.0F, -2.25F, -3.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(60, 9).addBox(-3.5F, -6.0F, -4.0F, 7.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(65, 0).addBox(-3.5F, -3.0F, -3.5F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(59, 43).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(20, 0).addBox(-4.0F, -9.0F, -2.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(52, 70).addBox(-1.0F, -9.0F, 4.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(48, 43).addBox(-1.0F, -10.0F, -2.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(29, 37).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, -1.0F));

		PartDefinition Larm = up.addOrReplaceChild("Larm", CubeListBuilder.create().texOffs(17, 49).addBox(0.0F, -3.0F, -3.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(67, 24).addBox(0.0F, -2.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -12.0F, -1.0F, -0.7866F, -0.0534F, 0.0117F));

		PartDefinition elbow_r1 = Larm.addOrReplaceChild("elbow_r1", CubeListBuilder.create().texOffs(36, 53).addBox(-2.5F, -1.0F, -2.9F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 6.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition hand = Larm.addOrReplaceChild("hand", CubeListBuilder.create(), PartPose.offset(1.1428F, 7.0985F, -0.3967F));

		PartDefinition glove_r1 = hand.addOrReplaceChild("glove_r1", CubeListBuilder.create().texOffs(62, 15).addBox(-1.9071F, 2.762F, -2.1971F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(39, 70).addBox(-1.4071F, 0.262F, -1.6971F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2401F, 0.7345F, 1.1858F));

		PartDefinition Rarm = up.addOrReplaceChild("Rarm", CubeListBuilder.create().texOffs(49, 32).addBox(-4.0F, -3.0F, -3.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(53, 53).addBox(-3.5F, 5.0F, -2.6F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 70).addBox(-3.0F, -2.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -12.0F, -1.0F, -1.2659F, -0.0137F, 0.0369F));

		PartDefinition hand2 = Rarm.addOrReplaceChild("hand2", CubeListBuilder.create(), PartPose.offset(-1.1428F, 6.0985F, 0.6033F));

		PartDefinition forearm_r1 = hand2.addOrReplaceChild("forearm_r1", CubeListBuilder.create().texOffs(70, 48).addBox(-2.8617F, 0.2581F, -2.3217F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(25, 62).addBox(-3.3617F, 2.5081F, -2.8217F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0436F, -0.3287F, -1.6019F));

		PartDefinition sword = hand2.addOrReplaceChild("sword", CubeListBuilder.create(), PartPose.offsetAndRotation(3.821F, 0.7155F, -0.6094F, 0.0176F, -0.0167F, 0.0043F));

		PartDefinition handguard_r1 = sword.addOrReplaceChild("handguard_r1", CubeListBuilder.create().texOffs(20, 0).addBox(1.0547F, -0.4456F, 0.2076F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8457F, -0.8533F, -5.0283F, -0.0876F, -0.3306F, -1.6008F));

		PartDefinition handguard_r2 = sword.addOrReplaceChild("handguard_r2", CubeListBuilder.create().texOffs(0, 20).addBox(-0.1007F, -3.3937F, -0.864F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0815F, -1.4969F, -3.608F, 0.0003F, -0.3268F, -1.6029F));

		PartDefinition sword_r1 = sword.addOrReplaceChild("sword_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.4062F, 4.0407F, -21.8401F, 1.0F, 2.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(43, 0).addBox(-3.8398F, 5.4903F, -3.7454F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(29, 40).addBox(-3.839F, 3.4906F, -3.7775F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 36).addBox(-3.8613F, 3.5066F, -4.7772F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 36).addBox(-2.8617F, 3.5081F, -4.8217F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(68, 36).addBox(-2.2504F, 4.4279F, 1.1764F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 61).addBox(-2.3619F, 4.0081F, -3.8137F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8303F, -2.1895F, 1.0252F, -0.0436F, -0.3287F, -1.6019F));

		PartDefinition top = sword.addOrReplaceChild("top", CubeListBuilder.create(), PartPose.offset(0.4013F, -8.7387F, -18.5832F));

		PartDefinition sword_r2 = top.addOrReplaceChild("sword_r2", CubeListBuilder.create().texOffs(37, 15).addBox(-0.1513F, -1.0137F, -1.9684F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7173F, 1.4185F, -1.9471F, -0.2106F, -0.3291F, -1.598F));

		PartDefinition sword_r3 = top.addOrReplaceChild("sword_r3", CubeListBuilder.create().texOffs(30, 37).addBox(0.2398F, -0.1442F, -0.026F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3507F, 1.0162F, -4.4546F, 0.7645F, -0.322F, -1.6188F));

		PartDefinition sword_r4 = top.addOrReplaceChild("sword_r4", CubeListBuilder.create().texOffs(25, 20).addBox(-0.1282F, -0.0003F, -1.9974F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2905F, 1.5366F, -1.9035F, 0.0882F, -0.3285F, -1.605F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.getAttackAnimationState(), ARMOR_ATTACKING_1, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		all.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return all;
	}


	public static final AnimationDefinition ARMOR_ATTACKING_1 = AnimationDefinition.Builder.withLength(2.5f)
			.addAnimation("Rarm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(56.77f, 34.39f, 39.86f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(55.75f, 39.19f, 38.13f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(-6.02f, -6.81f, 9.4f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(-5.02f, -6.81f, 9.4f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("hand2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-0.78f, -5.95f, 35.4f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(-0.52f, -5.98f, 32.89f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(-4.93f, -15.26f, 85.1f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(-4.9f, -14.26f, 85.01f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("sword",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(21.34f, 15.3f, 92.1f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(2.68f, 15.3f, 92.1f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(2.68f, 15.3f, 92.1f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(-32.78f, -2.32f, 101.63f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(-28.23f, 1.94f, 99f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.0416765f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Larm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-32.5f, 0f, -55f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.625f, KeyframeAnimations.degreeVec(-32.51f, 4.88f, -53.92f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(-32.51f, 4.88f, -53.92f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(-10.01f, 4.88f, -53.92f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(-10.01f, 4.88f, -53.92f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("hand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.625f, KeyframeAnimations.degreeVec(7.27f, -20.52f, -51.2f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(7.27f, -20.52f, -51.2f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(-33.1f, -44.16f, 12.81f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5f, KeyframeAnimations.degreeVec(-33.1f, -44.16f, 12.81f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.0416765f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("up",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.0416765f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR))).build();
	public static final AnimationDefinition ARMOR_ATTACKING_2 = AnimationDefinition.Builder.withLength(3.5f)
			.addAnimation("Rleg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.25f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.375f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Rarm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-57.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.25f, KeyframeAnimations.degreeVec(-57.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.375f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.5f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("hand2",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.posVec(-0.02f, -0.98f, -0.41f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.25f, KeyframeAnimations.posVec(-0.02f, -0.98f, -0.41f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.375f, KeyframeAnimations.posVec(-0.02f, -0.91f, -0.38f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.posVec(-0.02f, -0.91f, -0.38f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.5f, KeyframeAnimations.posVec(-0.02f, -0.91f, -0.38f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.posVec(-0.02f, -0.91f, -0.38f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.5f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("hand2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(17.76f, -11.67f, 59.94f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.25f, KeyframeAnimations.degreeVec(17.76f, -11.67f, 59.94f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.375f, KeyframeAnimations.degreeVec(16.49f, -10.83f, 55.66f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.degreeVec(16.49f, -10.83f, 55.66f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.5f, KeyframeAnimations.degreeVec(16.49f, -10.83f, 55.66f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(16.49f, -10.83f, 55.66f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("sword",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(20.18f, 15.3f, 92.1f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(6.83f, 14.04f, 30.18f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.degreeVec(6.83f, 14.04f, 30.18f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.5f, KeyframeAnimations.degreeVec(6.83f, 14.04f, 30.18f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(6.83f, 14.04f, 30.18f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Larm",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-61.45f, 25.31f, -10.58f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.25f, KeyframeAnimations.degreeVec(-61.45f, 25.31f, -10.58f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.375f, KeyframeAnimations.degreeVec(-0.65f, 32.67f, -3.05f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.degreeVec(-0.65f, 32.67f, -3.05f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.5f, KeyframeAnimations.degreeVec(-0.65f, 32.67f, -3.05f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(-0.65f, 32.67f, -3.05f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("hand",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.posVec(0f, -1f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.25f, KeyframeAnimations.posVec(0f, -1f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.375f, KeyframeAnimations.posVec(0f, -0.93f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.posVec(0f, -0.93f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.5f, KeyframeAnimations.posVec(0f, -0.93f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.posVec(0f, -0.93f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.5f, KeyframeAnimations.posVec(0f, -0.93f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("hand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -60f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.25f, KeyframeAnimations.degreeVec(0f, 0f, -60f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.375f, KeyframeAnimations.degreeVec(0f, 0f, -55.71f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, 0f, -55.71f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.5f, KeyframeAnimations.degreeVec(0f, 0f, -55.71f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, -55.71f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("head",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.5f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(-25f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("up",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.25f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.375f, KeyframeAnimations.degreeVec(20f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.5f, KeyframeAnimations.degreeVec(20f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(20f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR))).build();
	public static final AnimationDefinition ARMOR_RUNNING = AnimationDefinition.Builder.withLength(6f).looping()
			.addAnimation("Rleg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-42.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(-42.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(-42.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(-42.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(-35f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(-35f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.125f, KeyframeAnimations.degreeVec(-35f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4f, KeyframeAnimations.degreeVec(-35f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4.125f, KeyframeAnimations.degreeVec(-37.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(5f, KeyframeAnimations.degreeVec(-37.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(5.25f, KeyframeAnimations.degreeVec(-75f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Lleg",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(-35f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(-35f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.125f, KeyframeAnimations.degreeVec(-77.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4f, KeyframeAnimations.degreeVec(-77.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4.125f, KeyframeAnimations.degreeVec(-77.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(5f, KeyframeAnimations.degreeVec(-77.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(5.25f, KeyframeAnimations.degreeVec(-75f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("up",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.posVec(0f, -0.02f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.posVec(0f, -0.02f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.posVec(0f, -0.04f, 0.01f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.posVec(0f, -0.04f, 0.01f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.posVec(0f, -0.1f, 0.02f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.posVec(0f, -0.1f, 0.02f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.125f, KeyframeAnimations.posVec(0f, -0.14f, 0.03f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4f, KeyframeAnimations.posVec(0f, -0.14f, 0.03f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4.125f, KeyframeAnimations.posVec(0f, -0.89f, -0.61f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(5.25f, KeyframeAnimations.posVec(0f, -0.89f, -0.61f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("up",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(-20f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.5416767f, KeyframeAnimations.degreeVec(-20f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.degreeVec(-35f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(-35f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.125f, KeyframeAnimations.degreeVec(-47.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4f, KeyframeAnimations.degreeVec(-47.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4.125f, KeyframeAnimations.degreeVec(-65f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4.5f, KeyframeAnimations.degreeVec(-65f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4.708343f, KeyframeAnimations.degreeVec(-72.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(5.25f, KeyframeAnimations.degreeVec(-73.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("all",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.125f, KeyframeAnimations.degreeVec(37.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2f, KeyframeAnimations.degreeVec(37.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(2.25f, KeyframeAnimations.degreeVec(37.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3f, KeyframeAnimations.degreeVec(37.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(3.125f, KeyframeAnimations.degreeVec(37.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4f, KeyframeAnimations.degreeVec(37.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(4.125f, KeyframeAnimations.degreeVec(75f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(5f, KeyframeAnimations.degreeVec(75f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(5.25f, KeyframeAnimations.degreeVec(75f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR))).build();

}
