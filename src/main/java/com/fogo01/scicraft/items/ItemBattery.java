package com.fogo01.scicraft.items;

import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemBattery extends ItemSciCraft {
    @SideOnly(Side.CLIENT)
    IIcon[] icons;

    public ItemBattery() {
        super();
        this.setUnlocalizedName(Names.Items.BATTERY);
        this.setMaxStackSize(1);
        this.setMaxDamage(32000);
    }

    @Override
    public IIcon getIconFromDamage(int damage) {
        double dmg = (getMaxDamage() - damage) / (double)getMaxDamage();
        int icon;
        if (dmg >= 6/6D)
            icon = 6;
        else if (dmg > 5/6D)
            icon = 5;
        else if (dmg > 4/6D)
            icon = 4;
        else if (dmg > 3/6D)
            icon = 3;
        else if (dmg > 2/6D)
            icon = 2;
        else if (dmg > 1/6D)
            icon = 1;
        else
            icon = 0;
        return icons[icon];
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        icons = new IIcon[7];
        for (int i = 0; i < icons.length; i++) {
            icons[i] = iconRegister.registerIcon(Reference.MOD_ID + ":" + Names.Items.BATTERY + "_" + i);
        }
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
