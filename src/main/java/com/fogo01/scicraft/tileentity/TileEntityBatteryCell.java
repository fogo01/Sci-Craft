package com.fogo01.scicraft.tileentity;

import com.fogo01.scicraft.reference.Chargeables;
import com.fogo01.scicraft.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityBatteryCell extends TileEntitySciCraftEnergy implements ISidedInventory {
    private static final int[] slotsTop = new int[]{0};
    private static final int[] slotsBottom = new int[]{0};
    private static final int[] slotsSides = new int[]{0};
    public int itemEnergyAmount1 = 0;
    private int maxItemEnergyAmount1 = 1;
    public int itemEnergyAmount2 = 0;
    private int maxItemEnergyAmount2 = 1;

    public TileEntityBatteryCell() {
        maxEnergyAmount = (int)1e6;
        currentEnergyAmount = 0;
        transferRate = 16000;
        acceptingEnergy = true;
        inventory = new ItemStack[2];
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        currentEnergyAmount = nbtTagCompound.getInteger("currentEnergyAmount");

        NBTTagList nbttaglist = nbtTagCompound.getTagList("Items", 10);
        this.inventory = new ItemStack[this.getSizeInventory()];
        for(int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");
            if(b0 >= 0 && b0 < this.inventory.length) {
                this.inventory[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        if(nbtTagCompound.hasKey("CustomName", 8)) {
            this.localizedName = nbtTagCompound.getString("CustomName");
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
        nbtTagCompound.setInteger("currentEnergyAmount", currentEnergyAmount);

        NBTTagList nbttaglist = new NBTTagList();
        for(int i = 0; i < this.inventory.length; ++i) {
            if(this.inventory[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.inventory[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        nbtTagCompound.setTag("Items", nbttaglist);

        if(this.hasCustomInventoryName()) {
            nbtTagCompound.setString("CustomName", this.localizedName);
        }
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return side == 0 ? slotsBottom : (side == 1 ? slotsTop : slotsSides);
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemStack, int p_102007_3_) {
        return this.isItemValidForSlot(slot, itemStack);
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return true;
    }

    @Override
    public int getSizeInventory() {
        return this.inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        if (this.inventory[slot] != null)
        {
            ItemStack itemstack;

            if (this.inventory[slot].stackSize <= amount)
            {
                itemstack = this.inventory[slot];
                this.inventory[slot] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.inventory[slot].splitStack(amount);

                if (this.inventory[slot].stackSize == 0)
                {
                    this.inventory[slot] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        if (inventory[slot] != null)
        {
            ItemStack itemStack = inventory[slot];
            inventory[slot] = null;
            return itemStack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        inventory[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
            itemStack.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    @Override
    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.localizedName : Names.Containers.CONTAINER_BATTERY_CELL;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return this.localizedName != null && this.localizedName.length() > 0;
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
        return slot == 0 ? isChargeable(itemStack) : true;
    }

    private boolean isChargeable(ItemStack itemStack) {
        for (int i = 0; i < Chargeables.items.length; i++)
            if (Chargeables.items[i] == itemStack.getItem())
                return true;
        return false;
    }

    @Override
    public void updateEntity() {
        itemEnergyAmount1 = 0;
        maxItemEnergyAmount1 = 1;
        if (inventory[0] != null && isBattery(inventory[0])) {
            transferEnergyFromItem(inventory[0], transferRate);
            itemEnergyAmount1 = inventory[0].getMaxDamage() - inventory[0].getItemDamage();
            maxItemEnergyAmount1 = inventory[0].getMaxDamage();
        }


        itemEnergyAmount2 = 0;
        maxItemEnergyAmount2 = 1;
        if (inventory[1] != null && isChargeable(inventory[1])) {
            itemEnergyAmount2 = inventory[1].getMaxDamage() - inventory[1].getItemDamage();
            maxItemEnergyAmount2 = inventory[1].getMaxDamage();

            if (inventory[1].getItemDamage() > 0) {
                if (inventory[1].getItemDamage() > transferRate) {
                    if (currentEnergyAmount >= transferRate) {
                        inventory[1].setItemDamage(inventory[1].getItemDamage() - transferRate);
                        currentEnergyAmount -= transferRate;
                    }
                } else {
                    currentEnergyAmount -= inventory[1].getItemDamage();
                    inventory[1].setItemDamage(0);
                }
            }
        }
    }

    public int getEnergyAmountScaled(int i) {
        return this.currentEnergyAmount * i / this.maxEnergyAmount;
    }

    public int getItemEnergyAmount1Scaled(int i) {
        return (int)(this.itemEnergyAmount1 * i / (double)this.maxItemEnergyAmount1);
    }

    public int getItemEnergyAmount2Scaled(int i) {
        return (int)(this.itemEnergyAmount2 * i / (double)this.maxItemEnergyAmount2);
    }
}
