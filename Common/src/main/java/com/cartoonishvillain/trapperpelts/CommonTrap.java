package com.cartoonishvillain.trapperpelts;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class CommonTrap {

    // This method serves as an initialization hook for the mod. The vanilla
    // game has no mechanism to load tooltip listeners so this must be
    // invoked from a mod loader specific project like Forge or Fabric.

    public static final TagKey<EntityType<?>> SMALLGAME = TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "trap_small_game"));
    public static final TagKey<EntityType<?>> NOGAME = TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "trap_no_game"));

    public static void init() {

    }
}