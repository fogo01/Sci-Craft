package com.fogo01.scicraft.container.inventory;

import com.fogo01.scicraft.tileentity.TileEntityBatteryCell;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBatteryCell extends Container {
    private TileEntityBatteryCell tileEntityBatteryCell;
    private int lastEnergyAmount;
    private int lastItemEnergyAmount1;
    private int lastItemEnergyAmount2;

    public ContainerBatteryCell(InventoryPlayer inventoryPlayer, TileEntityBatteryCell tileEntityBatteryCell) {
        this.tileEntityBatteryCell = tileEntityBatteryCell;
        this.addSlotToContainer(new Slot(tileEntityBatteryCell, 0, 8, 62));
        this.addSlotToContainer(new Slot(tileEntityBatteryCell, 1, 152, 62));

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
        return this.tileEntityBatteryCell.isUseableByPlayer(player);
    }

    @Override
    public void addCraftingToCrafters(ICrafting iCrafting) {
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.tileEntityBatteryCell.currentEnergyAmount);
        iCrafting.sendProgressBarUpdate(this, 1, this.tileEntityBatteryCell.itemEnergyAmount1);
        iCrafting.sendProgressBarUpdate(this, 2, this.tileEntityBatteryCell.itemEnergyAmount2);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastEnergyAmount != this.tileEntityBatteryCell.currentEnergyAmount) {
                icrafting.sendProgressBarUpdate(this, 0, this.tileEntityBatteryCell.currentEnergyAmount);
            }
            if (this.lastItemEnergyAmount1 != this.tileEntityBatteryCell.itemEnergyAmount1) {
                icrafting.sendProgressBarUpdate(this, 1, this.tileEntityBatteryCell.itemEnergyAmount1);
            }
            if (this.lastItemEnergyAmount2 != this.tileEntityBatteryCell.itemEnergyAmount2) {
                icrafting.sendProgressBarUpdate(this, 1, this.tileEntityBatteryCell.itemEnergyAmount2);
            }
        }

        this.lastEnergyAmount = this.tileEntityBatteryCell.currentEnergyAmount;
        this.lastItemEnergyAmount1 = this.tileEntityBatteryCell.itemEnergyAmount1;
        this.lastItemEnergyAmount2 = this.tileEntityBatteryCell.itemEnergyAmount2;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int p_75137_1_, int p_75137_2_) {
        if (p_75137_1_ == 0) {
            this.tileEntityBatteryCell.currentEnergyAmount = p_75137_2_;
        }
        if (p_75137_1_ == 1) {
            this.tileEntityBatteryCell.itemEnergyAmount1 = p_75137_2_;
        }
        if (p_75137_1_ == 2) {
            this.tileEntityBatteryCell.itemEnergyAmount2 = p_75137_2_;
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int i) {
        return null;
    }
}
