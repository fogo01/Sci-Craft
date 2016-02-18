package com.fogo01.scicraft.init;

import com.fogo01.scicraft.blocks.*;
import com.fogo01.scicraft.blocks.ItemBlocks.*;
import com.fogo01.scicraft.blocks.containers.BlockBatteryCell;
import com.fogo01.scicraft.blocks.containers.BlockCrusher;
import com.fogo01.scicraft.blocks.containers.BlockPoweredFurnace;
import com.fogo01.scicraft.blocks.containers.BlockSolarPanel;
import com.fogo01.scicraft.blocks.fluids.*;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.blocks.BlockSciCraft;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
    public static final BlockSciCraft OVERWORLD_ORE = new BlockOverworldOre();

    public static final BlockSciCraft METAL_BLOCK = new BlockMetalBlock();

    public static final BlockSciCraftContainer SOLAR_PANEL = new BlockSolarPanel();
    public static final BlockSciCraftContainer BATTERY_CELL = new BlockBatteryCell();
    public static final BlockSciCraftContainer POWERED_FURNACE = new BlockPoweredFurnace();
    public static final BlockSciCraftContainer CRUSHER = new BlockCrusher();
    public static final BlockSciCraftContainer ENERGY_CABLE = new BlockEnergyCable();

    public static final BlockSciCraft MOON_DUST = new BlockMoonDust();
    public static final BlockSciCraft MOON_ROCK = new BlockMoonRock();
    public static final BlockSciCraft MOON_ORE = new BlockMoonOre();

    public static final BlockSciCraftFluid OIL_BLOCK = new BlockOilFluid();
    public static final BlockSciCraftFluid FUEL_BLOCK = new BlockFuelFluid();
    public static final BlockSciCraft OIL_WELL_PLACER = new BlockOilWellPlacer();

    public static final BlockSciCraft PORTAL_BLOCK = new BlockPortalBlock();

    public static void init() {
        GameRegistry.registerBlock(OVERWORLD_ORE, ItemBlockOverworldOre.class, Names.Blocks.OVERWORLD_ORE);

        GameRegistry.registerBlock(METAL_BLOCK, ItemBlockMetalBlock.class, Names.Blocks.METAL_BLOCK);

        GameRegistry.registerBlock(SOLAR_PANEL, Names.Blocks.SOLAR_PANEL);
        GameRegistry.registerBlock(BATTERY_CELL, Names.Blocks.BATTERY_CELL);
        GameRegistry.registerBlock(POWERED_FURNACE, Names.Blocks.POWERED_FURNACE);
        GameRegistry.registerBlock(CRUSHER, Names.Blocks.CRUSHER);
        GameRegistry.registerBlock(ENERGY_CABLE, Names.Blocks.ENERGY_CABLE);

        GameRegistry.registerBlock(MOON_DUST, Names.Blocks.MOON_DUST);
        GameRegistry.registerBlock(MOON_ROCK, Names.Blocks.MOON_ROCK);
        GameRegistry.registerBlock(MOON_ORE, ItemBlockMoonOre.class, Names.Blocks.MOON_ORE);

        GameRegistry.registerBlock(OIL_BLOCK, Names.Blocks.OIL_BLOCK);
        GameRegistry.registerBlock(FUEL_BLOCK, Names.Blocks.FUEL_BLOCK);
        GameRegistry.registerBlock(OIL_WELL_PLACER, Names.Blocks.OIL_WELL_PLACER);

        GameRegistry.registerBlock(PORTAL_BLOCK, Names.Blocks.PORTAL_BLOCK);
    }
}
