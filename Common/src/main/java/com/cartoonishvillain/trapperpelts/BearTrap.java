package com.cartoonishvillain.trapperpelts;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class BearTrap extends Mob {
    private static final EntityDataAccessor<Boolean> BOOLEAN_TRIGGERED = SynchedEntityData.defineId(BearTrap.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> TRIGGERCOUNT = SynchedEntityData.defineId(BearTrap.class, EntityDataSerializers.INT);

    int resetTime = 0;
    int timeAfterTrigger = 20;
    int primingTime = 80;

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BOOLEAN_TRIGGERED, false);
        this.entityData.define(TRIGGERCOUNT, 0);
    }

    protected BearTrap(EntityType<? extends Mob> p_21368_, Level p_21369_) {
        super(p_21368_, p_21369_);

    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource p_21239_) {
        return SoundEvents.IRON_GOLEM_DAMAGE;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ANVIL_DESTROY;
    }



    @Override
    public void addAdditionalSaveData(CompoundTag p_21484_) {
        super.addAdditionalSaveData(p_21484_);
        p_21484_.putBoolean("triggered", getTriggered());
        p_21484_.putInt("triggercount", getTriggerCount());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_21450_) {
        super.readAdditionalSaveData(p_21450_);
        setTriggered(p_21450_.getBoolean("triggered"));
        setTriggerCount(p_21450_.getInt("triggercount"));
    }

    public boolean getTriggered() {
        return this.entityData.get(BOOLEAN_TRIGGERED);
    }

    public void setTriggered(boolean value) {
        this.entityData.set(BOOLEAN_TRIGGERED, value);
    }

    public int getTriggerCount() {return this.entityData.get(TRIGGERCOUNT);}

    public void setTriggerCount(int count) {this.entityData.set(TRIGGERCOUNT, count);}

    @Override
    public void push(Entity victim) {
        if(!getTriggered() && primingTime <= 0) {
            victim.hurt(Trapped.causeTrapDamage(victim), 22.5f);
            setTriggered(true);
            setTriggerCount(getTriggerCount()+1);
            this.level.playSound(null, this, SoundEvents.EVOKER_FANGS_ATTACK, SoundSource.HOSTILE, 1, 1);

            if(victim.isAlive() && victim instanceof LivingEntity) {
                ((LivingEntity) victim).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 70, 1));
            }
        }
    }

    @Override
    public void tick() {
        super.tick();

        if(tickCount == 5) {
            setPersistenceRequired();
        }

        if(primingTime > 0){
            primingTime--;
        }

        if(resetTime > 0){
            resetTime--;
            //If this causes the reset time to be 0...
            if(resetTime > 0){
                this.level.playSound(null, this, SoundEvents.IRON_TRAPDOOR_OPEN, SoundSource.BLOCKS, 1.5f, 1);
                this.setTriggered(false);
            }
        }

        if(getTriggered() && getTriggerCount() >= 3){
            timeAfterTrigger--;
            if(timeAfterTrigger <= 0){
                this.remove(RemovalReason.DISCARDED);
            }
        }
    }

    @Override
    public boolean isInvulnerable() {
        return true;
    }

    public static AttributeSupplier.Builder customAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30)
                .add(Attributes.KNOCKBACK_RESISTANCE, 3);
    }

    @Override
    protected InteractionResult mobInteract(Player p_21472_, InteractionHand p_21473_) {
        if(!p_21472_.level.isClientSide && p_21473_.equals(InteractionHand.MAIN_HAND) && timeAfterTrigger >= 20 && !(getTriggerCount() >= 3) && getTriggered()){
            resetTime = 10;
        }

        return super.mobInteract(p_21472_, p_21473_);
    }
}