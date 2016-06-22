package com.fogo01.scicraft.blocks.containers;

import com.fogo01.scicraft.SciCraft;
import com.fogo01.scicraft.blocks.BlockSciCraftContainer;
import com.fogo01.scicraft.init.ModItems;
import com.fogo01.scicraft.reference.GUIs;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.tileentity.TileEntityRocketFactory;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockRocketFactory extends BlockSciCraftContainer {
    @SideOnly(Side.CLIENT)
    private IIcon iconTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;

    public BlockRocketFactory() {
        this.setBlockName(Names.Blocks.ROCKET_FACTORY);
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (player.isSneaking())
            return false;
        if (!world.isRemote)
            if (world.getTileEntity(x, y, z) instanceof TileEntityRocketFactory)
                player.openGui(SciCraft.instance, GUIs.ROCKET_FACTORY.ordinal(), world, x, y, z);

        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityRocketFactory();
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return side == 0 ? this.iconBottom : side == 1 ? this.iconTop : this.blockIcon;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
        iconTop = iconRegister.registerIcon(String.format("%s%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()), "_top"));
        iconBottom = iconRegister.registerIcon(String.format("%s%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()), "_bottom"));
    }
}
