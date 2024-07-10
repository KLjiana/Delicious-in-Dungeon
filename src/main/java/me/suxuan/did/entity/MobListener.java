package me.suxuan.did.entity;

import me.suxuan.did.client.ModClient;
import me.suxuan.did.client.model.entity.*;
import me.suxuan.did.client.renderer.entity.*;
import me.suxuan.did.entity.monster.*;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class MobListener {
    @SubscribeEvent
    public void onAttributesRegister(EntityAttributeCreationEvent event) {
        event.put(ModEntities.WALKING_MUSHROOM.get(), WalkingMushroomEntity.createAttributes().build());
        event.put(ModEntities.LIVING_ARMOR.get(), LivingArmorEntity.createAttributes().build());
        event.put(ModEntities.HUGE_SCORPION.get(), HugeScorpionEntity.createAttributes().build());
        event.put(ModEntities.BASILISK.get(), BasiliskEntity.createAttributes().build());
        event.put(ModEntities.MIMIC.get(), MimicEntity.createAttributes().build());
    }
    @SubscribeEvent
    public void onLayerDefinitionsRegister(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModClient.WALKING_MUSHROOM_LAYER, WalkingMushroomModel::createBodyLayer);
        event.registerLayerDefinition(ModClient.LIVING_ARMOR_LAYER, LivingArmorModel::createBodyLayer);
        event.registerLayerDefinition(ModClient.HUGE_SCORPION_LAYER, HugeScorpionModel::createBodyLayer);
        event.registerLayerDefinition(ModClient.BASILISK_LAYER, BasiliskModel::createBodyLayer);
        event.registerLayerDefinition(ModClient.MIMIC_LAYER, MimicModel::createBodyLayer);
    }
    @SubscribeEvent
    public void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            EntityRenderers.register(ModEntities.WALKING_MUSHROOM.get(), WalkingMushroomRenderer::new);
            EntityRenderers.register(ModEntities.LIVING_ARMOR.get(), LivingArmorRenderer::new);
            EntityRenderers.register(ModEntities.HUGE_SCORPION.get(), HugeScorpionRenderer::new);
            EntityRenderers.register(ModEntities.BASILISK.get(), BasiliskRenderer::new);
            EntityRenderers.register(ModEntities.MIMIC.get(), MimicRenderer::new);
        });
    }
}
