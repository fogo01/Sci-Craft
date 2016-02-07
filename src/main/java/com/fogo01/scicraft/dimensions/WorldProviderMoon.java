package com.fogo01.scicraft.dimensions;

import com.fogo01.scicraft.init.BiomeRegistry;
import com.fogo01.scicraft.reference.Dimensions;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderMoon extends WorldProvider {
    @Override
    protected void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeRegistry.biomeMoon, 1.2f);
        this.dimensionId = Dimensions.IDs.DIMENSION_ID_MOON;
    }

    public IChunkProvider createChunkGeneration() {
        return null;
        //return new ChunkProviderMoon(worldObj, worldObj.getSeed(), true);
    }

    @Override
    public String getDimensionName() {
        return "Moon";
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }
}
