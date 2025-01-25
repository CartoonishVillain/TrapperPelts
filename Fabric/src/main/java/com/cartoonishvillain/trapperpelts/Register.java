package com.cartoonishvillain.trapperpelts;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import static com.cartoonishvillain.trapperpelts.Constants.MOD_ID;

public class Register {

    public static Supplier<Item> BEARTRAPITEM;
    public static Supplier<EntityType<BearTrap>> BEARTRAP;

    public static void init() {
        BEARTRAPITEM = registerItem("beartrapitem", new TrapItem(new Item.Properties(), Component.translatable("item.trapperpelts.beartrapdesc").withStyle(ChatFormatting.RED), Component.translatable("item.trapperpelts.beartrapdesc2").withStyle(ChatFormatting.RED)));
        BEARTRAP = registerBearTrapEntityType("beartrap", EntityType.Builder.of(BearTrap::new, MobCategory.MONSTER).sized(0.8f, 1).build("beartrap"));

        FabricDefaultAttributeRegistry.register(BEARTRAP.get(), BearTrap.customAttributes());
    }

    private static Supplier<Item> registerItem(String name, Item item) {
        Item registered = Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name), item);
        return () -> registered;
    }

    private static Supplier<EntityType<BearTrap>> registerBearTrapEntityType(String name, EntityType<?> entityType) {
        EntityType<?> registered = Registry.register(BuiltInRegistries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name), entityType);
        return () -> (EntityType<BearTrap>) registered;
    }

}
