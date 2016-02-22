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

public class TileEntityCrusher extends TileEntitySciCraftEnergy implements ISidedInventory {
    private static final int[] slotsTop = new int[]{0};
    private static final int[] slotsBottom = new int[]{1};
    private static final int[] slotsSides = new int[]{2};
    public int energyUse = Values.Machines.Crusher.ENERGY_USE;
    public int crushSpeed = Values.Machines.Crusher.CRUSH_SPEED;
    public int crushTime = 0;

    public TileEntityCrusher() {
        maxEnergyAmount = Values.Machines.Crusher.ENERGY_STORAGE;
        currentEnergyAmount = 0;
        transferRate = Values.Machines.Crusher.TRANSFER_RATE;
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
        return this.hasCustomInventoryName() ? this.localizedName : Names.Containers.CONTAINER_CRUSHER;
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

        boolean flag = this.isCrushing();
        boolean flag1 = false;

        if (!this.worldObj.isRemote) {
            if (this.inventory[0] != null) {
                if (this.canCrush()) {
                    this.crushTime++;
                    this.currentEnergyAmount -= energyUse;

                    if (this.crushTime == crushSpeed) {
                        this.crushTime = 0;
                        this.crushItem();
                        flag1 = true;
                    }
                } else {
                    this.crushTime = 0;
                }
            }

            if (flag != isCrushing()) {
                flag1 = true;
                BlockCrusher.updateBlockState(this.isCrushing(), worldObj, xCoord, yCoord, zCoord);
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }

    private boolean isCrushing() {
        return this.crushTime > 0;
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canCrush() {
        if (this.inventory[0] == null) {
            return false;
        } else {
            if (currentEnergyAmount < energyUse)
                return false;
            ItemStack itemstack = MachineRecipes.CrusherRecipes.crushing().getCrushingResult(this.inventory[0]);
            if (itemstack == null)
                return false;
            if (this.inventory[1] == null)
                return true;
            if (!this.inventory[1].isItemEqual(itemstack))
                return false;
            int result = inventory[1].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.inventory[1].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void crushItem() {
        if (this.canCrush()) {
            ItemStack itemstack = MachineRecipes.CrusherRecipes.crushing().getCrushingResult(this.inventory[0]);

            if (this.inventory[1] == null) {
                this.inventory[1] = itemstack.copy();
            } else if (this.inventory[1].getItem() == itemstack.getItem()) {
                this.inventory[1].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.inventory[0].stackSize;

            if (this.inventory[0].stackSize <= 0) {
                this.inventory[0] = null;
            }
        }
    }

    public int getEnergyAmountScaled(int i) {
        return this.currentEnergyAmount * i / this.maxEnergyAmount;
    }

    public int getCrushProgressScaled(int i) {
        return this.crushTime * i / crushSpeed;
    }
}
