package net.themcbrothers.bathroom.core;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

import static net.themcbrothers.bathroom.core.Registration.ITEMS;

public final class BathroomItems {
    static void init() {
    }

    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder().alwaysEat().nutrition(1).saturationMod(2f).build()));
}
