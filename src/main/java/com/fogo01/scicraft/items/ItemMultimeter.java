package com.fogo01.scicraft.items;

import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Values;
import com.fogo01.scicraft.tileentity.TileEntitySciCraftEnergy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemMultimeter extends ItemSciCraft {
    public ItemMultimeter() {
        super();
        this.setUnlocalizedName(Names.Items.MULTIMETER);
        this.setMaxStackSize(1);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (!world.isRemote) {
            if (world.getTileEntity(x, y, z) instanceof TileEntitySciCraftEnergy) {
                TileEntitySciCraftEnergy tileEntity = (TileEntitySciCraftEnergy)world.getTileEntity(x, y, z);
                player.addChatMessage(new ChatComponentText("Energy: " + tileEntity.currentEnergyAmount + "/" + tileEntity.maxEnergyAmount + Values.ENERGY_STORAGE));
            }
        }
        return true;
    }
}
