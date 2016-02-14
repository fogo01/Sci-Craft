package com.fogo01.scicraft.blocks;

import com.fogo01.scicraft.crativetab.CreativeTabSciCraft;
import com.fogo01.scicraft.init.ModBlocks;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.tileentity.TileEntityEnergyCable;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

public class BlockEnergyCable extends BlockPipe {
    public BlockEnergyCable(){
        super();
        this.setBlockName(Names.Blocks.ENERGY_CABLE);
        this.setCreativeTab(CreativeTabSciCraft.SciCraft_TAB);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityEnergyCable();
    }
}
