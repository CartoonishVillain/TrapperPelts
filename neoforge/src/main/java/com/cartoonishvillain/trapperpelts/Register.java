package com.cartoonishvillain.trapperpelts;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.cartoonishvillain.trapperpelts.Constants.MOD_ID;

public class Register {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MOD_ID);

    public static DeferredHolder<EntityType<?>, EntityType<BearTrap>> BEARTRAP;
    public static DeferredHolder<Item, Item> BEARTRAPITEM;

    public static void init(IEventBus modbus) {
        BEARTRAP = ENTITY_TYPES.register("beartrap", () -> EntityType.Builder.of(BearTrap::new, MobCategory.MONSTER).sized(0.8f, 1f).build(ResourceLocation.fromNamespaceAndPath(MOD_ID, "beartrap").toString()));
        BEARTRAPITEM = ITEMS.register("beartrapitem", () -> new TrapItem(new Item.Properties(), Component.translatable("item.trapperpelts.beartrapdesc").withStyle(ChatFormatting.RED)));
        ENTITY_TYPES.register(modbus);
        ITEMS.register(modbus);
    }



}
