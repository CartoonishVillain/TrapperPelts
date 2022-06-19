package com.cartoonishvillain.trapperpelts;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;

public class Trapped extends DamageSource {
    public Trapped(String p_i1566_1_) {
        super(p_i1566_1_);
    }

    public static DamageSource causeTrapDamage(Entity entity){
        return new EntityDamageSource("trapperdamage", entity);
    }




}
