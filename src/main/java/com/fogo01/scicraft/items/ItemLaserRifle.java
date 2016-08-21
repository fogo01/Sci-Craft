package com.fogo01.scicraft.items;

import com.fogo01.scicraft.entities.projectile.EntityLaserBeam;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Values;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemLaserRifle extends ItemSciCraft {
    public ItemLaserRifle() {
        super();
        this.setUnlocalizedName(Names.Items.LASER_RIFLE);
        this.setMaxStackSize(1);
        this.setMaxDamage(Values.Items.LaserRifle.ENERGY_STORAGE);
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

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (player.capabilities.isCreativeMode || itemStack.getItemDamage() < itemStack.getMaxDamage()) {
            EntityLaserBeam laserBeam = new EntityLaserBeam(world, player);

            world.spawnEntityInWorld(laserBeam);
            if (!player.capabilities.isCreativeMode)
                itemStack.setItemDamage(itemStack.getItemDamage() + Values.Items.LaserRifle.ENERGY_USE);
        }
        return itemStack;
    }
}
