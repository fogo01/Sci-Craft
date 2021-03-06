package com.fogo01.scicraft.container.inventory;

import com.fogo01.scicraft.tileentity.TileEntityCrusher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class ContainerCrusher extends Container {
    private TileEntityCrusher tileEntityCrusher;
    private int lastEnergyAmount;
    private int lastCrushTime;

    public ContainerCrusher(InventoryPlayer inventoryPlayer, TileEntityCrusher tileEntityCrusher) {
        this.tileEntityCrusher = tileEntityCrusher;
        this.addSlotToContainer(new Slot(tileEntityCrusher, 0, 56, 34));
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tileEntityCrusher, 1, 116, 35));
        this.addSlotToContainer(new Slot(tileEntityCrusher, 2, 152, 62));

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
        return this.tileEntityCrusher.isUseableByPlayer(player);
    }

    @Override
    public void addCraftingToCrafters(ICrafting iCrafting) {
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.tileEntityCrusher.currentEnergyAmount);
        iCrafting.sendProgressBarUpdate(this, 1, this.tileEntityCrusher.crushTime);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastEnergyAmount != this.tileEntityCrusher.currentEnergyAmount) {
                icrafting.sendProgressBarUpdate(this, 0, this.tileEntityCrusher.currentEnergyAmount);
            }
            if (this.lastCrushTime != this.tileEntityCrusher.crushTime) {
                icrafting.sendProgressBarUpdate(this, 1, this.tileEntityCrusher.crushTime);
            }
        }

        this.lastEnergyAmount = this.tileEntityCrusher.currentEnergyAmount;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int p_75137_1_, int p_75137_2_) {
        if (p_75137_1_ == 0) {
            this.tileEntityCrusher.currentEnergyAmount = p_75137_2_;
        }
        if (p_75137_1_ == 1) {
            this.tileEntityCrusher.crushTime = p_75137_2_;
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int i) {
        return null;
    }
}
