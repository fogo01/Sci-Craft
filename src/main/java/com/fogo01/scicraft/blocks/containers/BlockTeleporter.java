package com.fogo01.scicraft.blocks.containers;

import com.fogo01.scicraft.SciCraft;
import com.fogo01.scicraft.blocks.BlockSciCraftContainer;
import com.fogo01.scicraft.entities.ExtendedPlayer;
import com.fogo01.scicraft.init.ModItems;
import com.fogo01.scicraft.reference.GUIs;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.tileentity.TileEntityTeleporter;
import com.fogo01.scicraft.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockTeleporter extends BlockSciCraftContainer {
    @SideOnly(Side.CLIENT)
    private IIcon iconTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;

    public EntityPlayer player = null;

    public BlockTeleporter() {
        super();
        this.setBlockName(Names.Blocks.TELEPORTER);
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
            if (world.getTileEntity(x, y, z) instanceof TileEntityTeleporter)
                player.openGui(SciCraft.instance, GUIs.TELEPORTER.ordinal(), world, x, y, z);

        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack) {
        if (!(entityLiving instanceof EntityPlayer))
            return;

        if (!world.isRemote) {
            EntityPlayer player = (EntityPlayer) entityLiving;

            ExtendedPlayer props = ExtendedPlayer.get(player);

            props.addTeleporterPosition(player.dimension, x, y, z);
        }

        this.player = (EntityPlayer)entityLiving;
    }

    @Override
    public void onBlockPreDestroy(World world, int x, int y, int z, int metadata) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileEntityTeleporter) {
            TileEntityTeleporter teleporter = (TileEntityTeleporter)tileEntity;
            if (teleporter.getPlayer() != null) {
                ExtendedPlayer props = ExtendedPlayer.get(teleporter.getPlayer());

                props.removeTeleporterPosition(world.provider.dimensionId, x, y, z);
            }
        }
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

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityTeleporter();
    }
}
