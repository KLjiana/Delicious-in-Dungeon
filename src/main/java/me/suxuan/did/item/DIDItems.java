package me.suxuan.did.item;

import me.suxuan.did.DID;
import me.suxuan.did.entity.ModEntities;
import me.suxuan.did.item.food.ArmorClam;
import me.suxuan.did.item.food.CookedArmorClam;
import me.suxuan.did.item.food.CookedScorpionItem;
import me.suxuan.did.item.food.ScorpionItem;
import me.suxuan.did.item.material.ArmorPlate;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class DIDItems {

	public static final DeferredRegister<Item> ITEM_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, DID.MOD_ID);
	public static final RegistryObject<Item> SCORPION = ITEM_REGISTER.register("scorpion", ScorpionItem::new);
	public static final RegistryObject<Item> COOKED_SCORPION = ITEM_REGISTER.register("cooked_scorpion", CookedScorpionItem::new);
	public static final RegistryObject<Item> ARMOR_CLAM = ITEM_REGISTER.register("armor_clam", ArmorClam::new);
	public static final RegistryObject<Item> COOKED_ARMOR_CLAM = ITEM_REGISTER.register("cooked_armor_clam", CookedArmorClam::new);
	public static final RegistryObject<Item> ARMOR_PLATE = ITEM_REGISTER.register("armor_plate", ArmorPlate::new);

 	public static final RegistryObject<Item> WALKING_MUSHROOM_SPAWN_EGG = ITEM_REGISTER.register("walking_mushroom_spawn_egg",
			() -> new ForgeSpawnEggItem(ModEntities.WALKING_MUSHROOM, 0xff0000, 0xffffff, new Item.Properties()));

	public static final RegistryObject<Item> LIVING_ARMOR_SPAWN_EGG = ITEM_REGISTER.register("living_armor_spawn_egg",
			() -> new ForgeSpawnEggItem(ModEntities.LIVING_ARMOR, 0x202020, 0xe0e0e0, new Item.Properties()));

	public static final RegistryObject<Item> HUGE_SCORPION_SPAWN_EGG = ITEM_REGISTER.register("huge_scorpion_spawn_egg",
			() -> new ForgeSpawnEggItem(ModEntities.HUGE_SCORPION, 0x005c8b, 0x8b0000, new Item.Properties()));

	public static final RegistryObject<Item> BASILISK_SPAWN_EGG = ITEM_REGISTER.register("basilisk_spawn_egg",
			() -> new ForgeSpawnEggItem(ModEntities.BASILISK, 0x202020, 0xe0e0e0, new Item.Properties()));

	public static final RegistryObject<Item> MIMIC_SPAWN_EGG = ITEM_REGISTER.register("mimic_spawn_egg",
			() -> new ForgeSpawnEggItem(ModEntities.MIMIC, 0x202020, 0xe0e0e0, new Item.Properties()));

}
