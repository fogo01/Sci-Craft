package com.fogo01.scicraft.items;

import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Values;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemBlockTransporter extends ItemSciCraft {
    Block block;
    int meta;
    TileEntity tileEntity;

    public ItemBlockTransporter() {
        super();
        this.setUnlocalizedName(Names.Items.BLOCK_TRANSPORTER);
        this.setMaxStackSize(1);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (!world.isRemote) {
            if (block == null) {
                block = world.getBlock(x, y, z);
                meta = world.getBlockMetadata(x, y, z);
                tileEntity = world.getTileEntity(x, y, z);

                world.setBlockToAir(x, y, z);
            } else {
                if (side == 0)
                    y--;
                else if (side == 1)
                    y++;
                else if (side == 2)
                    z--;
                else if (side == 3)
                    z++;
                else if (side == 4)
                    x--;
                else if (side == 5)
                    x++;

                world.setBlock(x, y, z, block);
                world.setBlockMetadataWithNotify(x, y, z, meta, 1);
                if (tileEntity != null) {
                    tileEntity.xCoord = x;
                    tileEntity.yCoord = y;
                    tileEntity.zCoord = z;
                    world.setTileEntity(x, y, z, tileEntity);
                }

                block = null;
                meta = 0;
                tileEntity = null;
            }
        }
        return true;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        if (block != null)
            list.add(block.getLocalizedName());
        else
            list.add("Empty");
    }
}
