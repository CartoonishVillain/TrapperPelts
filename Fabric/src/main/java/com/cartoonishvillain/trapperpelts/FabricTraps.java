package com.cartoonishvillain.trapperpelts;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;

public class FabricTraps implements ModInitializer {
    
    @Override
    public void onInitialize() {
        CommonTrap.init();
        Register.init();

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(content -> {
            content.accept(Register.BEARTRAPITEM.get());
        });
    }
}
