package com.fogo01.scicraft.items;

import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Values;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemMediumBattery extends ItemSciCraft {
    public ItemMediumBattery() {
        super();
        this.setUnlocalizedName(Names.Items.MEDIUM_BATTERY);
        this.setMaxStackSize(1);
        this.setMaxDamage(Values.Batteries.MEDIUM_BATTERY_STORAGE);
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        double dmg = (itemStack.getMaxDamage() - itemStack.getItemDamage()) / ((double) itemStack.getMaxDamage());

        if (dmg > 2/3D)
            list.add("Energy: " + EnumChatFormatting.GREEN + (itemStack.getMaxDamage() - itemStack.getItemDamage()) + "/" + itemStack.getMaxDamage() + Values.ENERGY_STORAGE);
        else if (dmg > 1/3D)
            list.add("Energy: " + EnumChatFormatting.YELLOW + (itemStack.getMaxDamage() - itemStack.getItemDamage()) + "/" + itemStack.getMaxDamage() + Values.ENERGY_STORAGE);
        else
            list.add("Energy: " + EnumChatFormatting.RED + (itemStack.getMaxDamage() - itemStack.getItemDamage()) + "/" + itemStack.getMaxDamage() + Values.ENERGY_STORAGE);
    }
}
