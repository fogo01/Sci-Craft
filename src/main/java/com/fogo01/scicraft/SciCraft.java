package com.fogo01.scicraft;

import com.fogo01.scicraft.genaration.BlockGeneration;
import com.fogo01.scicraft.handler.ConfigurationHandler;
import com.fogo01.scicraft.handler.GuiHandler;
import com.fogo01.scicraft.init.*;
import com.fogo01.scicraft.proxy.ClientProxy;
import com.fogo01.scicraft.proxy.CommonProxy;
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

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERISION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class SciCraft {
    BlockGeneration eventWorldGen = new BlockGeneration();

    @Mod.Instance(Reference.MOD_ID)
    public static SciCraft instance;

    @SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
    public static CommonProxy Common_Proxy;
    public static ClientProxy Client_proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

        ModItems.init();
        ModBlocks.init();
        OreDict.init();
        ModAchievements.init();

        GameRegistry.registerWorldGenerator(this.eventWorldGen, 0);

        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        TileEntities.init();
        ClientProxy.registerTileEntitySpecialRender();

        Recipies.init();

        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

        LogHelper.info("Post Initialization Complete!");
    }
}
