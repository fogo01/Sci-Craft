package com.fogo01.scicraft.tileentity;

import com.fogo01.scicraft.blocks.containers.BlockCrusher;
import com.fogo01.scicraft.crafting.MachineRecipes;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Values;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityRefinery extends TileEntitySciCraftEnergy implements ISidedInventory {
    private static final int[] slotsTop = new int[]{0, 1};
    private static final int[] slotsBottom = new int[]{0, 1, 2};
    private static final int[] slotsSides = new int[]{2};
    public int energyUse = Values.Machines.Refinery.ENERGY_USE;
    public int refiningSpeed = Values.Machines.Refinery.REFINING_SPEED;
    public int refiningTime = 0;

    public int maxOilAmount = Values.Machines.Refinery.MAX_OIL_AMOUNT;
    public int maxFuelAmount = Values.Machines.Refinery.MAX_FUEL_AMOUNT;
    public int currentOilAmount = 0;
    public int currentFuelAmount = 0;

    public TileEntityRefinery() {
        maxEnergyAmount = Values.Machines.Refinery.ENERGY_STORAGE;
        currentEnergyAmount = 0;
        transferRate = Values.Machines.Refinery.TRANSFER_RATE;
        acceptingEnergy = true;
        inventory = new ItemStack[3];
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
        if (this.inventory[slot] != null) {
            ItemStack itemstack;

            if (this.inventory[slot].stackSize <= amount) {
                itemstack = this.inventory[slot];
                this.inventory[slot] = null;
                return itemstack;
            } else {
                itemstack = this.inventory[slot].splitStack(amount);

                if (this.inventory[slot].stackSize == 0) {
                    this.inventory[slot] = null;
                }

                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        if (inventory[slot] != null) {
            ItemStack itemStack = inventory[slot];
            inventory[slot] = null;
            return itemStack;
        } else {
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
        return this.hasCustomInventoryName() ? this.localizedName : Names.Containers.CONTAINER_REFINERY;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return this.localizedName != null && this.localizedName.length() > 0;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
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
        return true;
    }

    @Override
    public void updateEntity() {
        if (inventory[2] != null)
            transferEnergyFromItem(inventory[2], transferRate);

        boolean flag = this.isRefining();
        boolean flag1 = false;

        if (!this.worldObj.isRemote) {
            if (this.currentOilAmount > 0) {
                if (this.canRefine()) {
                    this.refiningTime++;
                    this.currentEnergyAmount -= energyUse;

                    if (this.refiningTime == refiningSpeed) {
                        this.refiningTime = 0;
                        this.refine();
                        flag1 = true;
                    }
                } else {
                    this.refiningTime = 0;
                }
            }

            if (flag != isRefining()) {
                flag1 = true;
                BlockCrusher.updateBlockState(this.isRefining(), worldObj, xCoord, yCoord, zCoord);
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }

    private boolean isRefining() {
        return this.refiningTime > 0;
    }


    private boolean canRefine() {
        if (this.currentOilAmount < 4) {
            return false;
        } else {
            if (currentEnergyAmount < energyUse)
                return false;
            if (currentFuelAmount >= maxFuelAmount)
                return false;
            return true;
        }
    }


    public void refine() {
        if (this.canRefine()) {
            currentOilAmount -= 8;
            currentFuelAmount += 1;
        }
    }

    public int getEnergyAmountScaled(int i) {
        return this.currentEnergyAmount * i / this.maxEnergyAmount;
    }

    public int getRefiningProgressScaled(int i) {
        return this.refiningTime * i / refiningSpeed;
    }

    public int getOilAmountScaled(int i) {
        return this.currentOilAmount * i / maxOilAmount;
    }

    public int getFuelAmountScaled(int i) {
        return this.currentFuelAmount * i / maxFuelAmount;
    }
}
