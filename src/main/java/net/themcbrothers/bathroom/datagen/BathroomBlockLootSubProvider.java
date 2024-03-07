package net.themcbrothers.bathroom.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.themcbrothers.bathroom.core.BathroomBlocks;
import net.themcbrothers.bathroom.core.Registration;

import java.util.Collections;
import java.util.stream.Collectors;

public class BathroomBlockLootSubProvider extends BlockLootSubProvider {
    protected BathroomBlockLootSubProvider() {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(BathroomBlocks.EXAMPLE_BLOCK.get());
        this.dropSelf(BathroomBlocks.TOILET.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Registration.BLOCKS.getEntries()
                .stream()
                .map(DeferredHolder::value)
                .collect(Collectors.toList());
    }
}
