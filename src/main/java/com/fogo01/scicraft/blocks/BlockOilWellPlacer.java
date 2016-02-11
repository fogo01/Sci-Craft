package com.fogo01.scicraft.blocks;

import com.fogo01.scicraft.init.ModBlocks;
import com.fogo01.scicraft.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.Random;

public class BlockOilWellPlacer extends BlockSciCraft{
    public BlockOilWellPlacer() {
        super();
        this.setBlockName(Names.Blocks.OIL_WELL_PLACER);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        int bottom = 16 + new Random().nextInt(20);

        for (; y > bottom; y--)
            world.setBlock(x, y, z, ModBlocks.OIL_BLOCK);

        int radius = 8 + new Random().nextInt(4);
        for (int x1 = -radius; x1 <= radius; x1++)
            for (int y1 = -radius; y1 <= radius; y1++)
                for (int z1 = -radius; z1 <= radius; z1++)
                    if (x1 * x1 + y1 * y1 + z1 * z1 <= radius * radius)
                        world.setBlock(x + x1, y + y1, z + z1, ModBlocks.OIL_BLOCK);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        int bottom = 16 + new Random().nextInt(20);

        for (; y > bottom; y--)
            world.setBlock(x, y, z, ModBlocks.OIL_BLOCK);

        int radius = 8 + new Random().nextInt(4);
        for (int x1 = -radius; x1 <= radius; x1++)
            for (int y1 = -radius; y1 <= radius; y1++)
                for (int z1 = -radius; z1 <= radius; z1++)
                    if (x1 * x1 + y1 * y1 + z1 * z1 <= radius * radius)
                        world.setBlock(x + x1, y + y1, z + z1, ModBlocks.OIL_BLOCK);
        return true;
    }
}
