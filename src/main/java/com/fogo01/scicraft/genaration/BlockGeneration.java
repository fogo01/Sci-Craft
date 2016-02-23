package com.fogo01.scicraft.genaration;

import com.fogo01.scicraft.handler.ConfigurationHandler;
import com.fogo01.scicraft.init.ModBlocks;
import com.fogo01.scicraft.reference.Dimensions;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class BlockGeneration implements IWorldGenerator {
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
                break;
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
                break;
            case Dimensions.IDs.DIMENSION_ID_MOON:
                generateMoon(world, random, chunkX * 16, chunkZ * 16);
                break;
        }
    }

    private void generateSurface(World world, Random random, int x, int z) {
        if(ConfigurationHandler.AlGen)
            addOreSpawnModOres(ModBlocks.ALUMINUM_ORE, world, random, x, z, 16, 16, 2 + random.nextInt(3), 8, 16, 64, 0);
        if(ConfigurationHandler.CuGen)
            addOreSpawnModOres(ModBlocks.COPPER_ORE, world, random, x, z, 16, 16, 2 + random.nextInt(4), 12, 48, 96, 0);
        if(ConfigurationHandler.SnGen)
            addOreSpawnModOres(ModBlocks.TIN_ORE, world, random, x, z, 16, 16, 2 + random.nextInt(4), 12, 48, 96, 0);
        if (ConfigurationHandler.AgGen)
            addOreSpawnModOres(ModBlocks.SILVER_ORE, world, random, x, z, 16, 16, 2 + random.nextInt(3), 6, 5, 34, 0);
        if (ConfigurationHandler.PbGen)
            addOreSpawnModOres(ModBlocks.LEAD_ORE, world, random, x, z, 16, 16, 2 + random.nextInt(3), 6, 5, 34, 0);
        if (ConfigurationHandler.UGen)
            addOreSpawnModOres(ModBlocks.URANIUM_ORE, world, random, x, z, 16, 16, 1 + random.nextInt(2), 3, 13, 24, 0);

        addOilWell(ModBlocks.OIL_BLOCK, world, random, x, z, 16, 16, 1, 1, 16, 30);
    }

    private void generateNether(World world, Random random, int x, int z) {

    }

    private void generateEnd(World world, Random random, int x, int z) {

    }

    private void addOilWell(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
        if (random.nextInt(640) > 0)
            return;
        for (int i = 0; i < chanceToSpawn; i++) {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(maxZ);
            new OilWell().generate(world, random, posX, posY, posZ);
        }
    }

    private void generateMoon(World world, Random random, int x, int z) {
        addOreSpawnMoon(ModBlocks.MOON_COAL_ORE, world, random, x, z, 16, 16, 5 + random.nextInt(5), 15, 5, 132, 0);
        addOreSpawnMoon(ModBlocks.MOON_IRON_ORE, world, random, x, z, 16, 16, 2 + random.nextInt(4), 12, 5, 68, 0);
        addOreSpawnMoon(ModBlocks.MOON_GOLD_ORE, world, random, x, z, 16, 16, 2 + random.nextInt(3), 6, 5, 34, 0);
        addOreSpawnMoon(ModBlocks.MOON_LAPIS_ORE, world, random, x, z, 16, 16, 3 + random.nextInt(4), 7, 14, 34, 0);
        addOreSpawnMoon(ModBlocks.MOON_REDSTONE_ORE, world, random, x, z, 16, 16, 3 + random.nextInt(4), 10, 5, 16, 0);
        addOreSpawnMoon(ModBlocks.MOON_DIAMOND_ORE, world, random, x, z, 16, 16, 1 + random.nextInt(5), 3, 5, 16, 0);
        addOreSpawnMoon(ModBlocks.MOON_ALUMINUM_ORE, world, random, x, z, 16, 16, 2 + random.nextInt(3), 8, 16, 64, 0);
        addOreSpawnMoon(ModBlocks.MOON_COPPER_ORE, world, random, x, z, 16, 16, 3 + random.nextInt(4), 12, 48, 96, 0);
        addOreSpawnMoon(ModBlocks.MOON_TIN_ORE, world, random, x, z, 16, 16, 3 + random.nextInt(4), 12, 48, 96, 0);
        addOreSpawnMoon(ModBlocks.MOON_SILVER_ORE, world, random, x, z, 16, 16, 3 + random.nextInt(4), 6, 5, 34, 0);
        addOreSpawnMoon(ModBlocks.MOON_LEAD_ORE, world, random, x, z, 16, 16, 3 + random.nextInt(4), 6, 5, 34, 0);
        addOreSpawnMoon(ModBlocks.MOON_UNOBTANIUM_ORE, world, random, x, z, 16, 16, 1, 3, 5, 16, 0);
    }

    private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
        for (int i = 0; i < chanceToSpawn; i++) {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(maxZ);
            new WorldGenMinable(block, maxVeinSize).generate(world, random, posX, posY, posZ);
        }
    }

    private void addOreSpawnModOres(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY, int meta) {
        for (int i = 0; i < chanceToSpawn; i++) {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(maxZ);
            new WorldGenMinable(block, meta, maxVeinSize, Blocks.stone).generate(world, random, posX, posY, posZ);
        }
    }

    private void addOreSpawnMoon(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY, int meta) {
        for (int i = 0; i < chanceToSpawn; i++) {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(maxZ);
            new WorldGenMinable(block, meta, maxVeinSize, ModBlocks.MOON_ROCK).generate(world, random, posX, posY, posZ);
        }
    }

}


