package com.cartoonishvillain.trapperpelts;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import static com.cartoonishvillain.trapperpelts.Constants.MOD_ID;

public class Register {

    public static final Item BEARTRAPITEM = new TrapItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC), Component.translatable("item.trapperpelts.beartrapdesc").withStyle(ChatFormatting.RED), Component.translatable("item.trapperpelts.beartrapdesc2").withStyle(ChatFormatting.RED));

    public static final EntityType<BearTrap> BEARTRAP = Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(MOD_ID, "beartrap"), FabricEntityTypeBuilder.create(MobCategory.MONSTER, BearTrap::new).dimensions(EntityDimensions.fixed(0.8f, 1)).build());

    public static void init() {
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "beartrapitem"), BEARTRAPITEM);

        FabricDefaultAttributeRegistry.register(BEARTRAP, BearTrap.customAttributes());

    }

}
