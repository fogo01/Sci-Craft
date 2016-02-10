package com.fogo01.scicraft.blocks;

import com.fogo01.scicraft.reference.Names;

public class BlockUraniumBlock extends BlockSciCraft {
    public BlockUraniumBlock() {
        super();
        this.setBlockName(Names.Blocks.URANIUM_BLOCK);
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }
}
