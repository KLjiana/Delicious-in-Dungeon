package me.suxuan.did.listener;

import me.suxuan.did.entity.DIDEntities;
import me.suxuan.did.entity.basilisk.BasiliskEntity;
import me.suxuan.did.client.model.entity.BasiliskModel;
import me.suxuan.did.entity.basilisk.BasiliskRenderer;
import me.suxuan.did.entity.huge_scorpion.HugeScorpionEntity;
import me.suxuan.did.client.model.entity.HugeScorpionModel;
import me.suxuan.did.entity.huge_scorpion.HugeScorpionRenderer;
import me.suxuan.did.entity.living_armor.LivingArmorEntity;
import me.suxuan.did.entity.living_armor.LivingArmorModel;
import me.suxuan.did.entity.living_armor.LivingArmorRenderer;
import me.suxuan.did.entity.mimic.MimicEntity;
import me.suxuan.did.entity.mimic.MimicModel;
import me.suxuan.did.entity.mimic.MimicRenderer;
import me.suxuan.did.entity.walking_mushroom.WalkingMushroomEntity;
import me.suxuan.did.entity.walking_mushroom.WalkingMushroomModel;
import me.suxuan.did.entity.walking_mushroom.WalkingMushroomRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public final class MobListener {

	@SubscribeEvent
	public void onClientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			EntityRenderers.register(DIDEntities.WALKING_MUSHROOM.get(), WalkingMushroomRenderer::new);
			EntityRenderers.register(DIDEntities.LIVING_ARMOR.get(), LivingArmorRenderer::new);
			EntityRenderers.register(DIDEntities.HUGE_SCORPION.get(), HugeScorpionRenderer::new);
			EntityRenderers.register(DIDEntities.BASILISK.get(), BasiliskRenderer::new);
//			EntityRenderers.register(DIDEntities.ELITE_LIVING_ARMOR.get(), EliteLivingArmorRenderer::new);
			EntityRenderers.register(DIDEntities.MIMIC.get(), MimicRenderer::new);
		});
	}

	@SubscribeEvent
	public void onLayerDefinitionsRegister(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(DIDEntities.WALKING_MUSHROOM_LAYER, WalkingMushroomModel::createBodyLayer);
		event.registerLayerDefinition(DIDEntities.LIVING_ARMOR_LAYER, LivingArmorModel::createBodyLayer);
		event.registerLayerDefinition(DIDEntities.HUGE_SCORPION_LAYER, HugeScorpionModel::createBodyLayer);
		event.registerLayerDefinition(DIDEntities.BASILISK_LAYER, BasiliskModel::createBodyLayer);
//		event.registerLayerDefinition(DIDEntities.ELITE_LIVING_ARMOR_LAYER, EliteLivingArmorModel::createBodyLayer);
		event.registerLayerDefinition(DIDEntities.MIMIC_LAYER, MimicModel::createBodyLayer);
	}

	@SubscribeEvent
	public void onAttributesRegister(EntityAttributeCreationEvent event) {
		event.put(DIDEntities.WALKING_MUSHROOM.get(), WalkingMushroomEntity.createAttributes().build());
		event.put(DIDEntities.LIVING_ARMOR.get(), LivingArmorEntity.createAttributes().build());
		event.put(DIDEntities.HUGE_SCORPION.get(), HugeScorpionEntity.createAttributes().build());
		event.put(DIDEntities.BASILISK.get(), BasiliskEntity.createAttributes().build());
//		event.put(DIDEntities.ELITE_LIVING_ARMOR.get(), EliteLivingArmorEntity.createAttributes().build());
		event.put(DIDEntities.MIMIC.get(), MimicEntity.createAttributes().build());
	}

}
