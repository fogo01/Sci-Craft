package com.fogo01.scicraft.items;

import com.fogo01.scicraft.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemMediumBattery extends ItemSciCraft {
    public ItemMediumBattery() {
        super();
        this.setUnlocalizedName(Names.Items.MEDIUM_BATTERY);
        this.setMaxStackSize(1);
        this.setMaxDamage((int)1e5);
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        double dmg = (itemStack.getMaxDamage() - itemStack.getItemDamage()) / ((double) itemStack.getMaxDamage());

        if (dmg > 2/3D)
            list.add("Energy: " + EnumChatFormatting.GREEN + (itemStack.getMaxDamage() - itemStack.getItemDamage()) + "/" + itemStack.getMaxDamage() + "W");
        else if (dmg > 1/3D)
            list.add("Energy: " + EnumChatFormatting.YELLOW + (itemStack.getMaxDamage() - itemStack.getItemDamage()) + "/" + itemStack.getMaxDamage() + "W");
        else
            list.add("Energy: " + EnumChatFormatting.RED + (itemStack.getMaxDamage() - itemStack.getItemDamage()) + "/" + itemStack.getMaxDamage() + "W");
    }
}
