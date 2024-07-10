package me.suxuan.did;

import me.suxuan.did.entity.MobListener;
import me.suxuan.did.entity.ModEntities;
import me.suxuan.did.item.DIDItems;
import me.suxuan.did.item.DIDTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DID.MOD_ID)
public class DID {

	public static final String MOD_ID = "did";

	public DID() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		DIDItems.ITEM_REGISTER.register(modEventBus);

		DIDTab.CREATIVE_TAB_REGISTER.register(modEventBus);

		ModEntities.ENTITY_REGISTER.register(modEventBus);

		MinecraftForge.EVENT_BUS.register(this);

		modEventBus.register(new MobListener());
	}
}
