package com.cartoonishvillain.trapperpelts.platform;

import com.cartoonishvillain.trapperpelts.BearTrap;
import com.cartoonishvillain.trapperpelts.Register;
import com.cartoonishvillain.trapperpelts.platform.services.IPlatformHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "Forge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }

    @Override
    public EntityType<BearTrap> getTrapEntityType() {
        return Register.BEARTRAP.get();
    }
}
