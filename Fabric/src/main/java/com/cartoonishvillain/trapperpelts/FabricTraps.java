package com.cartoonishvillain.trapperpelts;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;

public class FabricTraps implements ModInitializer {
    
    @Override
    public void onInitialize() {
        CommonTrap.init();
//        Register.init();
    }
}
