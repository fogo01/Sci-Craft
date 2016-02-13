package com.fogo01.scicraft.items;

import com.fogo01.scicraft.blocks.BlockSciCraftContainer;
import com.fogo01.scicraft.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWrench extends ItemSciCraft {
    public ItemWrench() {
        super();
        this.setUnlocalizedName(Names.Items.WRENCH);
        this.setMaxStackSize(1);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (!world.isRemote) {
            if (world.getBlock(x, y, z) instanceof BlockSciCraftContainer) {
                if (!player.isSneaking())
                    ((BlockSciCraftContainer) world.getBlock(x, y, z)).rotate(world, x, y, z);
                else {
                    world.getBlock(x, y, z).dropBlockAsItemWithChance(world, x, y, z, 0, 1.0F, 0);
                    world.getBlock(x, y, z).breakBlock(world, x, y, z, world.getBlock(x, y, z), world.getBlockMetadata(x, y, z));
                    world.setBlockToAir(x, y, z);
                }
            }
        }
        return true;
    }
}
