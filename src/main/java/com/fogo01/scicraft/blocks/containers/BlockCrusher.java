package com.fogo01.scicraft.blocks.containers;

import com.fogo01.scicraft.SciCraft;
import com.fogo01.scicraft.blocks.BlockSciCraftContainer;
import com.fogo01.scicraft.init.ModItems;
import com.fogo01.scicraft.reference.GUIs;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.tileentity.TileEntityCrusher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockCrusher extends BlockSciCraftContainer {
    @SideOnly(Side.CLIENT)
    private IIcon iconTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;
    @SideOnly(Side.CLIENT)
    private IIcon iconSide;

    public BlockCrusher() {
        super();
        this.setBlockName(Names.Blocks.CRUSHER);
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (!player.isSneaking())
            if (player.getHeldItem() != null && (player.getHeldItem().getItem() == ModItems.WRENCH || player.getHeldItem().getItem() == ModItems.MULTIMETER))
                return false;
        if (!world.isRemote)
            if (world.getTileEntity(x, y, z) instanceof TileEntityCrusher)
                player.openGui(SciCraft.instance, GUIs.CRUSHER.ordinal(), world, x, y, z);

        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemStack) {
        int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }
        if (l == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }
        if (l == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }
        if (l == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityCrusher();
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return side == 1 ? this.iconTop : (side == 0 ? this.iconBottom : (side == metadata ? iconSide : this.blockIcon));
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
        iconSide = iconRegister.registerIcon(String.format("%s%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()), "_side"));
        iconTop = iconRegister.registerIcon(String.format("%s%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()), "_top"));
        iconBottom = iconRegister.registerIcon(String.format("%s%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()), "_bottom"));
    }
}
