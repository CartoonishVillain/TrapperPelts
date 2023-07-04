package com.cartoonishvillain.trapperpelts;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.LivingEntity;

public class TrappedDamageSource extends DamageSource {

    public TrappedDamageSource(Holder<DamageType> p_270475_) {
        super(p_270475_);
    }
}
