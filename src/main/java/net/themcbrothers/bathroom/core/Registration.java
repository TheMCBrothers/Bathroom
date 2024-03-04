package net.themcbrothers.bathroom.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.themcbrothers.bathroom.Bathroom;

public final class Registration {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Bathroom.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Bathroom.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Bathroom.MOD_ID);

    public static void register(IEventBus modEventBus) {
        BathroomBlocks.init();
        BathroomItems.init();
        BathroomTabs.init();

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
