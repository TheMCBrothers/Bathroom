package net.themcbrothers.bathroom.infrastructure;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;

import static net.themcbrothers.bathroom.infrastructure.BathroomBlocks.EXAMPLE_BLOCK;
import static net.themcbrothers.bathroom.infrastructure.BathroomItems.EXAMPLE_ITEM;
import static net.themcbrothers.bathroom.infrastructure.Registration.CREATIVE_MODE_TABS;

public final class BathroomTabs {
    static void init() {
    }

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BATHROOM_TAB = CREATIVE_MODE_TABS.register("bathroom_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
            .title(Component.translatable("itemGroup.bathroom.bathroom"))
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_ITEM);
                output.accept(EXAMPLE_BLOCK);
            }).build());
}
