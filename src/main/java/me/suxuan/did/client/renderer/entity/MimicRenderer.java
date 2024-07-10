package me.suxuan.did.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import me.suxuan.did.DID;
import me.suxuan.did.client.ModClient;
import me.suxuan.did.client.model.entity.MimicModel;
import me.suxuan.did.entity.ModEntities;
import me.suxuan.did.entity.monster.MimicEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class MimicRenderer extends MobRenderer<MimicEntity, MimicModel<MimicEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(DID.MOD_ID, "textures/entity/mimic.png");

	public MimicRenderer(EntityRendererProvider.Context context) {
		super(context, new MimicModel<>(context.bakeLayer(ModClient.MIMIC_LAYER)), 0.4F);
	}

	@Override
	public ResourceLocation getTextureLocation(@NotNull MimicEntity mimicEntity) {
		return TEXTURE;
	}

	@Override
	public void render(MimicEntity entity, float yaw, float ticks, PoseStack stack, MultiBufferSource buffer, int light) {
//		float scale = entity.isBaby() ? 0.3F : 1.0F;
		stack.scale(1.0f, 1.0f, 1.0f);
		super.render(entity, yaw, ticks, stack, buffer, light);
	}

}
