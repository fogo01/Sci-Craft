package com.fogo01.scicraft.blocks;

import com.fogo01.scicraft.crativetab.CreativeTabSciCraft;
import com.fogo01.scicraft.init.ModBlocks;
import com.fogo01.scicraft.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class BlockEnergyCable extends BlockSciCraft {
    public BlockEnergyCable(){
        super();
        this.setBlockName(Names.Blocks.ENERGY_CABLE);
        this.setCreativeTab(CreativeTabSciCraft.SciCraft_TAB);
    }

    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
        boolean flag = this.canConnectCableTo(world, x, y, z - 1);
        boolean flag1 = this.canConnectCableTo(world, x, y, z + 1);
        boolean flag2 = this.canConnectCableTo(world, x - 1, y, z);
        boolean flag3 = this.canConnectCableTo(world, x + 1, y, z);
        boolean flag4 = this.canConnectCableTo(world, x, y - 1, z);
        boolean flag5 = this.canConnectCableTo(world, x, y + 1, z);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;
        float f4 = 0.375F;
        float f5 = 0.625F;

        if (flag) {
            f2 = 0.0F;
        }
        if (flag1) {
            f3 = 1.0F;
        }
        if (flag || flag1) {
            this.setBlockBounds(f, f4, f2, f1, f5, f3);
            super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
        }

        f2 = 0.375F;
        f3 = 0.625F;

        if (flag2) {
            f = 0.0F;
        }
        if (flag3) {
            f1 = 1.0F;
        }
        if (flag2 || flag3 || !flag && !flag1) {
            this.setBlockBounds(f, f4, f2, f1, f5, f3);
            super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
        }

        if (flag) {
            f2 = 0.0F;
        }
        if (flag1) {
            f3 = 1.0F;
        }
        this.setBlockBounds(f, f4, f2, f1, f5, f3);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z ) {
        boolean flag = this.canConnectCableTo(world, x, y, z - 1);
        boolean flag1 = this.canConnectCableTo(world, x, y, z + 1);
        boolean flag2 = this.canConnectCableTo(world, x - 1, y, z);
        boolean flag3 = this.canConnectCableTo(world, x + 1, y, z);
        boolean flag4 = this.canConnectCableTo(world, x, y - 1, z);
        boolean flag5 = this.canConnectCableTo(world, x, y + 1, z);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;
        float f4 = 0.375F;
        float f5 = 0.625F;

        if (flag) {
            f2 = 0.0F;
        }
        if (flag1) {
            f3 = 1.0F;
        }
        if (flag2) {
            f = 0.0F;
        }
        if (flag3) {
            f1 = 1.0F;
        }
        if (flag4) {
            f4 = 0.0F;
        }
        if (flag5) {
            f5 = 1.0F;
        }
        this.setBlockBounds(f, f4, f2, f1, f5, f3);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return -1;
    }

    public boolean canConnectCableTo(IBlockAccess world, int x, int y, int z) {
        Block block = world.getBlock(x, y, z);
        return block == this || block == ModBlocks.SOLAR_PANEL;
    }
}
