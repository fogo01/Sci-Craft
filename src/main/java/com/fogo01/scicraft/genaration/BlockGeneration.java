package com.fogo01.scicraft.genaration;

import com.fogo01.scicraft.blocks.BlockSciCraft;
import com.fogo01.scicraft.handler.ConfigurationHandler;
import com.fogo01.scicraft.init.ModBlocks;
import com.fogo01.scicraft.reference.Dimensions;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
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
            addOreSpawn(ModBlocks.ALUMINUM_ORE, world, random, x, z, 16, 16, 2 + random.nextInt(3), 8, 16, 64);
        if(ConfigurationHandler.CuGen)
            addOreSpawn(ModBlocks.COPPER_ORE, world, random, x, z, 16, 16, 2 + random.nextInt(4), 12, 48, 96);
        if(ConfigurationHandler.SnGen)
            addOreSpawn(ModBlocks.TIN_ORE, world, random, x, z, 16, 16, 2 + random.nextInt(4), 12, 48, 96);
    }

    private void generateNether(World world, Random random, int x, int z) {

    }

    private void generateEnd(World world, Random random, int x, int z) {

    }

    private void generateMoon(World world, Random random, int x, int z) {
        addOreSpawnMoon(ModBlocks.MOON_ORE, world, random, x, z, 16, 16, 2 + random.nextInt(3), 8, 16, 64, 0);
        addOreSpawnMoon(ModBlocks.MOON_ORE, world, random, x, z, 16, 16, 2 + random.nextInt(4), 12, 48, 96, 1);
        addOreSpawnMoon(ModBlocks.MOON_ORE, world, random, x, z, 16, 16, 2 + random.nextInt(4), 12, 48, 96, 2);
    }

    private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
        for (int i = 0; i < chanceToSpawn; i++) {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(maxZ);
            new WorldGenMinable(block, maxVeinSize).generate(world, random, posX, posY, posZ);
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


