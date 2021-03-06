package com.fogo01.scicraft.blocks.containers;

import com.fogo01.scicraft.SciCraft;
import com.fogo01.scicraft.blocks.BlockSciCraftContainer;
import com.fogo01.scicraft.crativetab.CreativeTabSciCraft;
import com.fogo01.scicraft.init.ModBlocks;
import com.fogo01.scicraft.init.ModItems;
import com.fogo01.scicraft.reference.GUIs;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.tileentity.TileEntityPoweredFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockPoweredFurnace extends BlockSciCraftContainer {
    @SideOnly(Side.CLIENT)
    private IIcon iconTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;
    @SideOnly(Side.CLIENT)
    private IIcon iconSide;
    @SideOnly(Side.CLIENT)
    private IIcon iconSideActive;
    private boolean isActive;

    public BlockPoweredFurnace(boolean blockState) {
        super();
        this.setBlockName(Names.Blocks.POWERED_FURNACE);
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setCreativeTab(blockState ? null : CreativeTabSciCraft.SciCraft_TAB);
        this.isActive = blockState;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (!player.isSneaking())
            if (player.getHeldItem() != null && (player.getHeldItem().getItem() == ModItems.WRENCH || player.getHeldItem().getItem() == ModItems.MULTIMETER))
                return false;
        if (!world.isRemote)
            if (world.getTileEntity(x, y, z) instanceof TileEntityPoweredFurnace)
                player.openGui(SciCraft.instance, GUIs.POWERED_FURNACE.ordinal(), world, x, y, z);

        return true;
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultOrientation(world, x, y, z);
    }

    private void setDefaultOrientation(World world, int x, int y, int z) {
        if (!world.isRemote) {
            Block block = world.getBlock(x, y, z - 1);
            Block block1 = world.getBlock(x, y, z + 1);
            Block block2 = world.getBlock(x - 1, y, z);
            Block block3 = world.getBlock(x + 1, y, z);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j()) {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j()) {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j()) {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j()) {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemStack) {
        int l = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

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
        return new TileEntityPoweredFurnace();
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return metadata == 0 && side == 3 ? (isActive ? iconSideActive : iconSide) : side == 1 ? this.iconTop : (side == 0 ? this.iconBottom : (side == metadata ? iconSide : this.blockIcon));
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
        iconSide = iconRegister.registerIcon(String.format("%s%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()), "_side"));
        iconSideActive = iconRegister.registerIcon(String.format("%s%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()), "_side_on"));
        iconTop = iconRegister.registerIcon(String.format("%s%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()), "_top"));
        iconBottom = iconRegister.registerIcon(String.format("%s%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()), "_bottom"));
    }

    public static void updateBlockState(boolean smelting, World world, int x, int y, int z) {
        int metadata = world.getBlockMetadata(x, y, z);
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        keepInventory = true;

        if (smelting) {
            world.setBlock(x, y, z, ModBlocks.POWERED_FURNACE_ACTIVE);
        } else {
            world.setBlock(x, y, z, ModBlocks.POWERED_FURNACE);
        }

        keepInventory = false;
        world.setBlockMetadataWithNotify(x, y, z, metadata, 2);

        if (tileEntity != null) {
            tileEntity.validate();
            world.setTileEntity(x, y, z, tileEntity);
        }
    }
}