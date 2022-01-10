package com.cartoonishvillain.trapperpelts;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class BearTrap extends Mob {
    private static final EntityDataAccessor<Boolean> BOOLEAN_TRIGGERED = SynchedEntityData.defineId(BearTrap.class, EntityDataSerializers.BOOLEAN);

    int timeAfterTrigger = 20;
    int primingTime = 80;

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BOOLEAN_TRIGGERED, false);
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
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_21450_) {
        super.readAdditionalSaveData(p_21450_);
        setTriggered(p_21450_.getBoolean("triggered"));
    }

    public boolean getTriggered() {
        return this.entityData.get(BOOLEAN_TRIGGERED);
    }

    public void setTriggered(boolean value) {
        this.entityData.set(BOOLEAN_TRIGGERED, value);
    }

    @Override
    public void push(Entity victim) {
        if(!getTriggered() && primingTime <= 0) {
            victim.hurt(Trapped.causeTrapDamage(victim), 35);
            setTriggered(true);
            this.level.playSound(null, this, SoundEvents.EVOKER_FANGS_ATTACK, SoundSource.HOSTILE, 1, 1);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if(primingTime > 0){
            primingTime--;
        }

        if(getTriggered()){
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

}
