package com.fogo01.scicraft.block;

import com.fogo01.scicraft.init.ModBlocks;
import com.fogo01.scicraft.reference.Names;
import net.minecraft.world.IBlockAccess;

public class BlockTinBlock extends BlockSciCraft {
    public BlockTinBlock() {
        super();
        this.setBlockName(Names.Blocks.TIN_BLOCK);
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
        return worldObj.getBlock(x, y, z) == ModBlocks.TIN_BLOCK;
    }
}
