package me.suxuan.did.item;

import me.suxuan.did.DID;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DIDTab {

	public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB_REGISTER =
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DID.MOD_ID);

	public static final RegistryObject<CreativeModeTab> DELICIOUS_TAB = CREATIVE_TAB_REGISTER.register("rings_tab",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("creativetab.did.did"))
					.icon(() -> new ItemStack(DIDItems.SCORPION.get()))
					.displayItems((parameters, output) -> {
						DIDItems.ITEM_REGISTER.getEntries().forEach((items -> output.accept(items.get().asItem())));
					})
					.build());
}
