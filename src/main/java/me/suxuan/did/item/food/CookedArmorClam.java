package me.suxuan.did.item.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CookedArmorClam extends Item {
    public CookedArmorClam() {
        super(new Properties().food(new FoodProperties.Builder()
                .nutrition(6)
                .saturationMod(6.0F)
                .build()));
    }
}
