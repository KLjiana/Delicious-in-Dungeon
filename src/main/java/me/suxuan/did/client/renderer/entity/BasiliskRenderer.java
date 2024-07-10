package me.suxuan.did.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import me.suxuan.did.DID;
import me.suxuan.did.client.ModClient;
import me.suxuan.did.client.model.entity.BasiliskModel;
import me.suxuan.did.entity.ModEntities;
import me.suxuan.did.entity.monster.BasiliskEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class BasiliskRenderer extends MobRenderer<BasiliskEntity, BasiliskModel<BasiliskEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(DID.MOD_ID, "textures/entity/basilisk.png");

	public BasiliskRenderer(EntityRendererProvider.Context context) {
		super(context, new BasiliskModel<>(context.bakeLayer(ModClient.BASILISK_LAYER)), 0.4F);
	}

	@Override
	public ResourceLocation getTextureLocation(@NotNull BasiliskEntity basiliskEntity) {
		return TEXTURE;
	}

	@Override
	public void render(BasiliskEntity entity, float yaw, float ticks, PoseStack stack, MultiBufferSource buffer, int light) {
//		float scale = entity.isBaby() ? 0.3F : 1.0F;
		stack.scale(1.0f, 1.0f, 1.0f);
		super.render(entity, yaw, ticks, stack, buffer, light);
	}

}
