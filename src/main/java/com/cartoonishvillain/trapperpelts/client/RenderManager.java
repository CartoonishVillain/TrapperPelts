package com.cartoonishvillain.trapperpelts.client;

import com.cartoonishvillain.trapperpelts.Register;
import com.cartoonishvillain.trapperpelts.TrapperPelts;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TrapperPelts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RenderManager {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(BearTrapModel.BEARTRAPLAYERLOCATION, BearTrapModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(Register.BEARTRAP.get(), RenderBearTrap::new);
    }
}
