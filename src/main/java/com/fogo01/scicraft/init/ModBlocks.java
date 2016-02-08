package com.fogo01.scicraft.init;

import com.fogo01.scicraft.blocks.*;
import com.fogo01.scicraft.blocks.ItemBlocks.ItemBlockMoonOre;
import com.fogo01.scicraft.blocks.ItemBlocks.ItemBlockOverworldOre;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.blocks.BlockSciCraft;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
    public static final BlockSciCraft OVERWORLD_ORE = new BlockOverworldOre();

    public static final BlockSciCraft ALUMINUM_BLOCK = new BlockAluminumBlock();
    public static final BlockSciCraft COPPER_BLOCK = new BlockCopperBlock();
    public static final BlockSciCraft TIN_BLOCK = new BlockTinBlock();
    public static final BlockSciCraft STEEL_BLOCK = new BlockSteelBlock();

    public static final BlockSciCraft MOON_DUST = new BlockMoonDust();
    public static final BlockSciCraft MOON_ROCK = new BlockMoonRock();
    public static final BlockSciCraft MOON_ORE = new BlockMoonOre();

    public static final BlockSciCraft PORTAL_BLOCK = new BlockPortalBlock();

    public static void init() {
        GameRegistry.registerBlock(OVERWORLD_ORE, ItemBlockOverworldOre.class, Names.Blocks.OVERWORLD_ORE);

        GameRegistry.registerBlock(ALUMINUM_BLOCK, Names.Blocks.ALUMINUM_BLOCK);
        GameRegistry.registerBlock(COPPER_BLOCK, Names.Blocks.COPPER_BLOCK);
        GameRegistry.registerBlock(TIN_BLOCK, Names.Blocks.TIN_BLOCK);
        GameRegistry.registerBlock(STEEL_BLOCK, Names.Blocks.STEEL_BLOCK);

        GameRegistry.registerBlock(MOON_DUST, Names.Blocks.MOON_DUST);
        GameRegistry.registerBlock(MOON_ROCK, Names.Blocks.MOON_ROCK);
        GameRegistry.registerBlock(MOON_ORE, ItemBlockMoonOre.class, Names.Blocks.MOON_ORE);

        GameRegistry.registerBlock(PORTAL_BLOCK, Names.Blocks.PORTAL_BLOCK);
    }
}
