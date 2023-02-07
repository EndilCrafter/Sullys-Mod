package com.uraneptus.sullysmod.common.entities;

import com.uraneptus.sullysmod.core.other.tags.SMItemTags;
import com.uraneptus.sullysmod.core.registry.SMEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class Chameleon extends Animal implements IAnimatable {
    public static final EntityDataAccessor<Integer> CURRENT_COLOR = SynchedEntityData.defineId(Chameleon.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> TARGET_COLOR = SynchedEntityData.defineId(Chameleon.class, EntityDataSerializers.INT);

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public static final Ingredient FOOD_ITEMS = Ingredient.of(SMItemTags.CHAMELEON_FOOD);

    public Chameleon(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return SMEntityTypes.CHAMELEON.get().create(level);
    }

    public <E extends IAnimatable> PlayState setAnimation(AnimationEvent<E> event) {
        boolean onGround = isOnGround();

        if (!((double) animationSpeed < 0.02D) && onGround) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.chameleon.walk", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }

        return PlayState.STOP;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 3, this::setAnimation));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    public int getCurrentColor() {
        return this.entityData.get(CURRENT_COLOR);
    }

    public void setCurrentColor(int color) {
        this.entityData.set(CURRENT_COLOR, color);
    }

    public int getTargetColor() {
        return this.entityData.get(TARGET_COLOR);
    }

    public void setTargetColor(int color) {
        this.entityData.set(TARGET_COLOR, color);
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new BreedGoal(this, 0.6D));
        goalSelector.addGoal(2, new TemptGoal(this, 0.6D, FOOD_ITEMS, false));
        goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.5D));
        goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0F));
        goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }

    @Override
    public void tick() {
        super.tick();
        BlockPos floorPos = this.blockPosition().below();
        BlockState floor = level.getBlockState(floorPos);
        int floorColor = floor.getMapColor(level, floorPos).col;

        if (this.getTargetColor() != floorColor && floorColor != 0) {
            this.setTargetColor(floorColor);
        }
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return FOOD_ITEMS.test(pStack);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CURRENT_COLOR, 0);
        this.entityData.define(TARGET_COLOR, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putInt("currentColor", getCurrentColor());
        nbt.putInt("targetColor", getTargetColor());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        nbt.getInt("currentColor");
        nbt.getInt("targetColor");
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.28D)
                .add(Attributes.MAX_HEALTH, 10.0D);
    }
}
