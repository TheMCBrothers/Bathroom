package net.themcbrothers.bathroom.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.themcbrothers.bathroom.Bathroom;
import net.themcbrothers.bathroom.infrastructure.BathroomItems;

public class BathroomItemModelProvider extends ItemModelProvider {
    public BathroomItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Bathroom.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(BathroomItems.EXAMPLE_ITEM.value());
    }
}
