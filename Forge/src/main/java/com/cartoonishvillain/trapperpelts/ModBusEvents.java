package com.cartoonishvillain.trapperpelts;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.cartoonishvillain.trapperpelts.Register.BEARTRAPITEM;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBusEvents {
    @SubscribeEvent
    public static void attributeAssigner(EntityAttributeCreationEvent event){
        event.put(Register.BEARTRAP.get(), BearTrap.customAttributes().build());

    }

    @SubscribeEvent
    public static void registerTabs(BuildCreativeModeTabContentsEvent buildContents) {
        if (buildContents.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            buildContents.accept(BEARTRAPITEM);
        }
    }
}
