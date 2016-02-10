package com.fogo01.scicraft.handler;

import com.fogo01.scicraft.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {
    public static Configuration configuration;
    public static boolean AlGen = true;
    public static boolean CuGen = true;
    public static boolean SnGen = true;
    public static boolean AgGen = true;
    public static boolean PbGen = true;
    public static boolean UGen = true;

    public static void init(File configFile){
        if(configuration == null) {
            configuration = new Configuration(configFile);
            loadconfiguration();
        }

    }

    @SubscribeEvent
    public void setConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if(event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            loadconfiguration();
        }
    }

    private static void loadconfiguration(){
        AlGen = configuration.getBoolean("AlGen", configuration.CATEGORY_GENERAL, true, "Should Aluminum Ore generate in the world");
        CuGen = configuration.getBoolean("CuGen", configuration.CATEGORY_GENERAL, true, "Should Copper Ore generate in the world");
        SnGen = configuration.getBoolean("SnGen", configuration.CATEGORY_GENERAL, true, "Should Tin Ore generate in the world");
        AgGen = configuration.getBoolean("AgGen", configuration.CATEGORY_GENERAL, true, "Should Silver Ore generate in the world");
        PbGen = configuration.getBoolean("PbGen", configuration.CATEGORY_GENERAL, true, "Should Lead Ore generate in the world");
        UGen = configuration.getBoolean("UGen", configuration.CATEGORY_GENERAL, true, "Should Uranium Ore generate in the world");

        if (configuration.hasChanged()) {
            configuration.save();
        }

    }
}
