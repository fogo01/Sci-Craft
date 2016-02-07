package com.fogo01.scicraft.init;

import com.fogo01.scicraft.biomes.BiomeGenMoon;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

public class BiomeRegistry {
    public static BiomeGenBase biomeMoon = new BiomeGenMoon(200).setBiomeName("Moon");

    public static void registerBiome() {
        BiomeDictionary.registerBiomeType(biomeMoon, BiomeDictionary.Type.PLAINS);
        BiomeManager.addSpawnBiome(biomeMoon);
    }
}
