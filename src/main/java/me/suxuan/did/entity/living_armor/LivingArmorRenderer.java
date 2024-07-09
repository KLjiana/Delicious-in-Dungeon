package me.suxuan.did.entity.living_armor;

import com.mojang.blaze3d.vertex.PoseStack;
import me.suxuan.did.DeliciousDungeon;
import me.suxuan.did.entity.DIDEntities;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LivingArmorRenderer extends MobRenderer<LivingArmorEntity, LivingArmorModel<LivingArmorEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(DeliciousDungeon.MOD_ID,
			"textures/entity/living_armor.png");

	public LivingArmorRenderer(EntityRendererProvider.Context context) {
		super(context, new LivingArmorModel<>(context.bakeLayer(DIDEntities.LIVING_ARMOR_LAYER)), 0.4F);
	}

	@Override
	public ResourceLocation getTextureLocation(LivingArmorEntity livingArmorEntity) {
		return TEXTURE;
	}

	@Override
	public void render(LivingArmorEntity entity, float yaw, float ticks, PoseStack stack, MultiBufferSource buffer, int light) {
//		float scale = entity.isBaby() ? 0.3F : 1.0F;
		stack.scale(1.0f, 1.0f, 1.0f);
		super.render(entity, yaw, ticks, stack, buffer, light);
	}

}
