package com.fogo01.scicraft.blocks;

import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockMetalBlock extends BlockSciCraft {
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public BlockMetalBlock() {
        super();
        this.setBlockName(Names.Blocks.METAL_BLOCK);
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
        for (int meta = 0; meta < Names.Blocks.METAL_BLOCKS.length; meta++)
            list.add(new ItemStack(this, 1, meta));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return icons[meta];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icons = new IIcon[Names.Blocks.METAL_BLOCKS.length];
        for (int i = 0; i < icons.length; i++) {
            icons[i] = iconRegister.registerIcon(Reference.MOD_ID + ":" + Names.Blocks.METAL_BLOCKS[i]);
        }
    }
}

