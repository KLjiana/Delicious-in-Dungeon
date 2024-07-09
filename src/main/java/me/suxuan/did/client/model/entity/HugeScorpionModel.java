package me.suxuan.did.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import me.suxuan.did.entity.huge_scorpion.HugeScorpionEntity;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class HugeScorpionModel<T extends HugeScorpionEntity> extends HierarchicalModel<T> {

	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart mouth;
	private final ModelPart Lhand;
	private final ModelPart Rhand;
	private final ModelPart Rfeet;
	private final ModelPart Lfeet;

	public HugeScorpionModel(ModelPart root) {
		this.root = root;
		this.body = root.getChild("body");
		this.mouth = root.getChild("mouth");
		this.Lhand = root.getChild("Lhand");
		this.Rhand = root.getChild("Rhand");
		this.Rfeet = root.getChild("Rfeet");
		this.Lfeet = root.getChild("Lfeet");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition I = body.addOrReplaceChild("I", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -6.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition II = I.addOrReplaceChild("II", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, -1.0F));

		PartDefinition cube_r1 = II.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 9).addBox(-2.0F, -5.0F, 0.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0809F, -0.1915F, 0.0F, 0.0F, 0.0F));

		PartDefinition III = II.addOrReplaceChild("III", CubeListBuilder.create().texOffs(17, 0).addBox(-2.0F, 0.1218F, -0.3024F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(32, 12).addBox(-1.0F, 0.1218F, 2.6976F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0809F, 3.8085F));

		PartDefinition tail = III.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(1.0F, 1.1218F, 2.6976F));

		PartDefinition VII = tail.addOrReplaceChild("VII", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.083F, -0.3263F));

		PartDefinition cube_r2 = VII.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(16, 26).addBox(-1.0F, -0.1161F, 0.4601F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.9929F, 2.4553F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r3 = VII.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 23).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0071F, 1.4553F, 0.6545F, 0.0F, 0.0F));

		PartDefinition VI = VII.addOrReplaceChild("VI", CubeListBuilder.create(), PartPose.offset(0.0F, -3.9929F, 3.4553F));

		PartDefinition cube_r4 = VI.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(12, 9).addBox(-1.0F, 1.3065F, 0.5538F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.2168F, -0.9681F, 2.0944F, 0.0F, 0.0F));

		PartDefinition V = VI.addOrReplaceChild("V", CubeListBuilder.create(), PartPose.offset(0.0F, -1.7832F, -0.9681F));

		PartDefinition cube_r5 = V.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(28, 0).addBox(-1.0F, -0.1935F, -0.0443F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.6616F, 0.0F, 0.0F));

		PartDefinition IV = V.addOrReplaceChild("IV", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -2.0F));

		PartDefinition cube_r6 = IV.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -0.157F, 4.72F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		PartDefinition cube_r7 = IV.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, -0.157F, -0.28F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition cube_r8 = IV.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(22, 10).addBox(-1.0F, -0.157F, 1.72F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition mouth = partdefinition.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(26, 34).addBox(-1.0F, -3.0F, -7.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 9).addBox(1.0F, -4.0F, -7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, -4.0F, -7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(8, 26).addBox(2.0F, -4.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(25, 25).addBox(-4.0F, -4.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Lhand = partdefinition.addOrReplaceChild("Lhand", CubeListBuilder.create(), PartPose.offset(5.0F, 21.0F, -8.0F));

		PartDefinition cube_r9 = Lhand.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(17, 23).addBox(1.0F, -1.0F, -6.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -0.0873F, 0.7854F, 0.0F));

		PartDefinition cube_r10 = Lhand.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(14, 19).addBox(1.0F, -3.0F, -6.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0436F, 0.7854F, 0.0F));

		PartDefinition cube_r11 = Lhand.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 16).addBox(1.0F, -3.0F, -4.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r12 = Lhand.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(25, 21).addBox(0.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.0873F, 0.0F));

		PartDefinition cube_r13 = Lhand.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(6, 32).addBox(0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0F, 0.0F, 0.0F, -1.3963F, 0.0F));

		PartDefinition Rhand = partdefinition.addOrReplaceChild("Rhand", CubeListBuilder.create(), PartPose.offset(-5.0F, 21.0F, -8.0F));

		PartDefinition cube_r14 = Rhand.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(7, 23).addBox(-4.0F, -1.0F, -6.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -0.0873F, -0.7854F, 0.0F));

		PartDefinition cube_r15 = Rhand.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(19, 6).addBox(-4.0F, -3.0F, -6.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0436F, -0.7854F, 0.0F));

		PartDefinition cube_r16 = Rhand.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(12, 12).addBox(-4.0F, -3.0F, -4.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r17 = Rhand.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(24, 17).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, -0.0873F, 0.0F));

		PartDefinition cube_r18 = Rhand.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(31, 27).addBox(-1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.0F, 0.0F, 0.0F, 1.3963F, 0.0F));

		PartDefinition Rfeet = partdefinition.addOrReplaceChild("Rfeet", CubeListBuilder.create(), PartPose.offset(-2.0F, 22.0F, -4.0F));

		PartDefinition R1 = Rfeet.addOrReplaceChild("R1", CubeListBuilder.create(), PartPose.offset(-2.0F, -1.0F, 0.0F));

		PartDefinition cube_r19 = R1.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(34, 15).addBox(-2.2145F, -0.5088F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition cube_r20 = R1.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(23, 29).addBox(-3.0F, -1.0F, 3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, -4.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition cube_r21 = R1.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(31, 20).addBox(-3.2222F, -0.3345F, -6.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 5.0F, 0.0F, 0.0F, -1.1781F));

		PartDefinition R2 = Rfeet.addOrReplaceChild("R2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition cube_r22 = R2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.0F, 3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -4.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition cube_r23 = R2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(34, 0).addBox(-2.2145F, -0.5088F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.0F, -2.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition cube_r24 = R2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(23, 31).addBox(-3.2222F, -0.3345F, -4.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -1.0F, 3.0F, 0.0F, 0.0F, -1.1781F));

		PartDefinition R3 = Rfeet.addOrReplaceChild("R3", CubeListBuilder.create(), PartPose.offset(0.0F, -0.2F, 3.0F));

		PartDefinition cube_r25 = R3.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(8, 30).addBox(-3.0F, -1.0F, 3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.3033F, -3.3618F, 0.0F, 0.0F, 0.5672F));

		PartDefinition cube_r26 = R3.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 34).addBox(-2.2145F, -0.5088F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.6967F, -3.3618F, 0.0F, 0.0F, -0.0873F));

		PartDefinition cube_r27 = R3.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(31, 25).addBox(-3.2222F, -0.3345F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.6967F, 1.6382F, 0.0F, 0.0F, -1.1781F));

		PartDefinition R4 = Rfeet.addOrReplaceChild("R4", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 5.0F));

		PartDefinition cube_r28 = R4.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 32).addBox(-3.2222F, -0.3345F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.1781F));

		PartDefinition cube_r29 = R4.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(15, 29).addBox(-3.0F, -1.0F, 3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -3.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition cube_r30 = R4.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(33, 22).addBox(-2.2145F, -0.5088F, 5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -5.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition Lfeet = partdefinition.addOrReplaceChild("Lfeet", CubeListBuilder.create(), PartPose.offset(2.0F, 22.0F, -4.0F));

		PartDefinition L1 = Lfeet.addOrReplaceChild("L1", CubeListBuilder.create(), PartPose.offset(2.0F, -1.0F, 0.0F));

		PartDefinition cube_r31 = L1.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(10, 32).addBox(0.2145F, -0.5088F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition cube_r32 = L1.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(29, 10).addBox(0.0F, -1.0F, 3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 2.0F, -4.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition cube_r33 = L1.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(15, 31).addBox(0.2222F, -0.3345F, -6.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 5.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition L2 = Lfeet.addOrReplaceChild("L2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition cube_r34 = L2.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(28, 7).addBox(0.0F, -1.0F, 3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -3.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition cube_r35 = L2.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(30, 32).addBox(0.2145F, -0.5088F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition cube_r36 = L2.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(31, 3).addBox(0.2222F, -0.3345F, -4.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.0F, 4.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition L3 = Lfeet.addOrReplaceChild("L3", CubeListBuilder.create(), PartPose.offset(0.0F, -0.2F, 3.0F));

		PartDefinition cube_r37 = L3.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(26, 15).addBox(0.0F, -1.0F, 3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.3033F, -3.3618F, 0.0F, 0.0F, -0.5672F));

		PartDefinition cube_r38 = L3.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(15, 33).addBox(0.2145F, -0.5088F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -0.6967F, -3.3618F, 0.0F, 0.0F, 0.0873F));

		PartDefinition cube_r39 = L3.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(30, 30).addBox(0.2222F, -0.3345F, -2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -0.6967F, 1.6382F, 0.0F, 0.0F, 1.1781F));

		PartDefinition L4 = Lfeet.addOrReplaceChild("L4", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 2.0F));

		PartDefinition cube_r40 = L4.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(28, 5).addBox(0.0F, -1.0F, 3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition cube_r41 = L4.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(30, 17).addBox(0.2222F, -0.3345F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -2.0F, 3.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition cube_r42 = L4.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(21, 33).addBox(0.2145F, -0.5088F, 5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, -2.0F, 0.0F, 0.0F, 0.0873F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mouth.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Lhand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Rhand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Rfeet.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Lfeet.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return root;
	}

	public static final AnimationDefinition SCORPION_WALKING = AnimationDefinition.Builder.withLength(1f).looping()
			.addAnimation("tail",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Lhand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -2.5f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Rhand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -2.5f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Rfeet",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Lfeet",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("R1",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-1.95f, -7.24f, 15.12f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("R2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-2.61f, -9.66f, 15.22f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("R3",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-1.95f, -7.24f, 15.12f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("R4",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-2.58f, -7.05f, 20.16f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("L1",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-2.61f, 9.66f, -15.22f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 2.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("L2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-1.95f, 7.24f, -15.12f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("L3",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-1.95f, 7.24f, -15.12f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("L4",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.75f, KeyframeAnimations.degreeVec(-1.95f, 7.24f, -15.12f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR))).build();
	public static final AnimationDefinition SCORPION_RUNNING = AnimationDefinition.Builder.withLength(0.5f).looping()
			.addAnimation("tail",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Lhand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-27.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-25f, -2.5f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(-27.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Rhand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(-20f, -2.5f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Rfeet",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Lfeet",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("R1",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-1.95f, -7.24f, 15.12f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("R2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-2.61f, -9.66f, 15.22f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("R3",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-1.95f, -7.24f, 15.12f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("R4",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-2.58f, -7.05f, 20.16f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("L1",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-2.61f, 9.66f, -15.22f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 2.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("L2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-1.95f, 7.24f, -15.12f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("L3",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(-1.95f, 7.24f, -15.12f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("L4",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(-1.95f, 7.24f, -15.12f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, -1.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, -1f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("mouth",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -1f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.125f, KeyframeAnimations.degreeVec(0f, 0f, -2f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, -1f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.375f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 0f, -1f),
									AnimationChannel.Interpolations.LINEAR))).build();
	public static final AnimationDefinition SCORPION_WAITING = AnimationDefinition.Builder.withLength(1.75f).looping()
			.addAnimation("body",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.posVec(0f, -0.25f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("tail",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(1.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Lhand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Rhand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR))).build();
	public static final AnimationDefinition SCORPION_ATTACKING = AnimationDefinition.Builder.withLength(0.8343334f)
			.addAnimation("I",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(-1.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("II",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(-0.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(35f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("III",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(8.44f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(45.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("mouth",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(-4f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Lhand",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.posVec(0f, 0.6f, 0.6f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, -0.1f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Lhand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-27.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(-27.86f, 8.86f, -4.65f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(-27.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Rhand",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.posVec(0f, 0.2f, 0.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, -0.38f, -0.15f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Rhand",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(-22.81f, -9.23f, 3.86f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("R1",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, -0.2f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("R1",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("R2",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, -0.2f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("R2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("R3",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, 0.3f, 0.3f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("R3",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("R4",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, 0.9f, -0.8f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("R4",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(38f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("L1",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, -0.1f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("L1",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("L2",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, -0.2f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("L2",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("L3",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, 0.3f, 0.2f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("L3",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(25f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("L4",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, -0.7f, 0.9f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("L4",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(37.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("IV",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(18.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(-20f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("V",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(6.36f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(-18f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(-22.9f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("VI",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(10.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(-35f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("VII",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.08343333f, KeyframeAnimations.degreeVec(-12.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(-27.5f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(11f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.8343334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR))).build();

}
