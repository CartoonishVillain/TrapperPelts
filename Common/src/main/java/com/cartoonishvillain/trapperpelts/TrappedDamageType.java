package com.cartoonishvillain.trapperpelts;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class TrappedDamageType {
    public static final ResourceKey<DamageType> TRAPPED =  ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(Constants.MOD_ID, "trapperdamage"));
}
