package net.themcbrothers.bathroom.datagen;

import net.minecraft.DetectedVersion;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.themcbrothers.bathroom.Bathroom;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = Bathroom.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenEvents {
    @SubscribeEvent
    static void onDataGen(final GatherDataEvent event) {
        final var generator = event.getGenerator();
        final var packOutput = generator.getPackOutput();
        final var existingFileHelper = event.getExistingFileHelper();

        // Server resources
        generator.addProvider(event.includeServer(),
                new LootTableProvider(
                        packOutput,
                        Collections.emptySet(),
                        List.of(new LootTableProvider.SubProviderEntry(BathroomBlockLootSubProvider::new, LootContextParamSets.BLOCK))
                ));

        // Client resources
        generator.addProvider(event.includeClient(), new BathroomBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new BathroomItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new BathroomLanguageProvider(packOutput));

        // pack.mcmeta
        generator.addProvider(true, new PackMetadataGenerator(packOutput))
                .add(PackMetadataSection.TYPE, new PackMetadataSection(Component.literal("Bathroom resources"),
                        DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES), Arrays.stream(PackType.values())
                        .collect(Collectors.toMap(Function.identity(), DetectedVersion.BUILT_IN::getPackVersion))));
    }
}
