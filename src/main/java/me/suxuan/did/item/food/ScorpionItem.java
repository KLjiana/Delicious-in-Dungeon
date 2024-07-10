package me.suxuan.did.item.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class ScorpionItem extends Item {
    public ScorpionItem() {
        super(new Properties().food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(1.0F)
                .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200, 0), 0.5F)
                .build()));
    }
}
