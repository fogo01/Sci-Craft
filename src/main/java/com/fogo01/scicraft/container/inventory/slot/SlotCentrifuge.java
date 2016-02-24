package com.fogo01.scicraft.container.inventory.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCentrifuge extends Slot {

    public SlotCentrifuge(EntityPlayer player, IInventory inventory, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_) {
        super(inventory, p_i1824_2_, p_i1824_3_, p_i1824_4_);
    }

    @Override
    public boolean isItemValid(ItemStack p_75214_1_) {
        return false;
    }
}
