package com.cartoonishvillain.trapperpelts;

import net.minecraft.world.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class CommonTrap {

    // This method serves as an initialization hook for the mod. The vanilla
    // game has no mechanism to load tooltip listeners so this must be
    // invoked from a mod loader specific project like Forge or Fabric.

    public static ArrayList<EntityType> SMALLGAME = new ArrayList<>(List.of(EntityType.SILVERFISH, EntityType.PLAYER, EntityType.ENDERMITE, EntityType.RABBIT, EntityType.CHICKEN, EntityType.BEE, EntityType.AXOLOTL, EntityType.CAT, EntityType.WITHER, EntityType.ENDER_DRAGON));

    public static void init() {

    }
}