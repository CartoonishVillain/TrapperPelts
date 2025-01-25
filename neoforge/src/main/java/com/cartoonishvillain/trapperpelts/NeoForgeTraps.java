package com.cartoonishvillain.trapperpelts;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

import static com.cartoonishvillain.trapperpelts.Register.BEARTRAPITEM;

@Mod(Constants.MOD_ID)
public class NeoForgeTraps {
    
    public NeoForgeTraps(IEventBus eventBus) {
        Register.init(eventBus);
    }

    @EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class ModEvents {
        @SubscribeEvent
        public static void attributeAssigner(EntityAttributeCreationEvent event){
            event.put(Register.BEARTRAP.get(), BearTrap.customAttributes().build());
        }

        @SubscribeEvent
        public static void registerTabs(BuildCreativeModeTabContentsEvent buildContents) {
            if (buildContents.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
                buildContents.accept(BEARTRAPITEM.get());
            }
        }
    }
}