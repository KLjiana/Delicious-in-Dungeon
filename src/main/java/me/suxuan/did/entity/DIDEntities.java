package me.suxuan.did.entity;

import me.suxuan.did.DeliciousDungeon;
import me.suxuan.did.entity.basilisk.BasiliskEntity;
import me.suxuan.did.entity.huge_scorpion.HugeScorpionEntity;
import me.suxuan.did.entity.living_armor.LivingArmorEntity;
import me.suxuan.did.entity.mimic.MimicEntity;
import me.suxuan.did.entity.walking_mushroom.WalkingMushroomEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DIDEntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_REGISTER =
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DeliciousDungeon.MOD_ID);

	public static final RegistryObject<EntityType<WalkingMushroomEntity>> WALKING_MUSHROOM = ENTITY_REGISTER.register("walking_mushroom",
			() -> EntityType.Builder.of(WalkingMushroomEntity::new, MobCategory.CREATURE).sized(0.8f, 1f).build("walking_mushroom"));
	public static final ModelLayerLocation WALKING_MUSHROOM_LAYER = new ModelLayerLocation(
			new ResourceLocation(DeliciousDungeon.MOD_ID, "walking_mushroom_layer"), "walking_mushroom_layer");

	public static final RegistryObject<EntityType<LivingArmorEntity>> LIVING_ARMOR = ENTITY_REGISTER.register("living_armor",
			() -> EntityType.Builder.of(LivingArmorEntity::new, MobCategory.CREATURE).sized(1f, 2f).build("living_armor"));
	public static final ModelLayerLocation LIVING_ARMOR_LAYER = new ModelLayerLocation(
			new ResourceLocation(DeliciousDungeon.MOD_ID, "living_armor_layer"), "living_armor_layer");

	public static final RegistryObject<EntityType<HugeScorpionEntity>> HUGE_SCORPION = ENTITY_REGISTER.register("huge_scorpion",
			() -> EntityType.Builder.of(HugeScorpionEntity::new, MobCategory.CREATURE).sized(0.8f, 0.8f).build("huge_scorpion"));
	public static final ModelLayerLocation HUGE_SCORPION_LAYER = new ModelLayerLocation(
			new ResourceLocation(DeliciousDungeon.MOD_ID, "huge_scorpion_layer"), "huge_scorpion_layer");

	public static final RegistryObject<EntityType<BasiliskEntity>> BASILISK = ENTITY_REGISTER.register("basilisk",
			() -> EntityType.Builder.of(BasiliskEntity::new, MobCategory.CREATURE).sized(1f, 1f).build("basilisk"));
	public static final ModelLayerLocation BASILISK_LAYER = new ModelLayerLocation(
			new ResourceLocation(DeliciousDungeon.MOD_ID, "basilisk_layer"), "basilisk_layer");

//	public static final RegistryObject<EntityType<EliteLivingArmorEntity>> ELITE_LIVING_ARMOR = ENTITY_REGISTER.register("elite_living_armor",
//			() -> EntityType.Builder.of(EliteLivingArmorEntity::new, MobCategory.CREATURE).sized(1f, 1f).build("elite_living_armor"));
//	public static final ModelLayerLocation ELITE_LIVING_ARMOR_LAYER = new ModelLayerLocation(
//			new ResourceLocation(DeliciousDungeon.MOD_ID, "elite_living_armor_layer"), "elite_living_armor_layer");

	public static final RegistryObject<EntityType<MimicEntity>> MIMIC = ENTITY_REGISTER.register("mimic",
			() -> EntityType.Builder.of(MimicEntity::new, MobCategory.CREATURE).sized(1f, 1f).build("mimic"));
	public static final ModelLayerLocation MIMIC_LAYER = new ModelLayerLocation(
			new ResourceLocation(DeliciousDungeon.MOD_ID, "mimic_layer"), "mimic_layer");
}
