package net.themcbrothers.bathroom.infrastructure;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;

import static net.themcbrothers.bathroom.infrastructure.Registration.BLOCKS;
import static net.themcbrothers.bathroom.infrastructure.Registration.ITEMS;

public final class BathroomBlocks {
    static void init() {
    }

    public static final DeferredBlock<Block> EXAMPLE_BLOCK = registerBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));

    private static DeferredBlock<Block> registerBlock(String name, BlockBehaviour.Properties props) {
        return registerBlock(name, Block::new, props);
    }

    private static <B extends Block> DeferredBlock<B> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends B> func, BlockBehaviour.Properties props) {
        DeferredBlock<B> deferredBlock = BLOCKS.registerBlock(name, func, props);
        ITEMS.registerSimpleBlockItem(name, deferredBlock);
        return deferredBlock;
    }
}
