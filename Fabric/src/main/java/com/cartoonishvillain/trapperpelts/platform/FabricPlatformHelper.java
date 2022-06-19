package com.cartoonishvillain.trapperpelts.platform;

import com.cartoonishvillain.trapperpelts.BearTrap;
import com.cartoonishvillain.trapperpelts.Register;
import com.cartoonishvillain.trapperpelts.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.entity.EntityType;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public EntityType<BearTrap> getTrapEntityType() {
        return Register.BEARTRAP;
    }
}
