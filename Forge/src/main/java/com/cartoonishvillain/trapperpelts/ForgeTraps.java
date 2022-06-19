package com.cartoonishvillain.trapperpelts;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class ForgeTraps {
    
    public ForgeTraps() {
        Register.init();
    }
}