package com.fogo01.scicraft.blocks;

import com.fogo01.scicraft.reference.Names;

public class BlockCopperOre extends BlockSciCraft {
    public BlockCopperOre() {
        super();
        this.setBlockName(Names.Blocks.OVERWORLD_ORES[1]);
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }
}
