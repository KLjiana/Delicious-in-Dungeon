package me.suxuan.did.item;

import me.suxuan.did.DeliciousDungeon;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class DIDItems {

	public static final DeferredRegister<Item> ITEM_REGISTER =
			DeferredRegister.create(ForgeRegistries.ITEMS, DeliciousDungeon.MOD_ID);

	// Raw Scorpion
	public static final RegistryObject<Item> SCORPION = ITEM_REGISTER.register("scorpion",
			() -> new Item(new Item.Properties().food(new FoodProperties.Builder()
					.nutrition(2)
					.saturationMod(1.0F)
					.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200, 0), 0.5F)
					.build())));

	// Cooked Scorpion
	public static final RegistryObject<Item> COOKED_SCORPION = ITEM_REGISTER.register("cooked_scorpion",
			() -> new Item(new Item.Properties().food(new FoodProperties.Builder()
					.nutrition(6)
					.saturationMod(6.0F)
					.build())));

	// Raw Armor Clam
	public static final RegistryObject<Item> ARMOR_CLAM = ITEM_REGISTER.register("armor_clam",
			() -> new Item(new Item.Properties().food(new FoodProperties.Builder()
					.nutrition(1)
					.saturationMod(1.0F)
					.effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200, 0), 1.0F)
					.build())));

	// Cooked Armor Clam
	public static final RegistryObject<Item> COOKED_ARMOR_CLAM = ITEM_REGISTER.register("cooked_armor_clam",
			() -> new Item(new Item.Properties().food(new FoodProperties.Builder()
					.nutrition(6)
					.saturationMod(6.0F)
					.build())));

	// Armor Plate
	public static final RegistryObject<Item> ARMOR_PLATE = ITEM_REGISTER.register("armor_plate",
			() -> new Item(new Item.Properties()));

	// Walking Mushroom Spawn Egg
//	public static final RegistryObject<Item> WALKING_MUSHROOM_SPAWN_EGG = ITEM_REGISTER.register("walking_mushroom_spawn_egg",
//			() -> new ForgeSpawnEggItem(DIDEntities.WALKING_MUSHROOM, 0xff0000, 0xffffff, new Item.Properties()));

	// Living Armor Spawn Egg
//	public static final RegistryObject<Item> LIVING_ARMOR_SPAWN_EGG = ITEM_REGISTER.register("living_armor_spawn_egg",
//			() -> new ForgeSpawnEggItem(DIDEntities.LIVING_ARMOR, 0x202020, 0xe0e0e0, new Item.Properties()));

	// Huge Scorpion Spawn Egg
//	public static final RegistryObject<Item> HUGE_SCORPION_SPAWN_EGG = ITEM_REGISTER.register("huge_scorpion_spawn_egg",
//			() -> new ForgeSpawnEggItem(DIDEntities.HUGE_SCORPION, 0x202020, 0xe0e0e0, new Item.Properties()));

	// Basilisk Spawn Egg
//	public static final RegistryObject<Item> BASILISK_SPAWN_EGG = ITEM_REGISTER.register("basilisk_spawn_egg",
//			() -> new ForgeSpawnEggItem(DIDEntities.BASILISK, 0x202020, 0xe0e0e0, new Item.Properties()));

	// Elite Living Armor Spawn Egg
//	public static final RegistryObject<Item> ELITE_LIVING_ARMOR_SPAWN_EGG = ITEM_REGISTER.register("elite_living_armor_spawn_egg",
//			() -> new ForgeSpawnEggItem(DIDEntities.ELITE_LIVING_ARMOR, 0x202020, 0xe0e0e0, new Item.Properties()));

	// Mimic Living Armor Spawn Egg
//	public static final RegistryObject<Item> MIMIC_SPAWN_EGG = ITEM_REGISTER.register("mimic_spawn_egg",
//			() -> new ForgeSpawnEggItem(DIDEntities.MIMIC, 0x202020, 0xe0e0e0, new Item.Properties()));

}
