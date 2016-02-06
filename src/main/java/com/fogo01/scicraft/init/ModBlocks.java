package com.fogo01.scicraft.init;

import com.fogo01.scicraft.block.*;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.block.BlockSciCraft;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
    public static final BlockSciCraft ALUMINUM_ORE = new BlockAluminumOre();
    public static final BlockSciCraft COPPER_ORE = new BlockCopperOre();
    public static final BlockSciCraft TIN_ORE = new BlockTinOre();
    public static final BlockSciCraft ALUMINUM_BLOCK = new BlockAluminumBlock();
    public static final BlockSciCraft COPPER_BLOCK = new BlockCopperBlock();
    public static final BlockSciCraft TIN_BLOCK = new BlockTinBlock();
    public static final BlockSciCraft STEEL_BLOCK = new BlockSteelBlock();

    public static void init() {
        GameRegistry.registerBlock(ALUMINUM_ORE, Names.Blocks.ALUMINUM_ORE);
        GameRegistry.registerBlock(COPPER_ORE, Names.Blocks.COPPER_ORE);
        GameRegistry.registerBlock(TIN_ORE, Names.Blocks.TIN_ORE);
        GameRegistry.registerBlock(ALUMINUM_BLOCK, Names.Blocks.ALUMINUM_BLOCK);
        GameRegistry.registerBlock(COPPER_BLOCK, Names.Blocks.COPPER_BLOCK);
        GameRegistry.registerBlock(TIN_BLOCK, Names.Blocks.TIN_BLOCK);
        GameRegistry.registerBlock(STEEL_BLOCK, Names.Blocks.STEEL_BLOCK);
    }
}
