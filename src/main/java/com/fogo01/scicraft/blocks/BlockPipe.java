package com.fogo01.scicraft.blocks;

import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.tileentity.TileEntityPipe;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockPipe extends BlockSciCraftContainer {
    public BlockPipe() {
        super();
        this.setBlockName(Names.Blocks.PIPE);
        this.setBlockBounds(0.3125F, 0.3125F, 0.3125F, 1-0.3125F, 1-0.3125F, 1-0.3125F);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        if (world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z) instanceof TileEntityPipe) {
            TileEntityPipe pipe = (TileEntityPipe) world.getTileEntity(x, y, z);
            float minX = pipe.connections[5] != null ? 0F : 0.3125F;
            float maxX = pipe.connections[4] != null ? 1F : 1 - 0.3125F;
            float minY = pipe.connections[1] != null ? 0F : 0.3125F;
            float maxY = pipe.connections[0] != null ? 1F : 1 - 0.3125F;
            float minZ = pipe.connections[2] != null ? 0F : 0.3125F;
            float maxZ = pipe.connections[3] != null ? 1F : 1 - 0.3125F;
            this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
        }
        return AxisAlignedBB.getBoundingBox(x + this.minX, y + this.minY, z + this.minZ, x + this.maxX, y + this.maxY, z + this.maxZ);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
        if (world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z) instanceof TileEntityPipe) {
            TileEntityPipe pipe = (TileEntityPipe) world.getTileEntity(x, y, z);
            float minX = pipe.connections[5] != null ? 0F : 0.3125F;
            float maxX = pipe.connections[4] != null ? 1F : 1 - 0.3125F;
            float minY = pipe.connections[1] != null ? 0F : 0.3125F;
            float maxY = pipe.connections[0] != null ? 1F : 1 - 0.3125F;
            float minZ = pipe.connections[2] != null ? 0F : 0.3125F;
            float maxZ = pipe.connections[3] != null ? 1F : 1 - 0.3125F;
            this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
        }
        return AxisAlignedBB.getBoundingBox(x + this.minX, y + this.minY, z + this.minZ, x + this.maxX, y + this.maxY, z + this.maxZ);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }


    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityPipe();
    }
}
