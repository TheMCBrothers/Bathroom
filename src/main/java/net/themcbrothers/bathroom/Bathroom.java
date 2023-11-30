package net.themcbrothers.bathroom;

import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.themcbrothers.bathroom.infrastructure.Registration;
import org.slf4j.Logger;

import static net.themcbrothers.bathroom.infrastructure.BathroomBlocks.EXAMPLE_BLOCK;
import static net.themcbrothers.bathroom.infrastructure.BathroomItems.EXAMPLE_ITEM;
import static net.themcbrothers.bathroom.infrastructure.Registration.CREATIVE_MODE_TABS;

@Mod(Bathroom.MOD_ID)
public class Bathroom {
    public static final String MOD_ID = "bathroom";

    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BATHROOM_TAB = CREATIVE_MODE_TABS.register("bathroom_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
            .title(Component.translatable("itemGroup.bathroom.bathroom"))
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_ITEM);
                output.accept(EXAMPLE_BLOCK);
            }).build());

    public Bathroom(IEventBus modEventBus) {
        // Register the commonSetup method for mod loading
        modEventBus.addListener(this::commonSetup);

        // Register
        Registration.register(modEventBus);

        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
    }
}
