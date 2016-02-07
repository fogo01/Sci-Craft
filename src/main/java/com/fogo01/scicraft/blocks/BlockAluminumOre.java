package com.fogo01.scicraft.blocks;


import com.fogo01.scicraft.reference.Names;

public class BlockAluminumOre extends BlockSciCraft {
        public BlockAluminumOre(){
            super();
            this.setBlockName(Names.Blocks.ALUMINUM_ORE);
            this.setHarvestLevel("pickaxe", 1);
            this.setHardness(3.0F);
            this.setResistance(5.0F);
        }
}
