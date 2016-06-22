package com.fogo01.scicraft.container.inventory.slot;

import com.fogo01.scicraft.tileentity.TileEntityRocketFactory;
import com.fogo01.scicraft.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotRocketFactory extends Slot {
    private TileEntityRocketFactory tileEntityRocketFactory;
    private EntityPlayer thePlayer;

    public SlotRocketFactory(EntityPlayer player, IInventory inventory, int slotIndex, int posX, int posY) {
        super(inventory, slotIndex, posX, posY);
        thePlayer = player;
        if (inventory instanceof TileEntityRocketFactory)
            tileEntityRocketFactory = (TileEntityRocketFactory)inventory;
    }

    @Override
    public boolean isItemValid(ItemStack p_75214_1_) {
        return false;
    }

    public void onPickupFromSlot(EntityPlayer p_82870_1_, ItemStack p_82870_2_) {
        super.onPickupFromSlot(p_82870_1_, p_82870_2_);

        for (int i = 0; i < tileEntityRocketFactory.inventory.length - 1; i++) {
            tileEntityRocketFactory.inventory[i].stackSize--;
            if (tileEntityRocketFactory.inventory[i].stackSize <= 0)
                tileEntityRocketFactory.inventory[i] = null;
        }
    }


}
