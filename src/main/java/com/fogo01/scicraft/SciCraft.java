package com.fogo01.scicraft;

import com.fogo01.scicraft.biomes.WorldTypeMoon;
import com.fogo01.scicraft.dimensions.DimensionRegistry;
import com.fogo01.scicraft.genaration.BlockGeneration;
import com.fogo01.scicraft.handler.BucketHandler;
import com.fogo01.scicraft.handler.ConfigurationHandler;
import com.fogo01.scicraft.handler.GuiHandler;
import com.fogo01.scicraft.init.*;
import com.fogo01.scicraft.proxy.IProxy;
import com.fogo01.scicraft.reference.Reference;
import com.fogo01.scicraft.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERISION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class SciCraft {
    BlockGeneration eventWorldGen = new BlockGeneration();

    @Mod.Instance(Reference.MOD_ID)
    public static SciCraft instance;

    @SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

        ModFluids.init();
        ModBuckets.init();
        ModItems.init();
        ModBlocks.init();
        OreDict.init();
        ModEntities.init();
        ModAchievements.init();

        BucketHandler.INSTANCE.buckets.put(ModBlocks.OIL_BLOCK, ModItems.OIL_BUCKET);
        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);

        GameRegistry.registerWorldGenerator(this.eventWorldGen, 0);

        BiomeRegistry.registerBiome();
        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        TileEntities.init();

        Recipies.init();

        proxy.registerRenderThings();

        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        WorldType MOON = new WorldTypeMoon("Moon");
        DimensionRegistry.registerDimension();

        LogHelper.info("Post Initialization Complete!");
    }
}
