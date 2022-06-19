package com.cartoonishvillain.trapperpelts;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.cartoonishvillain.trapperpelts.Constants.MOD_ID;

public class Register {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static void init() {
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }
    public static final RegistryObject<Item> BEARTRAPITEM = ITEMS.register("beartrapitem", () -> new TrapItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), Component.translatable("item.trapperpelts.beartrapdesc").withStyle(ChatFormatting.RED)));

    public static final RegistryObject<EntityType<BearTrap>> BEARTRAP = ENTITY_TYPES.register("beartrap", () -> EntityType.Builder.of(BearTrap::new, MobCategory.MONSTER).sized(0.8f, 1f).build(new ResourceLocation(MOD_ID, "beartrap").toString()));


}
