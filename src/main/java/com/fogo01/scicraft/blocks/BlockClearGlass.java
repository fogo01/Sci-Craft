package com.fogo01.scicraft.blocks;

import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockClearGlass extends BlockSciCraft {
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public BlockClearGlass() {
        super(Material.glass);
        this.setBlockName(Names.Blocks.CLEAR_GLASS);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setLightOpacity(0);
    }

    @Override
    public boolean getUseNeighborBrightness() {
        return true;
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
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
        if (world.getBlockMetadata(x, y, z) != world.getBlockMetadata(x - Facing.offsetsXForSide[side], y - Facing.offsetsYForSide[side], z - Facing.offsetsZForSide[side]))
        {
            return true;
        }

        if (world.getBlock(x, y, z) == this)
        {
            return false;
        }
        return super.shouldSideBeRendered(world, x, y, z, side);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        return GetIconForConnectedTexture(world, x, y, z, side, icons);
    }



    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata) {
        return icons[0];
    }



    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        icons = new IIcon[47];

        for (int i = 0; i < icons.length; i++) {
            icons[i] = iconRegister.registerIcon(Reference.MOD_ID + ":ClearGlass (" + i + ")");
        }
    }
}
