package com.fogo01.scicraft.blocks;

import com.fogo01.scicraft.crativetab.CreativeTabSciCraft;
import com.fogo01.scicraft.reference.Names;

public class BlockMoonRock extends BlockSciCraft {
    public BlockMoonRock() {
        super();
        this.setBlockName(Names.Blocks.MOON_ROCK);
        this.setHarvestLevel("pickaxe", 0);
        this.setHardness(0.5F);
        this.setCreativeTab(CreativeTabSciCraft.SciCraft_TAB_MOON);
    }
}
