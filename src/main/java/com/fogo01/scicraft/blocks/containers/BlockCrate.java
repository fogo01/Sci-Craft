package com.fogo01.scicraft.blocks.containers;

import com.fogo01.scicraft.blocks.BlockSciCraftContainer;
import com.fogo01.scicraft.init.ModBlocks;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import static com.fogo01.scicraft.blocks.BlockSciCraft.GetIconForConnectedTexture;

public class BlockCrate extends BlockSciCraftContainer {
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public BlockCrate() {
        super(Material.wood);
        this.setBlockName(Names.Blocks.CRATE);
        this.setHarvestLevel("axe", 0);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }

    public boolean CanConnectTo(IBlockAccess world, int x, int y, int z) {
        Block block = world.getBlock(x, y, z);
        return block == ModBlocks.CRATE;
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
            icons[i] = iconRegister.registerIcon(Reference.MOD_ID + ":Crate_" + i);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return null;
    }
}
