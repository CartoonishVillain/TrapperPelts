package com.cartoonishvillain.trapperpelts;

import com.cartoonishvillain.trapperpelts.platform.Services;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TrapItem extends Item {
    ArrayList<Component> lore;
    public TrapItem(Properties p_41383_, Component... lore) {
        super(p_41383_);
        this.lore = new ArrayList<>(List.of(lore));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        if(!playerIn.level.isClientSide) {
            playerIn.getCooldowns().addCooldown(this, 100);
            BearTrap bearTrap = new BearTrap(Services.PLATFORM.getTrapEntityType(), playerIn.level);
            bearTrap.setPos(playerIn.getX(), playerIn.getY(), playerIn.getZ());
            playerIn.level.addFreshEntity(bearTrap);
            itemstack.shrink(1);
        }
        return InteractionResultHolder.sidedSuccess(itemstack, worldIn.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
        p_41423_.addAll(lore);
    }
}
