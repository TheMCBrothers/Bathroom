package net.themcbrothers.bathroom;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.themcbrothers.bathroom.infrastructure.Registration;
import org.slf4j.Logger;

@Mod(Bathroom.MOD_ID)
public class Bathroom {
    public static final String MOD_ID = "bathroom";

    private static final Logger LOGGER = LogUtils.getLogger();

    public Bathroom(IEventBus modEventBus) {
        // Register the commonSetup method for mod loading
        modEventBus.addListener(this::commonSetup);

        // Register stuff
        Registration.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
    }
}
