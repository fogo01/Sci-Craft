package com.fogo01.scicraft.tileentity;

import com.fogo01.scicraft.blocks.containers.BlockTeleporter;
import com.fogo01.scicraft.reference.Chargeables;
import com.fogo01.scicraft.reference.Dimensions;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Values;
import com.fogo01.scicraft.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;

import java.util.List;
import java.util.UUID;

public class TileEntityTeleporter extends TileEntitySciCraftEnergy implements ISidedInventory {
    private static final int[] slotsTop = new int[]{0};
    private static final int[] slotsBottom = new int[]{0};
    private static final int[] slotsSides = new int[]{0};

    private EntityPlayer player;

    private int timeOn;

    public TileEntityTeleporter() {
        maxEnergyAmount = Values.Machines.Teleporter.ENERGY_STORAGE;
        currentEnergyAmount = 0;
        transferRate = Values.Machines.Teleporter.TRANSFER_RATE;
        acceptingEnergy = true;
        inventory = new ItemStack[1];
        timeOn = 0;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        currentEnergyAmount = nbtTagCompound.getInteger("currentEnergyAmount");
        player = worldObj.func_152378_a(UUID.fromString(nbtTagCompound.getString("Player")));

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
        nbtTagCompound.setString("Player", player.getUniqueID().toString());

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
        return this.hasCustomInventoryName() ? this.localizedName : Names.Containers.CONTAINER_TELEPORTER;
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
        if (inventory[0] != null)
            transferEnergyFromItem(inventory[0], transferRate);

        if (player == null) {
            Block block = worldObj.getBlock(xCoord, yCoord, zCoord);
            if (block instanceof BlockTeleporter) {
                BlockTeleporter teleporter = (BlockTeleporter) block;
                if (teleporter.player != null)
                    player = teleporter.player;
            }
        }

        AxisAlignedBB AABB = AxisAlignedBB.getBoundingBox(xCoord, yCoord + 1, zCoord, xCoord + 1, yCoord + 2, zCoord + 1);
        List players = worldObj.getEntitiesWithinAABB(EntityPlayer.class, AABB);
        if (players.size() > 0) {
            worldObj.spawnParticle("reddust", xCoord + Math.random(), yCoord + 1 + Math.random() * 2, zCoord + Math.random(), 0D, 0D,0D);
            worldObj.spawnParticle("reddust", xCoord + Math.random(), yCoord + 1 + Math.random() * 2, zCoord + Math.random(), 0D, 0D,0D);
            worldObj.spawnParticle("reddust", xCoord + Math.random(), yCoord + 1 + Math.random() * 2, zCoord + Math.random(), 0D, 0D,0D);
            worldObj.spawnParticle("reddust", xCoord + Math.random(), yCoord + 1 + Math.random() * 2, zCoord + Math.random(), 0D, 0D,0D);

            if (timeOn == 0) {
                for (int i = 0; i < players.size(); i++) {
                    ((EntityPlayer)players.get(i)).addChatMessage(new ChatComponentText("Teleporting in: 3, please stand still"));
                }
            } else if (timeOn == 20) {
                for (int i = 0; i < players.size(); i++) {
                    ((EntityPlayer)players.get(i)).addChatMessage(new ChatComponentText("Teleporting in: 2"));
                }
            } else if (timeOn == 40) {
                for (int i = 0; i < players.size(); i++) {
                    ((EntityPlayer)players.get(i)).addChatMessage(new ChatComponentText("Teleporting in: 1"));
                }
            } else if (timeOn == 60) {
                for (int i = 0; i < players.size(); i++) {
                    ((EntityPlayer)players.get(i)).addChatMessage(new ChatComponentText("*poof*"));

                    if (players.get(i) instanceof EntityPlayerMP)
                        ((EntityPlayerMP)players.get(i)).mcServer.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)players.get(i), Dimensions.IDs.DIMENSION_ID_MOON);
                }

                for (int i = 0; i < 250; i++)
                    worldObj.spawnParticle("smoke", xCoord + Math.random(), yCoord + 1 + Math.random() * 2, zCoord + Math.random(), (Math.random() - 0.5) / 10, (Math.random() - 0.5) / 10, (Math.random() - 0.5) / 10);
            }

            timeOn++;
        } else {
            timeOn = 0;
        }
    }

    public EntityPlayer getPlayer() {
        return player;
    }

    public int getEnergyAmountScaled(int i) {
        return this.currentEnergyAmount * i / this.maxEnergyAmount;
    }
}
