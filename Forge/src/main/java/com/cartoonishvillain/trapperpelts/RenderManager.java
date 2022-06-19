package com.cartoonishvillain.trapperpelts;

import com.cartoonishvillain.trapperpelts.client.BearTrapModel;
import com.cartoonishvillain.trapperpelts.client.RenderBearTrap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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
