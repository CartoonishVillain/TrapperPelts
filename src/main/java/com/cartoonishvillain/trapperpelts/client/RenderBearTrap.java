package com.cartoonishvillain.trapperpelts.client;

import com.cartoonishvillain.trapperpelts.BearTrap;
import com.cartoonishvillain.trapperpelts.TrapperPelts;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderBearTrap extends MobRenderer<BearTrap, BearTrapModel<BearTrap>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(TrapperPelts.MOD_ID, "textures/entity/beartrap.png");

    protected RenderBearTrap(EntityRendererProvider.Context p_174008_) {
        super(p_174008_, new BearTrapModel<>(p_174008_.bakeLayer(BearTrapModel.BEARTRAPLAYERLOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(BearTrap p_114482_) {
        return TEXTURE;
    }
}
