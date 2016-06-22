package com.fogo01.scicraft.tileentity;

import com.fogo01.scicraft.init.ModItems;
import com.fogo01.scicraft.items.ItemRocket;
import com.fogo01.scicraft.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityRocketFactory extends TileEntitySciCraft implements ISidedInventory {
    public int noseCone = 0;
    public int fuselage = 0;
    public int engine = 0;
    public int fin = 0;
    public int booster = 0;

    public TileEntityRocketFactory() {
        inventory = new ItemStack[6];
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

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
        return this.hasCustomInventoryName() ? this.localizedName : Names.Containers.CONTAINER_ROCKET_FACTORY;
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
        return true;
    }

    @Override
    public void updateEntity() {
        noseCone = 0;
        if (inventory[0] != null && inventory[0].getItem() == ModItems.ROCKET_PART) {
            if (inventory[0].getItemDamage() == 0)
                noseCone = 1;
            else if (inventory[0].getItemDamage() == 1)
                noseCone = 2;
            else if (inventory[0].getItemDamage() == 2)
                noseCone = 3;
        }
        fuselage = 0;
        if (inventory[1] != null && inventory[1].getItem() == ModItems.ROCKET_PART) {
            if (inventory[1].getItemDamage() == 3)
                fuselage = 1;
            else if (inventory[1].getItemDamage() == 4)
                fuselage = 2;
            else if (inventory[1].getItemDamage() == 5)
                fuselage = 3;
        }
        engine = 0;
        if (inventory[2] != null && inventory[2].getItem() == ModItems.ROCKET_PART) {
            if (inventory[2].getItemDamage() == 6)
                engine = 1;
            else if (inventory[2].getItemDamage() == 7)
                engine = 2;
            else if (inventory[2].getItemDamage() == 8)
                engine = 3;
        }
        booster = 0;
        if (inventory[4] != null && inventory[4].getItem() == ModItems.ROCKET_PART) {
            if (inventory[4].getItemDamage() == 9)
                booster = 1;
            else if (inventory[4].getItemDamage() == 10)
                booster = 2;
            else if (inventory[4].getItemDamage() == 11)
                booster = 3;
        }
        fin = 0;
        if (inventory[3] != null && inventory[3].getItem() == ModItems.ROCKET_PART) {
            if (inventory[3].getItemDamage() == 12)
                fin = 1;
            else if (inventory[3].getItemDamage() == 13)
                fin = 2;
            else if (inventory[3].getItemDamage() == 14)
                fin = 3;
        }

        if (inventory[0] != null && inventory[0].getItem() == ModItems.ROCKET_PART && inventory[0].getItemDamage() >= 0 && inventory[0].getItemDamage() <= 2 && inventory[1] != null && inventory[1].getItem() == ModItems.ROCKET_PART && inventory[1].getItemDamage() >= 3 && inventory[1].getItemDamage() <= 5 && inventory[2] != null && inventory[2].getItem() == ModItems.ROCKET_PART && inventory[2].getItemDamage() >= 6 && inventory[2].getItemDamage() <= 8 && inventory[3] != null && inventory[3].getItem() == ModItems.ROCKET_PART && inventory[3].getItemDamage() >= 12 && inventory[3].getItemDamage() <= 14 && inventory[4] != null && inventory[4].getItem() == ModItems.ROCKET_PART && inventory[4].getItemDamage() >= 9 && inventory[4].getItemDamage() <= 11) {
            inventory[5] = new ItemStack(ModItems.ROCKET);
            ((ItemRocket) inventory[5].getItem()).setRocketParts(inventory[5], noseCone, fuselage, engine, fin, booster);
        } else {
            inventory[5] = null;
        }
    }
}
