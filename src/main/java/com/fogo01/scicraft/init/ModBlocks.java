package com.fogo01.scicraft.init;

import com.fogo01.scicraft.blocks.*;
import com.fogo01.scicraft.blocks.ItemBlocks.*;
import com.fogo01.scicraft.blocks.containers.*;
import com.fogo01.scicraft.blocks.fluids.*;
import com.fogo01.scicraft.blocks.moon.*;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.blocks.BlockSciCraft;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
    public static final BlockSciCraft ALUMINUM_ORE = new BlockAluminumOre();
    public static final BlockSciCraft COPPER_ORE = new BlockCopperOre();
    public static final BlockSciCraft TIN_ORE = new BlockTinOre();
    public static final BlockSciCraft SILVER_ORE = new BlockSilverOre();
    public static final BlockSciCraft LEAD_ORE = new BLockLeadOre();
    public static final BlockSciCraft URANIUM_ORE = new BlockUraniumOre();

    public static final BlockSciCraft METAL_BLOCK = new BlockMetalBlock();

    public static final BlockSciCraftContainer SOLAR_PANEL = new BlockSolarPanel();
    public static final BlockSciCraftContainer BATTERY_CELL = new BlockBatteryCell();
    public static final BlockSciCraftContainer POWERED_FURNACE = new BlockPoweredFurnace(false);
    public static final BlockSciCraftContainer POWERED_FURNACE_ACTIVE = new BlockPoweredFurnace(true);
    public static final BlockSciCraftContainer CRUSHER = new BlockCrusher(false);
    public static final BlockSciCraftContainer CRUSHER_ACTIVE = new BlockCrusher(true);
    public static final BlockSciCraftContainer ALLOY_SMELTER = new BlockAlloySmelter(false);
    public static final BlockSciCraftContainer ALLOY_SMELTER_ACTIVE = new BlockAlloySmelter(true);
    public static final BlockSciCraftContainer CENTRIFUGE = new BlockCentrifuge(false);
    public static final BlockSciCraftContainer CENTRIFUGE_ACTIVE = new BlockCentrifuge(true);
    public static final BlockSciCraftContainer REFINERY = new BlockRefinery(false);
    public static final BlockSciCraftContainer REFINERY_ACTIVE = new BlockRefinery(true);
    public static final BlockSciCraftContainer ENERGY_CABLE = new BlockEnergyCable();

    public static final BlockSciCraft MOON_DUST = new BlockMoonDust();
    public static final BlockSciCraft MOON_ROCK = new BlockMoonRock();

    public static final BlockSciCraft MOON_COAL_ORE = new BlockMoonCoalOre();
    public static final BlockSciCraft MOON_IRON_ORE = new BlockMoonIronOre();
    public static final BlockSciCraft MOON_GOLD_ORE = new BlockMoonGoldOre();
    public static final BlockSciCraft MOON_LAPIS_ORE = new BlockMoonLapisOre();
    public static final BlockSciCraft MOON_REDSTONE_ORE = new BlockMoonRedstoneOre();
    public static final BlockSciCraft MOON_DIAMOND_ORE = new BlockMoonDiamondOre();
    public static final BlockSciCraft MOON_ALUMINUM_ORE = new BlockMoonAluminumOre();
    public static final BlockSciCraft MOON_COPPER_ORE = new BlockMoonCopperOre();
    public static final BlockSciCraft MOON_TIN_ORE = new BlockMoonTinOre();
    public static final BlockSciCraft MOON_SILVER_ORE = new BlockMoonSilverOre();
    public static final BlockSciCraft MOON_LEAD_ORE = new BlockMoonLeadOre();
    public static final BlockSciCraft MOON_UNOBTANIUM_ORE = new BlockMoonUnobtaniumOre();

    public static final BlockSciCraftFluid OIL_BLOCK = new BlockOilFluid();
    public static final BlockSciCraftFluid FUEL_BLOCK = new BlockFuelFluid();
    public static final BlockSciCraft OIL_WELL_PLACER = new BlockOilWellPlacer();

    public static final BlockSciCraft PORTAL_BLOCK = new BlockPortalBlock();

    public static void init() {
        GameRegistry.registerBlock(ALUMINUM_ORE, Names.Blocks.OVERWORLD_ORES[0]);
        GameRegistry.registerBlock(COPPER_ORE, Names.Blocks.OVERWORLD_ORES[1]);
        GameRegistry.registerBlock(TIN_ORE, Names.Blocks.OVERWORLD_ORES[2]);
        GameRegistry.registerBlock(SILVER_ORE, Names.Blocks.OVERWORLD_ORES[3]);
        GameRegistry.registerBlock(LEAD_ORE, Names.Blocks.OVERWORLD_ORES[4]);
        GameRegistry.registerBlock(URANIUM_ORE, Names.Blocks.OVERWORLD_ORES[5]);

        GameRegistry.registerBlock(METAL_BLOCK, ItemBlockMetalBlock.class, Names.Blocks.METAL_BLOCK);

        GameRegistry.registerBlock(SOLAR_PANEL, Names.Blocks.SOLAR_PANEL);
        GameRegistry.registerBlock(BATTERY_CELL, Names.Blocks.BATTERY_CELL);
        GameRegistry.registerBlock(POWERED_FURNACE, Names.Blocks.POWERED_FURNACE);
        GameRegistry.registerBlock(POWERED_FURNACE_ACTIVE, Names.Blocks.POWERED_FURNACE_ACTIVE);
        GameRegistry.registerBlock(CRUSHER, Names.Blocks.CRUSHER);
        GameRegistry.registerBlock(CRUSHER_ACTIVE, Names.Blocks.CRUSHER_ACTIVE);
        GameRegistry.registerBlock(ALLOY_SMELTER, Names.Blocks.ALLOY_SMELTER);
        GameRegistry.registerBlock(ALLOY_SMELTER_ACTIVE, Names.Blocks.ALLOY_SMELTER_ACTIVE);
        GameRegistry.registerBlock(CENTRIFUGE, Names.Blocks.CENTRIFUGE);
        GameRegistry.registerBlock(CENTRIFUGE_ACTIVE, Names.Blocks.CENTRIFUGE_ACTIVE);
        GameRegistry.registerBlock(REFINERY, Names.Blocks.REFINERY);
        GameRegistry.registerBlock(REFINERY_ACTIVE, Names.Blocks.REFINERY_ACTIVE);
        GameRegistry.registerBlock(ENERGY_CABLE, Names.Blocks.ENERGY_CABLE);

        GameRegistry.registerBlock(MOON_DUST, Names.Blocks.MOON_DUST);
        GameRegistry.registerBlock(MOON_ROCK, Names.Blocks.MOON_ROCK);

        GameRegistry.registerBlock(MOON_COAL_ORE, Names.Blocks.MOON_ORES[0]);
        GameRegistry.registerBlock(MOON_IRON_ORE, Names.Blocks.MOON_ORES[1]);
        GameRegistry.registerBlock(MOON_GOLD_ORE, Names.Blocks.MOON_ORES[2]);
        GameRegistry.registerBlock(MOON_LAPIS_ORE, Names.Blocks.MOON_ORES[3]);
        GameRegistry.registerBlock(MOON_REDSTONE_ORE, Names.Blocks.MOON_ORES[4]);
        GameRegistry.registerBlock(MOON_DIAMOND_ORE, Names.Blocks.MOON_ORES[5]);
        GameRegistry.registerBlock(MOON_ALUMINUM_ORE, Names.Blocks.MOON_ORES[6]);
        GameRegistry.registerBlock(MOON_COPPER_ORE, Names.Blocks.MOON_ORES[7]);
        GameRegistry.registerBlock(MOON_TIN_ORE, Names.Blocks.MOON_ORES[8]);
        GameRegistry.registerBlock(MOON_SILVER_ORE, Names.Blocks.MOON_ORES[9]);
        GameRegistry.registerBlock(MOON_LEAD_ORE, Names.Blocks.MOON_ORES[10]);
        GameRegistry.registerBlock(MOON_UNOBTANIUM_ORE, Names.Blocks.MOON_ORES[11]);

        GameRegistry.registerBlock(OIL_BLOCK, Names.Blocks.OIL_BLOCK);
        GameRegistry.registerBlock(FUEL_BLOCK, Names.Blocks.FUEL_BLOCK);
        GameRegistry.registerBlock(OIL_WELL_PLACER, Names.Blocks.OIL_WELL_PLACER);

        GameRegistry.registerBlock(PORTAL_BLOCK, Names.Blocks.PORTAL_BLOCK);
    }
}
