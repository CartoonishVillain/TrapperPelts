package com.cartoonishvillain.trapperpelts.events;

import com.cartoonishvillain.trapperpelts.Trapped;
import com.cartoonishvillain.trapperpelts.TrapperPelts;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TrapperPelts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeBusEvents {


    @SubscribeEvent
    public static void Death(LivingDeathEvent event){
        if(!event.getEntityLiving().level.isClientSide() && event.getSource().msgId.contains("trapperdamage")){
                ItemEntity itemEntity;
                int num = event.getEntityLiving().getRandom().nextInt(4);
                if(TrapperPelts.SMALLGAME.contains(event.getEntityLiving().getType())) {
                    itemEntity = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), new ItemStack(Items.RABBIT_HIDE, num+1));
                } else {
                    itemEntity = new ItemEntity(event.getEntityLiving().level, event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ(), new ItemStack(Items.LEATHER, num+1));
                }
                event.getEntityLiving().level.addFreshEntity(itemEntity);
        }
    }
}
