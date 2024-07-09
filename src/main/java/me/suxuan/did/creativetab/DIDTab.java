package me.suxuan.did.creativetab;

import me.suxuan.did.DeliciousDungeon;
import me.suxuan.did.item.DIDItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DIDTab {

	public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB_REGISTER =
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DeliciousDungeon.MOD_ID);

	public static final RegistryObject<CreativeModeTab> DELICIOUS_TAB = CREATIVE_TAB_REGISTER.register("rings_tab",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("tab.did.tab"))
					.icon(() -> new ItemStack(DIDItems.SCORPION.get()))
					.displayItems((parameters, output) -> {
						DIDItems.ITEM_REGISTER.getEntries().forEach((items -> output.accept(items.get().asItem())));
					})
					.build());
}
