package me.suxuan.did.entity;

import me.suxuan.did.DID;
import me.suxuan.did.entity.monster.*;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_REGISTER = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DID.MOD_ID);

	public static final RegistryObject<EntityType<WalkingMushroomEntity>> WALKING_MUSHROOM = ENTITY_REGISTER.register("walking_mushroom",
			() -> EntityType.Builder.of(WalkingMushroomEntity::new, MobCategory.CREATURE).sized(0.8f, 1f).build("walking_mushroom"));

	//egg
	public static final RegistryObject<EntityType<LivingArmorEntity>> LIVING_ARMOR = ENTITY_REGISTER.register("living_armor",
			() -> EntityType.Builder.of(LivingArmorEntity::new, MobCategory.CREATURE).sized(1f, 2f).build("living_armor"));

	public static final RegistryObject<EntityType<HugeScorpionEntity>> HUGE_SCORPION = ENTITY_REGISTER.register("huge_scorpion",
			() -> EntityType.Builder.of(HugeScorpionEntity::new, MobCategory.CREATURE).sized(0.8f, 0.8f).build("huge_scorpion"));


	public static final RegistryObject<EntityType<BasiliskEntity>> BASILISK = ENTITY_REGISTER.register("basilisk",
			() -> EntityType.Builder.of(BasiliskEntity::new, MobCategory.CREATURE).sized(1f, 1f).build("basilisk"));

	public static final RegistryObject<EntityType<MimicEntity>> MIMIC = ENTITY_REGISTER.register("mimic",
			() -> EntityType.Builder.of(MimicEntity::new, MobCategory.CREATURE).sized(1f, 1f).build("mimic"));

}
