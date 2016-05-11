package com.fogo01.scicraft.tileentity;

import com.fogo01.scicraft.blocks.containers.BlockCrusher;
import com.fogo01.scicraft.blocks.containers.BlockRefinery;
import com.fogo01.scicraft.crafting.MachineRecipes;
import com.fogo01.scicraft.init.ModFluids;
import com.fogo01.scicraft.init.ModItems;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Values;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fluids.Fluid;

public class TileEntityRefinery extends TileEntitySciCraftEnergy implements ISidedInventory {
    private static final int[] slotsTop = new int[]{0, 1, 2};
    private static final int[] slotsBottom = new int[]{0, 1, 2, 3};
    private static final int[] slotsSides = new int[]{3};
    public int energyUse = Values.Machines.Refinery.ENERGY_USE;
    public int refiningSpeed = Values.Machines.Refinery.REFINING_SPEED;
    public int refiningTime = 0;

    private int proportions = Values.Machines.Refinery.OIL_PER_FUEL_PROPORTIONS;
    private int count = Values.Machines.Refinery.FUEL_PER_CYCLE;

    public int maxOilAmount = Values.Machines.Refinery.MAX_OIL_AMOUNT;
    public int maxFuelAmount = Values.Machines.Refinery.MAX_FUEL_AMOUNT;
    public int currentOilAmount = 0;
    public int currentFuelAmount = 0;

    public TileEntityRefinery() {
        maxEnergyAmount = Values.Machines.Refinery.ENERGY_STORAGE;
        currentEnergyAmount = 0;
        transferRate = Values.Machines.Refinery.TRANSFER_RATE;
        acceptingEnergy = true;
        inventory = new ItemStack[4];
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        currentEnergyAmount = nbtTagCompound.getInteger("currentEnergyAmount");
        currentOilAmount = nbtTagCompound.getInteger("currentOilAmount");
        currentFuelAmount = nbtTagCompound.getInteger("currentFuelAmount");

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
        nbtTagCompound.setInteger("currentOilAmount", currentOilAmount);
        nbtTagCompound.setInteger("currentFuelAmount", currentFuelAmount);

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
        if (itemStack == null)
            return false;
        if (slot == 0)
            return itemStack.getItem() == ModItems.OIL_BUCKET;
        else if (slot == 1)
            return itemStack.getItem() == ModItems.FUEL_BUCKET;
        else if (slot == 2)
            return itemStack.getItem() == Items.bucket;
        else if (slot == 3)
            return isBattery(itemStack);
        else
            return false;
    }

    public void moveLiquid(Fluid fluid, EntityPlayer player) {
        if (fluid == ModFluids.OIL) {
            if (maxOilAmount - currentOilAmount >= 1000 && player.getHeldItem().getItem() == ModItems.OIL_BUCKET) {
                player.inventory.consumeInventoryItem(ModItems.OIL_BUCKET);
                player.inventory.addItemStackToInventory(new ItemStack(Items.bucket));
                currentOilAmount += 1000;
            }
        } else if (fluid == ModFluids.FUEL) {
            if (currentFuelAmount >= 1000 && player.getHeldItem().getItem() == Items.bucket) {
                player.inventory.consumeInventoryItem(Items.bucket);
                player.inventory.addItemStackToInventory(new ItemStack(ModItems.FUEL_BUCKET));
                currentFuelAmount -= 1000;
            }
        }
    }

    @Override
    public void updateEntity() {
        if (inventory[3] != null)
            transferEnergyFromItem(inventory[3], transferRate);

        boolean flag = this.isRefining();
        boolean flag1 = false;

        if (!this.worldObj.isRemote) {
            if (inventory[0] != null && inventory[0].getItem() == ModItems.OIL_BUCKET && (inventory[2] == null || inventory[2].getItem() == Items.bucket)) {
                if (maxOilAmount - currentOilAmount >= 1000) {
                    if (inventory[2] == null || inventory[2].stackSize < inventory[2].getMaxStackSize())
                    if (inventory[2] == null)
                        inventory[2] = new ItemStack(Items.bucket);
                    else
                        inventory[2].stackSize++;

                    inventory[0].stackSize--;
                    currentOilAmount += 1000;

                    if (inventory[0].stackSize <= 0)
                        inventory[0] = null;
                }
                flag1 = true;
            }

            if (currentFuelAmount >= 1000) {
                if (inventory[2] != null && inventory[2].getItem() == Items.bucket && inventory[1] == null) {
                    inventory[1] = new ItemStack(ModItems.FUEL_BUCKET);
                    currentFuelAmount -= 1000;

                    inventory[2].stackSize--;

                    if (inventory[2].stackSize <= 0)
                        inventory[2] = null;
                    flag1 = true;
                }
            }


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
                BlockRefinery.updateBlockState(this.isRefining(), worldObj, xCoord, yCoord, zCoord);
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
        if (this.currentOilAmount < proportions * count) {
            return false;
        } else {
            if (currentEnergyAmount < energyUse)
                return false;
            if (currentFuelAmount + count >= maxFuelAmount)
                return false;
            return true;
        }
    }


    public void refine() {
        if (this.canRefine()) {
            currentOilAmount -= proportions * count;
            currentFuelAmount += count;
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
