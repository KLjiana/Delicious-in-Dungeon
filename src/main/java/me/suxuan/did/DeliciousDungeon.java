package me.suxuan.did;

import me.suxuan.did.creativetab.DIDTab;
import me.suxuan.did.entity.DIDEntities;
import me.suxuan.did.item.DIDItems;
import me.suxuan.did.listener.MobListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DeliciousDungeon.MOD_ID)
public class DeliciousDungeon {

	public static final String MOD_ID = "did";

	public DeliciousDungeon() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		// Register items
		DIDItems.ITEM_REGISTER.register(modEventBus);

		// Register creative tab
		DIDTab.CREATIVE_TAB_REGISTER.register(modEventBus);

		// Register entity
		DIDEntities.ENTITY_REGISTER.register(modEventBus);

		MinecraftForge.EVENT_BUS.register(this);

		// Register event
		modEventBus.register(new MobListener());
	}
}
