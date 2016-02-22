package com.fogo01.scicraft.tileentity;

import com.fogo01.scicraft.blocks.containers.BlockAlloySmelter;
import com.fogo01.scicraft.crafting.MachineRecipes;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Values;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityAlloySmelter extends TileEntitySciCraftEnergy implements ISidedInventory {
    private static final int[] slotsTop = new int[]{0, 1};
    private static final int[] slotsBottom = new int[]{2};
    private static final int[] slotsSides = new int[]{3};
    public int energyUse = Values.Machines.AlloySmelter.ENERGY_USE;
    public int cookSpeed = Values.Machines.AlloySmelter.COOK_SPEED;
    public int cookTime = 0;

    public TileEntityAlloySmelter() {
        maxEnergyAmount = Values.Machines.AlloySmelter.ENERGY_STORAGE;
        currentEnergyAmount = 0;
        transferRate = Values.Machines.AlloySmelter.TRANSFER_RATE;
        acceptingEnergy = true;
        inventory = new ItemStack[4];
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        currentEnergyAmount = nbtTagCompound.getInteger("currentEnergyAmount");
        cookTime = nbtTagCompound.getInteger("cookTime");

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
        nbtTagCompound.setInteger("cookTime", cookTime);

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
        return this.hasCustomInventoryName() ? this.localizedName : Names.Containers.CONTAINER_ALLOY_SMELTER;
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
        return slot != 1 ? false : (slot == 2 ? isBattery(itemStack) : true);
    }

    @Override
    public void updateEntity() {
        if (inventory[3] != null)
            transferEnergyFromItem(inventory[3], transferRate);

        boolean flag = this.isSmelting();
        boolean flag1 = false;

        if (!this.worldObj.isRemote) {
            if (this.inventory[0] != null && this.inventory[1] != null) {
                if (this.canSmelt()) {
                    this.cookTime++;
                    this.currentEnergyAmount -= energyUse;

                    if (this.cookTime == cookSpeed) {
                        this.cookTime = 0;
                        this.smeltItem();
                        flag1 = true;
                    }
                } else {
                    this.cookTime = 0;
                }
            } else {
                this.cookTime = 0;
            }

            if (flag != isSmelting()) {
                flag1 = true;
                BlockAlloySmelter.updateBlockState(this.isSmelting(), worldObj, xCoord, yCoord, zCoord);
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }

    private boolean isSmelting() {
        return this.cookTime > 0;
    }

    private boolean canSmelt() {
        if (this.inventory[0] == null || this.inventory[1] == null) {
            return false;
        } else {
            if (currentEnergyAmount < energyUse)
                return false;
            ItemStack itemstack = MachineRecipes.AlloySmelterRecipes.smelting().getSmeltingResult(this.inventory[0], this.inventory[1]);
            if (itemstack == null)
                return false;
            if (this.inventory[2] == null)
                return true;
            if (!this.inventory[2].isItemEqual(itemstack))
                return false;
            int result = inventory[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.inventory[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }

    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack itemstack = MachineRecipes.AlloySmelterRecipes.smelting().getSmeltingResult(this.inventory[0], this.inventory[1]);

            if (this.inventory[2] == null)
                this.inventory[2] = itemstack.copy();
            else if (this.inventory[2].getItem() == itemstack.getItem())
                this.inventory[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items


            int[] decreaseAmount = MachineRecipes.AlloySmelterRecipes.smelting().getDecreaseAmount(this.inventory[0], this.inventory[1]);
            this.inventory[0].stackSize -= decreaseAmount[0];
            this.inventory[1].stackSize -= decreaseAmount[1];

            if (this.inventory[0].stackSize <= 0)
                this.inventory[0] = null;
            if (this.inventory[1].stackSize <= 1)
                this.inventory[1] = null;
        }
    }

    public int getEnergyAmountScaled(int i) {
        return this.currentEnergyAmount * i / this.maxEnergyAmount;
    }

    public int getCookProgressScaled(int i) {
        return this.cookTime * i / this.cookSpeed;
    }
}
