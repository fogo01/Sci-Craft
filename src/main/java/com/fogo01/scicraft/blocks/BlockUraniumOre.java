package com.fogo01.scicraft.blocks;

import com.fogo01.scicraft.reference.Names;

public class BlockUraniumOre extends BlockSciCraft {
    public BlockUraniumOre() {
        super();
        this.setBlockName(Names.Blocks.OVERWORLD_ORES[5]);
        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }
}
