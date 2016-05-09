package com.fogo01.scicraft.container.inventory;

import com.fogo01.scicraft.tileentity.TileEntityRefinery;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerRefinery extends Container {
    private TileEntityRefinery tileEntityRefinery;
    private int lastOilAmount;
    private int lastFuelAmount;
    private int lastEnergyAmount;
    private int lastRefineTime;

    public ContainerRefinery(InventoryPlayer inventoryPlayer, TileEntityRefinery tileEntityRefinery) {
        this.tileEntityRefinery = tileEntityRefinery;
        this.addSlotToContainer(new Slot(tileEntityRefinery, 0, 8, 62));
        this.addSlotToContainer(new Slot(tileEntityRefinery, 1, 152, 62));
        this.addSlotToContainer(new Slot(tileEntityRefinery, 2, 80, 62));
        this.addSlotToContainer(new Slot(tileEntityRefinery, 3, 38, 44));

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
        return this.tileEntityRefinery.isUseableByPlayer(player);
    }

    @Override
    public void addCraftingToCrafters(ICrafting iCrafting) {
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.tileEntityRefinery.currentOilAmount);
        iCrafting.sendProgressBarUpdate(this, 1, this.tileEntityRefinery.currentFuelAmount);
        iCrafting.sendProgressBarUpdate(this, 2, this.tileEntityRefinery.currentEnergyAmount);
        iCrafting.sendProgressBarUpdate(this, 3, this.tileEntityRefinery.refiningTime);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastOilAmount != this.tileEntityRefinery.currentOilAmount) {
                icrafting.sendProgressBarUpdate(this, 0, this.tileEntityRefinery.currentOilAmount);
            }
            if (this.lastFuelAmount != this.tileEntityRefinery.currentFuelAmount) {
                icrafting.sendProgressBarUpdate(this, 1, this.tileEntityRefinery.currentFuelAmount);
            }
            if (this.lastEnergyAmount != this.tileEntityRefinery.currentEnergyAmount) {
                icrafting.sendProgressBarUpdate(this, 2, this.tileEntityRefinery.currentEnergyAmount);
            }
            if (this.lastRefineTime != this.tileEntityRefinery.refiningTime) {
                icrafting.sendProgressBarUpdate(this, 3, this.tileEntityRefinery.refiningTime);
            }
        }

        this.lastOilAmount = this.tileEntityRefinery.currentOilAmount;
        this.lastFuelAmount = this.tileEntityRefinery.currentFuelAmount;
        this.lastEnergyAmount = this.tileEntityRefinery.currentEnergyAmount;
        this.lastRefineTime = this.tileEntityRefinery.refiningTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int p_75137_1_, int p_75137_2_) {
        if (p_75137_1_ == 0) {
            this.tileEntityRefinery.currentOilAmount = p_75137_2_;
        }
        if (p_75137_1_ == 1) {
            this.tileEntityRefinery.currentFuelAmount = p_75137_2_;
        }
        if (p_75137_1_ == 2) {
            this.tileEntityRefinery.currentEnergyAmount = p_75137_2_;
        }
        if (p_75137_1_ == 3) {
            this.tileEntityRefinery.refiningTime = p_75137_2_;
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int i) {
        return null;
    }
}