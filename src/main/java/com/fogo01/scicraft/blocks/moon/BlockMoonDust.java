package com.fogo01.scicraft.blocks.moon;

import com.fogo01.scicraft.blocks.BlockSciCraft;
import com.fogo01.scicraft.crativetab.CreativeTabSciCraft;
import com.fogo01.scicraft.reference.Names;
import net.minecraft.block.material.Material;

public class BlockMoonDust extends BlockSciCraft {
    public BlockMoonDust() {
        super(Material.gourd);
        this.setBlockName(Names.Blocks.MOON_DUST);
        this.setHarvestLevel("shovel", 0);
        this.setHardness(0.5F);
        this.setCreativeTab(CreativeTabSciCraft.SciCraft_TAB_MOON);
    }
}
