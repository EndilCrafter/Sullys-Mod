package com.uraneptus.sullysmod.core.data.client;

import com.uraneptus.sullysmod.SullysMod;
import com.uraneptus.sullysmod.core.other.TextUtil;
import com.uraneptus.sullysmod.core.registry.SMBlocks;
import com.uraneptus.sullysmod.core.registry.SMEntityTypes;
import com.uraneptus.sullysmod.core.registry.SMItems;
import com.uraneptus.sullysmod.core.registry.SMPotions;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.Supplier;

public class SMLangProvider extends LanguageProvider {

    public SMLangProvider(PackOutput packOutput) {
        super(packOutput, SullysMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        //Blocks
        forBlock(SMBlocks.JADE_ORE);
        forBlock(SMBlocks.DEEPSLATE_JADE_ORE);
        forBlock(SMBlocks.ROUGH_JADE_BRICKS);
        forBlock(SMBlocks.SMOOTHED_ROUGH_JADE);
        forBlock(SMBlocks.ROUGH_JADE_TILES);
        forBlock(SMBlocks.POLISHED_JADE_BRICKS);
        forBlock(SMBlocks.POLISHED_SMALL_JADE_BRICKS);
        forBlock(SMBlocks.POLISHED_JADE_SHINGLES);
        forBlock(SMBlocks.POLISHED_JADE_TILES);
        forBlock(SMBlocks.POLISHED_CHISELED_JADE);
        forBlock(SMBlocks.POLISHED_JADE_PILLAR);
        forBlock(SMBlocks.JADE_TOTEM);
        forBlock(SMBlocks.JADE_FLINGER_TOTEM);
        forBlock(SMBlocks.COPPER_BUTTON);
        forBlock(SMBlocks.EXPOSED_COPPER_BUTTON);
        forBlock(SMBlocks.WEATHERED_COPPER_BUTTON);
        forBlock(SMBlocks.OXIDIZED_COPPER_BUTTON);
        forBlock(SMBlocks.WAXED_COPPER_BUTTON);
        forBlock(SMBlocks.WAXED_EXPOSED_COPPER_BUTTON);
        forBlock(SMBlocks.WAXED_WEATHERED_COPPER_BUTTON);
        forBlock(SMBlocks.WAXED_OXIDIZED_COPPER_BUTTON);
        forBlock(SMBlocks.POLISHED_JADE_BRICK_STAIRS);
        forBlock(SMBlocks.POLISHED_SMALL_JADE_BRICK_STAIRS);
        forBlock(SMBlocks.POLISHED_JADE_SHINGLE_STAIRS);
        forBlock(SMBlocks.POLISHED_JADE_TILE_STAIRS);
        forBlock(SMBlocks.POLISHED_JADE_BRICK_SLAB);
        forBlock(SMBlocks.POLISHED_SMALL_JADE_BRICK_SLAB);
        forBlock(SMBlocks.POLISHED_JADE_SHINGLE_SLAB);
        forBlock(SMBlocks.POLISHED_JADE_TILE_SLAB);
        forBlock(SMBlocks.ROUGH_JADE_BRICK_STAIRS);
        forBlock(SMBlocks.SMOOTHED_ROUGH_JADE_STAIRS);
        forBlock(SMBlocks.ROUGH_JADE_TILE_STAIRS);
        forBlock(SMBlocks.ROUGH_JADE_BRICK_SLAB);
        forBlock(SMBlocks.SMOOTHED_ROUGH_JADE_SLAB);
        forBlock(SMBlocks.ROUGH_JADE_TILE_SLAB);
        /*
        forBlock(SMBlocks.POLISHED_JADE_BRICK_VERTICAL_SLAB);
        forBlock(SMBlocks.POLISHED_SMALL_JADE_BRICK_VERTICAL_SLAB);
        forBlock(SMBlocks.POLISHED_JADE_SHINGLE_VERTICAL_SLAB);
        forBlock(SMBlocks.POLISHED_JADE_TILE_VERTICAL_SLAB);
        forBlock(SMBlocks.ROUGH_JADE_BRICK_VERTICAL_SLAB);
        forBlock(SMBlocks.SMOOTHED_ROUGH_JADE_VERTICAL_SLAB);
        forBlock(SMBlocks.ROUGH_JADE_TILE_VERTICAL_SLAB);
         */
        forBlock(SMBlocks.TORTOISE_EGG);

        addBlock(SMBlocks.POLISHED_JADE_BLOCK, "Block of Polished Jade");
        addBlock(SMBlocks.ROUGH_JADE_BLOCK, "Block of Rough Jade");

        //Items
        forItem(SMItems.ROUGH_JADE);
        forItem(SMItems.POLISHED_JADE);
        forItem(SMItems.LANTERNFISH_SPAWN_EGG);
        forItem(SMItems.COOKED_LANTERNFISH);
        forItem(SMItems.TORTOISE_SPAWN_EGG);
        forItem(SMItems.JADE_SHIELD);
        forItem(SMItems.COOKED_LANTERNFISH_SLICE);
        forItem(SMItems.LANTERNFISH_ROLL);
        forItem(SMItems.CAVE_CHUM_BUCKET);
        forItem(SMItems.TORTOISE_SCUTE);
        forItem(SMItems.TORTOISE_SHELL);
        forItem(SMItems.BOULDERING_ZOMBIE_SPAWN_EGG);
        forItem(SMItems.JUNGLE_SPIDER_SPAWN_EGG);
        forItem(SMItems.GLASS_VIAL);
        add(SMItems.VENOM_VIAL.get(), "Vial of Jungle Venom");
        forItem(SMItems.JADE_HORSE_ARMOR);

        add(SMItems.LANTERNFISH_BUCKET.get(), "Bucket of Lanternfish");
        add(SMItems.LANTERNFISH.get(), "Raw Lanternfish");
        add(SMItems.LANTERNFISH_SLICE.get(), "Raw Lanternfish Slice");

        addMusicDisc(SMItems.MUSIC_DISC_SCOUR, "LudoCrypt - scour");

        //Entities
        forEntity(SMEntityTypes.LANTERNFISH);
        forEntity(SMEntityTypes.TORTOISE);
        forEntity(SMEntityTypes.COPPER_GOLEM);
        forEntity(SMEntityTypes.TORTOISE_SHELL);
        forEntity(SMEntityTypes.BOULDERING_ZOMBIE);
        forEntity(SMEntityTypes.JUNGLE_SPIDER);

        //Potions
        addPotionsForEffect(SMPotions.UNLUCK, "Bad Luck");

        //Subtitles
        add("subtitles.item.vial.shatter", "Vial shatters");
        add("subtitles.item.vial.harvest", "Vial fills");

        add("subtitles.block.grindstone.polish_jade", "Grindstone polishes");
        add("subtitles.block.jade.ricochet", "Projectile ricochets");
        add("subtitles.block.flinger_totem.shoot", "Projectile flung");
        add("subtitles.block.flinger_totem.input_honey", "Projectile absorbed ");
        add("subtitles.block.flinger_totem.add_honey", "Honey applied");
        add("subtitles.block.flinger_totem.reduce_honey", "Honey removed");

        add("subtitles.entity.tortoise.ambient", "Tortoise chirps");
        add("subtitles.entity.tortoise.death", "Tortoise dies");
        add("subtitles.entity.tortoise.hurt", "Tortoise hurts");
        add("subtitles.entity.tortoise.hide", "Tortoise hides");
        add("subtitles.entity.tortoise.emerge", "Tortoise emerges");
        add("subtitles.entity.tortoise.hurt.hidden", "Tortoise hurts");
        add("subtitles.entity.tortoise.death_baby", "Tortoise baby dies");
        add("subtitles.entity.tortoise.hurt_baby", "Tortoise baby hurts");
        add("subtitles.entity.tortoise.egg_crack", "Tortoise Egg cracks");
        add("subtitles.entity.tortoise.egg_break", "Tortoise Egg breaks");
        add("subtitles.entity.tortoise.egg_hatch", "Tortoise Egg hatches");

        add("subtitles.entity.tortoise_shell.place", "Tortoise Shell placed");

        add("subtitles.entity.zombie.destroy_egg", "Egg stomped");

        add("subtitles.entity.lanternfish.flop", "Lanternfish flops");
        add("subtitles.entity.lanternfish.hurt", "Lanternfish hurts");
        add("subtitles.entity.lanternfish.death", "Lanternfish dies");

        add("subtitles.entity.bouldering_zombie.ambient", "Bouldering Zombie groans");
        add("subtitles.entity.bouldering_zombie.hurt", "Bouldering Zombie hurts");
        add("subtitles.entity.bouldering_zombie.death", "Bouldering Zombie dies");

        //Other
        TextUtil.TRANSLATABLES.forEach(this::add);
        add("death.attack.tortoise_shell", "%1$s took a Tortoise Shell to the knees");
        add("death.attack.tortoise_shell.player", "%1$s got bonked to death");

    }

    public void addMusicDisc(Supplier<? extends Item> item, String description) {
        String disc = item.get().getDescriptionId();
        add(disc, "Music Disc");
        add(disc + ".desc", description);
    }

    public void addPotionsForEffect(Supplier<? extends Potion> potionEffect, String name) {
        add(PotionUtils.setPotion(Items.POTION.getDefaultInstance(), potionEffect.get()), "Potion of " + name);
        add(PotionUtils.setPotion(Items.SPLASH_POTION.getDefaultInstance(), potionEffect.get()), "Splash Potion of " + name);
        add(PotionUtils.setPotion(Items.LINGERING_POTION.getDefaultInstance(), potionEffect.get()), "Lingering Potion of " + name);
        add(PotionUtils.setPotion(Items.TIPPED_ARROW.getDefaultInstance(), potionEffect.get()), "Arrow of " + name);
    }

    public void forItem(Supplier<? extends Item> item) {
        addItem(item, TextUtil.createTranslation(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.get())).getPath()));
    }

    public void forBlock(Supplier<? extends Block> block) {
        addBlock(block, TextUtil.createTranslation(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath()));
    }

    public void forEntity(Supplier<? extends EntityType<?>> entity) {
        addEntityType(entity, TextUtil.createTranslation(Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.get())).getPath()));
    }
}