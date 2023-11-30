package net.themcbrothers.bathroom.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.themcbrothers.bathroom.Bathroom;
import net.themcbrothers.bathroom.infrastructure.BathroomBlocks;
import net.themcbrothers.bathroom.infrastructure.BathroomItems;

public class BathroomLanguageProvider extends LanguageProvider {
    public BathroomLanguageProvider(PackOutput output) {
        super(output, Bathroom.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Blocks
        addBlock(BathroomBlocks.EXAMPLE_BLOCK, "Example Block");

        // Items
        addItem(BathroomItems.EXAMPLE_ITEM, "Example Item");

        // Tab
        add("itemGroup.bathroom.bathroom", "Bathroom");
    }
}
