package com.fogo01.scicraft.biomes;

import com.fogo01.scicraft.entities.monsters.EntityAlien;
import com.fogo01.scicraft.init.ModBlocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenMoon extends BiomeGenBase {
    public BiomeGenMoon(int id) {
        super(id);
        this.theBiomeDecorator.generateLakes = false;

        this.enableRain = false;
        this.enableSnow = false;

        this.topBlock = ModBlocks.MOON_DUST;
        this.fillerBlock = ModBlocks.MOON_ROCK;

        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityAlien.class, 8, 1, 5));
    }
}
