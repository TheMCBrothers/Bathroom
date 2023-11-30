package net.themcbrothers.bathroom.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.themcbrothers.bathroom.Bathroom;

public class BathroomBlockStateProvider extends BlockStateProvider {
    public BathroomBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Bathroom.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        models().cubeAll("example_block", mcLoc("block/cauldron_inner"));
        itemModels().withExistingParent("example_block", modLoc("block/example_block"));
    }
}
