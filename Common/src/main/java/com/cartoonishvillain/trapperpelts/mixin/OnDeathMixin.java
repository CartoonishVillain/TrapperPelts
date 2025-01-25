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

import java.util.function.Predicate;

import static com.cartoonishvillain.trapperpelts.TrappedDamageType.TRAPPED;

@Mixin(LivingEntity.class)
public class OnDeathMixin {
	@Inject(at = @At("HEAD"), method = "die")
	private void trapperDamageDie(DamageSource source, CallbackInfo info) {
		LivingEntity deadEntity = ((LivingEntity) (Object) this);
		if(!deadEntity.level().isClientSide() && source.is(TRAPPED)){
			ItemEntity itemEntity = null;
			int num = deadEntity.getRandom().nextInt(4);
			if (deadEntity.getType().is(CommonTrap.NOGAME)) {
				//do nothing, as there is no leather attached to the entity, or it was too hard for the bear trap to pull off.
			} else if (deadEntity.getType().is(CommonTrap.SMALLGAME)) {
				itemEntity = new ItemEntity(deadEntity.level(), deadEntity.getX(), deadEntity.getY(), deadEntity.getZ(), new ItemStack(Items.RABBIT_HIDE, num+1));
			} else {
				itemEntity = new ItemEntity(deadEntity.level(), deadEntity.getX(), deadEntity.getY(), deadEntity.getZ(), new ItemStack(Items.LEATHER, num+1));
			}

			if (itemEntity != null) {
				deadEntity.level().addFreshEntity(itemEntity);
			}
		}
	}
}
