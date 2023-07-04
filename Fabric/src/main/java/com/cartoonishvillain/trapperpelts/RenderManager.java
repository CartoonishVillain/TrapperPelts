package com.cartoonishvillain.trapperpelts;

import com.cartoonishvillain.trapperpelts.client.BearTrapModel;
import com.cartoonishvillain.trapperpelts.client.RenderBearTrap;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class RenderManager implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(BearTrapModel.BEARTRAPLAYERLOCATION, BearTrapModel::createBodyLayer);
//        EntityRendererRegistry.register(Register.BEARTRAP, RenderBearTrap::new);
    }
}
