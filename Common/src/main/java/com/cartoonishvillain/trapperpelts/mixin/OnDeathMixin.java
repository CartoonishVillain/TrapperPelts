package com.cartoonishvillain.trapperpelts.mixin;

import com.cartoonishvillain.trapperpelts.CommonTrap;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.cartoonishvillain.trapperpelts.TrappedDamageType.TRAPPED;

@Mixin(LivingEntity.class)
public class OnDeathMixin {
	@Inject(at = @At("HEAD"), method = "die")
	private void trapperDamageDie(DamageSource source, CallbackInfo info) {
		LivingEntity deadEntity = ((LivingEntity) (Object) this);
		if(!deadEntity.level().isClientSide() && source.is(TRAPPED)){
			ItemEntity itemEntity;
			int num = deadEntity.getRandom().nextInt(4);
			if(CommonTrap.SMALLGAME.contains(deadEntity.getType())) {
				itemEntity = new ItemEntity(deadEntity.level(), deadEntity.getX(), deadEntity.getY(), deadEntity.getZ(), new ItemStack(Items.RABBIT_HIDE, num+1));
			} else {
				itemEntity = new ItemEntity(deadEntity.level(), deadEntity.getX(), deadEntity.getY(), deadEntity.getZ(), new ItemStack(Items.LEATHER, num+1));
			}
			deadEntity.level().addFreshEntity(itemEntity);
		}
	}
}
