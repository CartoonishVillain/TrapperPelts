package com.cartoonishvillain.trapperpelts.events;

import com.cartoonishvillain.trapperpelts.BearTrap;
import com.cartoonishvillain.trapperpelts.Register;
import com.cartoonishvillain.trapperpelts.TrapperPelts;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TrapperPelts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBusEvents {
    @SubscribeEvent
    public static void attributeAssigner(EntityAttributeCreationEvent event){
        event.put(Register.BEARTRAP.get(), BearTrap.customAttributes().build());

    }
}
