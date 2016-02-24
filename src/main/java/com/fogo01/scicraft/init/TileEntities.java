package com.fogo01.scicraft.init;

import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.tileentity.*;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntities {
    public static void init() {
        GameRegistry.registerTileEntity(TileEntitySolarPanel.class, Names.Blocks.SOLAR_PANEL);
        GameRegistry.registerTileEntity(TileEntityBatteryCell.class, Names.Blocks.BATTERY_CELL);
        GameRegistry.registerTileEntity(TileEntityPoweredFurnace.class, Names.Blocks.POWERED_FURNACE);
        GameRegistry.registerTileEntity(TileEntityCrusher.class, Names.Blocks.CRUSHER);
        GameRegistry.registerTileEntity(TileEntityAlloySmelter.class, Names.Blocks.ALLOY_SMELTER);
        GameRegistry.registerTileEntity(TileEntityCentrifuge.class, Names.Blocks.CENTRIFUGE);
        GameRegistry.registerTileEntity(TileEntityEnergyCable.class, Names.Blocks.ENERGY_CABLE);
    }
}
