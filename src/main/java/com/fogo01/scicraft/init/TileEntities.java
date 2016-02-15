package com.fogo01.scicraft.init;

import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.tileentity.TileEntityBatteryCell;
import com.fogo01.scicraft.tileentity.TileEntityEnergyCable;
import com.fogo01.scicraft.tileentity.TileEntityPipe;
import com.fogo01.scicraft.tileentity.TileEntitySolarPanel;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntities {
    public static void init() {
        GameRegistry.registerTileEntity(TileEntitySolarPanel.class, Names.Blocks.SOLAR_PANEL);
        GameRegistry.registerTileEntity(TileEntityBatteryCell.class, Names.Blocks.BATTERY_CELL);
        GameRegistry.registerTileEntity(TileEntityEnergyCable.class, Names.Blocks.ENERGY_CABLE);
    }
}
