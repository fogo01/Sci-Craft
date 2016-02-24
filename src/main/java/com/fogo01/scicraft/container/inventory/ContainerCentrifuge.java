package com.fogo01.scicraft.container.inventory;

import com.fogo01.scicraft.container.inventory.slot.SlotAlloySmelter;
import com.fogo01.scicraft.tileentity.TileEntityCentrifuge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCentrifuge extends Container {
    private TileEntityCentrifuge tileEntityCentrifuge;
    private int lastEnergyAmount;
    private int lastCookTime;

    public ContainerCentrifuge(InventoryPlayer inventoryPlayer, TileEntityCentrifuge tileEntityCentrifuge) {
        this.tileEntityCentrifuge = tileEntityCentrifuge;
        this.addSlotToContainer(new Slot(tileEntityCentrifuge, 0, 56, 25));
        this.addSlotToContainer(new Slot(tileEntityCentrifuge, 1, 56, 43));
        this.addSlotToContainer(new SlotAlloySmelter(inventoryPlayer.player, tileEntityCentrifuge, 2, 116, 34));
        this.addSlotToContainer(new Slot(tileEntityCentrifuge, 3, 152, 62));

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.tileEntityCentrifuge.isUseableByPlayer(player);
    }

    @Override
    public void addCraftingToCrafters(ICrafting iCrafting) {
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.tileEntityCentrifuge.currentEnergyAmount);
        iCrafting.sendProgressBarUpdate(this, 1, this.tileEntityCentrifuge.cookTime);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastEnergyAmount != this.tileEntityCentrifuge.currentEnergyAmount) {
                icrafting.sendProgressBarUpdate(this, 0, this.tileEntityCentrifuge.currentEnergyAmount);
            }
            if (this.lastCookTime != this.tileEntityCentrifuge.cookTime) {
                icrafting.sendProgressBarUpdate(this, 1, this.tileEntityCentrifuge.cookTime);
            }
        }

        this.lastEnergyAmount = this.tileEntityCentrifuge.currentEnergyAmount;
        this.lastCookTime = this.tileEntityCentrifuge.cookTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int p_75137_1_, int p_75137_2_) {
        if (p_75137_1_ == 0) {
            this.tileEntityCentrifuge.currentEnergyAmount = p_75137_2_;
        }
        if (p_75137_1_ == 1) {
            this.tileEntityCentrifuge.cookTime = p_75137_2_;
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int i) {
        return null;
    }
}
