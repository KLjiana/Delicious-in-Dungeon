package me.suxuan.did.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import me.suxuan.did.entity.monster.MimicEntity;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class MimicModel<T extends MimicEntity> extends HierarchicalModel<T> {

	private final ModelPart root;
	private final ModelPart chest;

	public MimicModel(ModelPart root) {
		this.root = root;
		this.chest = root.getChild("chest");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition chest = partdefinition.addOrReplaceChild("chest", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -7.0F));

		PartDefinition base = chest.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, 0.0F, 1.0F, 14.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 15.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition lid = chest.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 25).addBox(-7.0F, 0.0F, 0.0F, 14.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 14.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition knob = lid.addOrReplaceChild("knob", CubeListBuilder.create().texOffs(11, 53).addBox(7.0F, -2.0F, -15.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition mimic = chest.addOrReplaceChild("mimic", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, -8.5F, 7.5F, -1.2217F, 0.0F, 0.0F));

		PartDefinition RightHand = mimic.addOrReplaceChild("RightHand", CubeListBuilder.create().texOffs(0, 7).addBox(-3.659F, 2.957F, 3.9798F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(53, 0).addBox(-3.159F, 3.457F, 1.9798F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 53).addBox(-3.159F, 4.657F, 6.9798F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.3F, 4.9F, 2.8965F, -0.1841F, -0.6318F));

		PartDefinition cube_r1 = RightHand.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(53, 25).addBox(-1.0266F, -0.1952F, -1.0941F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1325F, 3.7916F, 7.8788F, -0.1396F, 0.0F, 0.0F));

		PartDefinition cube_r2 = RightHand.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(41, 45).addBox(-1.3395F, 0.0388F, -3.2683F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1325F, 1.9916F, 0.2288F, -1.4705F, -0.3035F, 0.7363F));

		PartDefinition cube_r3 = RightHand.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(49, 48).addBox(-1.0266F, 0.1157F, -4.0376F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1325F, 3.9916F, 3.2288F, -0.6981F, 0.0F, 0.0F));

		PartDefinition LeftHand = mimic.addOrReplaceChild("LeftHand", CubeListBuilder.create().texOffs(0, 0).addBox(0.659F, 2.957F, 3.9798F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(10, 45).addBox(1.159F, 3.457F, 1.9798F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(38, 51).addBox(1.159F, 4.657F, 6.9798F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.3F, 4.9F, 2.8965F, 0.1841F, 0.6318F));

		PartDefinition cube_r4 = LeftHand.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(18, 53).addBox(-0.9734F, -0.1952F, -1.0941F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1325F, 3.7916F, 7.8788F, -0.1396F, 0.0F, 0.0F));

		PartDefinition cube_r5 = LeftHand.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(30, 45).addBox(-0.6605F, 0.0388F, -3.2683F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1325F, 1.9916F, 0.2288F, -1.4705F, 0.3035F, -0.7363F));

		PartDefinition cube_r6 = LeftHand.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(27, 51).addBox(-0.9734F, 0.1157F, -4.0376F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1325F, 3.9916F, 3.2288F, -0.6981F, 0.0F, 0.0F));

		PartDefinition eyes = mimic.addOrReplaceChild("eyes", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, 4.0F));

		PartDefinition cube_r7 = eyes.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(54, 8).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(8, 25).addBox(-1.0F, -5.0F, -0.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r8 = eyes.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(8, 31).addBox(0.0F, -5.0F, -0.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(54, 33).addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition foot1 = mimic.addOrReplaceChild("foot1", CubeListBuilder.create().texOffs(0, 45).addBox(-1.0F, -0.8443F, -4.7883F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, 3.3443F, 6.2883F, 0.0F, -0.0436F, 0.0F));

		PartDefinition cube_r9 = foot1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(43, 8).addBox(-1.0F, -2.4302F, -3.3856F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.1557F, -3.7883F, 0.6109F, 0.0F, 0.0F));

		PartDefinition foot2 = mimic.addOrReplaceChild("foot2", CubeListBuilder.create().texOffs(15, 45).addBox(-1.0F, -0.8443F, -4.7883F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 3.3443F, 6.2883F, 0.0F, 0.2618F, 0.0F));

		PartDefinition cube_r10 = foot2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(43, 33).addBox(-1.0F, -2.4302F, -3.3856F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.1557F, -3.7883F, 0.6109F, 0.0F, 0.0F));

		PartDefinition foot3 = mimic.addOrReplaceChild("foot3", CubeListBuilder.create().texOffs(43, 25).addBox(-1.0F, -0.8443F, -4.7883F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 3.3443F, 6.2883F, 0.0F, -0.2618F, 0.0F));

		PartDefinition cube_r11 = foot3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 31).addBox(-1.0F, -2.4302F, -3.3856F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.1557F, -3.7883F, 0.6109F, 0.0F, 0.0F));

		PartDefinition foot4 = mimic.addOrReplaceChild("foot4", CubeListBuilder.create().texOffs(43, 0).addBox(-1.0F, -0.7704F, -5.0405F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 3.2704F, 6.5405F));

		PartDefinition cube_r12 = foot4.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 25).addBox(-1.0F, -2.4302F, -3.3856F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.2296F, -4.0405F, 0.6109F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		chest.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return root;
	}


	public static final AnimationDefinition MIMIC_SHOW = AnimationDefinition.Builder.withLength(1.8343333f)
			.addAnimation("chest",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.7916766f, KeyframeAnimations.posVec(0f, 0f, 14f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("chest",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(90f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("lid",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(-135f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("mimic",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0.4167667f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.posVec(0f, 7f, -2f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("RightHand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(-20f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("LeftHand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(12.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("foot1",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(-15f, 5.63f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(10f, 11.25f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(-7.5f, 16.88f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 22.5f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("foot2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("foot3",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("foot4",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(7.5f, -9.38f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5834334f, KeyframeAnimations.degreeVec(-7.5f, -18.75f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.6766666f, KeyframeAnimations.degreeVec(6.25f, -28.13f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, -37.5f, 0f),
									AnimationChannel.Interpolations.LINEAR))).build();
	public static final AnimationDefinition MIMIC_RUNNING = AnimationDefinition.Builder.withLength(0.5f).looping()
			.addAnimation("chest",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 14f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("chest",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(90f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("base",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 10f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("lid",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.posVec(1f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.posVec(-1f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("lid",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-117.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-75.11f, 10.6f, 3.54f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-110f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-80.24f, -5.29f, -1.77f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(-107.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("mimic",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 7f, -2f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("RightHand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-11.12f, 2.83f, 7.04f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(8.76f, -8.02f, -24.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("LeftHand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(11.44f, 5.18f, 17.18f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-21.47f, -3.39f, -9.52f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(-5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("foot1",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 22.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-20.72f, 24.34f, 4.98f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 22.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(17.25f, 20.11f, -0.79f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 22.5f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("foot2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("foot3",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-17.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.2916767f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("foot3",
					new AnimationChannel(AnimationChannel.Targets.SCALE,
							new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("foot4",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -37.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(11.18f, -27.71f, 2.43f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(0f, -37.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-12.5f, -25f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -37.5f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("eyes",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, 15f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, -15f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR))).build();
}
