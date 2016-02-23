package com.fogo01.scicraft.blocks;

import com.fogo01.scicraft.reference.Names;

public class BLockLeadOre extends BlockSilverOre {
    public BLockLeadOre() {
        super();
        this.setBlockName(Names.Blocks.OVERWORLD_ORES[4]);
        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }
}
