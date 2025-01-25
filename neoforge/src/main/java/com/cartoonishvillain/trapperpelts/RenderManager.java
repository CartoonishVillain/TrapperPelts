package com.cartoonishvillain.trapperpelts;

import com.cartoonishvillain.trapperpelts.client.BearTrapModel;
import com.cartoonishvillain.trapperpelts.client.RenderBearTrap;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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
