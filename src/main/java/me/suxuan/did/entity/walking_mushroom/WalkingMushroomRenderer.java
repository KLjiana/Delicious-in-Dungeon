package me.suxuan.did.entity.walking_mushroom;

import com.mojang.blaze3d.vertex.PoseStack;
import me.suxuan.did.DeliciousDungeon;
import me.suxuan.did.entity.DIDEntities;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class WalkingMushroomRenderer extends MobRenderer<WalkingMushroomEntity, WalkingMushroomModel<WalkingMushroomEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(DeliciousDungeon.MOD_ID, "textures/entity/walking_mushroom.png");

	public WalkingMushroomRenderer(EntityRendererProvider.Context context) {
		super(context, new WalkingMushroomModel<>(context.bakeLayer(DIDEntities.WALKING_MUSHROOM_LAYER)), 0.4F);
	}

	@Override
	public ResourceLocation getTextureLocation(@NotNull WalkingMushroomEntity walkingMushroomEntity) {
		return TEXTURE;
	}

	@Override
	public void render(WalkingMushroomEntity entity, float yaw, float ticks, PoseStack stack, MultiBufferSource buffer, int light) {
//		float scale = entity.isBaby() ? 0.3F : 1.0F;
		stack.scale(1.0f, 1.0f, 1.0f);
		super.render(entity, yaw, ticks, stack, buffer, light);
	}

}
