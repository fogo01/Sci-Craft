package com.fogo01.scicraft.block;

import com.fogo01.scicraft.crativetab.CreativeTabSciCraft;
import com.fogo01.scicraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import java.util.Random;

public class BlockSciCraft extends Block {
    public BlockSciCraft(Material material){
        super(material);
        this.setCreativeTab(CreativeTabSciCraft.SciCraft_TAB);
    }

    public BlockSciCraft(){
        this(Material.rock);
    }

    public int quantityDropped(Random p_149745_1_) {
        return 1;
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
