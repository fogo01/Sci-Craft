package com.fogo01.scicraft.blocks.moon;

import com.fogo01.scicraft.blocks.BlockSciCraft;
import com.fogo01.scicraft.crativetab.CreativeTabSciCraft;
import com.fogo01.scicraft.reference.Names;

public class BlockMoonCoalOre extends BlockSciCraft {
    public BlockMoonCoalOre() {
        super();
        this.setBlockName(Names.Blocks.MOON_ORES[0]);
        this.setHarvestLevel("pickaxe", 0);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setCreativeTab(CreativeTabSciCraft.SciCraft_TAB_MOON);
    }
}
