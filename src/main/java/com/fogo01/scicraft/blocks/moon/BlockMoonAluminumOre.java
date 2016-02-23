package com.fogo01.scicraft.blocks.moon;

import com.fogo01.scicraft.blocks.BlockSciCraft;
import com.fogo01.scicraft.crativetab.CreativeTabSciCraft;
import com.fogo01.scicraft.reference.Names;

public class BlockMoonAluminumOre extends BlockSciCraft {
    public BlockMoonAluminumOre() {
        super();
        this.setBlockName(Names.Blocks.MOON_ORES[6]);
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setCreativeTab(CreativeTabSciCraft.SciCraft_TAB_MOON);
    }
}
