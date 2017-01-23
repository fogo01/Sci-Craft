package com.fogo01.scicraft.dimensions;

import com.fogo01.scicraft.init.BiomeRegistry;
import com.fogo01.scicraft.reference.Dimensions;
import com.fogo01.scicraft.render.dimensions.CloudRenderer;
import com.fogo01.scicraft.render.dimensions.SkyRendererMoon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;

public class WorldProviderMoon extends WorldProvider {
    @Override
    protected void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeRegistry.biomeMoon, 1.2f);
        this.dimensionId = Dimensions.IDs.DIMENSION_ID_MOON;
    }

    public IChunkProvider createChunkGeneration() {
        return new ChunkProviderMoon(worldObj, worldObj.getSeed(), true);
    }

    @Override
    public String getDimensionName() {
        return "Moon";
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean renderStars() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public double getMovementFactor() {
        return 0.1;
    }

    @SideOnly(Side.CLIENT)
    public float getStarBrightness(World world, float f) {
        return 1.0F;
    }

    @SideOnly(Side.CLIENT)
    public boolean renderClouds() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean renderVoidFog() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public float setSunSize() {
        return 0.25F;
    }

    @SideOnly(Side.CLIENT)
    public float setMoonSize() {
        return 4.0F;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Vec3 getSkyColor(Entity cameraEntity, float partialTicks) {
        return worldObj.getSkyColorBody(cameraEntity, partialTicks);
    }

    @SideOnly(Side.CLIENT)
    public boolean isSkyColored() {
        return true;
    }

    @Override
    public boolean isSurfaceWorld() {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getCloudHeight() {
        return this.terrainType.getCloudHeight();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getWelcomeMessage() {
        return "Landing on the Moon";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getDepartMessage() {
        return "Leaving the Moon";
    }

    @Override
    public IRenderHandler getSkyRenderer() {
        return new SkyRendererMoon();
    }

    @Override
    public IRenderHandler getCloudRenderer() {
        return new CloudRenderer();
    }

    @Override
    public Vec3 drawClouds(float partialTicks) {
        return super.drawClouds(partialTicks);
    }
}
