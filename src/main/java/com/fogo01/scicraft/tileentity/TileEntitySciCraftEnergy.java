package com.fogo01.scicraft.tileentity;

import com.fogo01.scicraft.reference.Chargeables;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntitySciCraftEnergy extends TileEntitySciCraft {
    public int maxEnergyAmount;
    public int currentEnergyAmount;
    public int transferRate;
    public boolean acceptingEnergy;

    public boolean transferEnergy(TileEntitySciCraftEnergy sendingTileEntity, TileEntitySciCraftEnergy receivingTileEntity, int energyAmount) {
        if (sendingTileEntity.currentEnergyAmount < energyAmount)
            return false;
        if (receivingTileEntity.maxEnergyAmount - receivingTileEntity.currentEnergyAmount < energyAmount)
            return false;
        sendingTileEntity.currentEnergyAmount -= energyAmount;
        receivingTileEntity.currentEnergyAmount += energyAmount;
        return true;
    }

    public ForgeDirection[] getConnections() {
       ForgeDirection[] directions = new ForgeDirection[6];
        if (this.canTransferTo(worldObj, xCoord, yCoord + 1, zCoord))
            directions[0] = ForgeDirection.UP;
        else
            directions[0] = null;
        if (this.canTransferTo(worldObj, xCoord, yCoord - 1, zCoord))
            directions[1] = ForgeDirection.DOWN;
        else
            directions[1] = null;
        if (this.canTransferTo(worldObj, xCoord, yCoord, zCoord - 1))
            directions[2] = ForgeDirection.NORTH;
        else
            directions[2] = null;
        if (this.canTransferTo(worldObj, xCoord, yCoord, zCoord + 1))
            directions[3] = ForgeDirection.SOUTH;
        else
            directions[3] = null;
        if (this.canTransferTo(worldObj, xCoord + 1, yCoord, zCoord))
            directions[4] = ForgeDirection.EAST;
        else
            directions[4] = null;
        if (this.canTransferTo(worldObj, xCoord - 1, yCoord, zCoord))
            directions[5] = ForgeDirection.WEST;
        else
            directions[5] = null;
        return directions;
    }

    public boolean canTransferTo(World world, int x, int y, int z) {
        if (world.getTileEntity(xCoord, yCoord, zCoord) instanceof TileEntitySolarPanel || world.getTileEntity(xCoord, yCoord, zCoord) instanceof TileEntityBatteryCell) {
            if (world.getTileEntity(x, y, z) instanceof TileEntitySciCraftEnergy) {
                int meta = world.getBlockMetadata(xCoord, yCoord, zCoord);
                if (meta == 2 && z < zCoord) {
                    return true;
                } else if (meta == 3 && z > zCoord) {
                    return true;
                } else if (meta == 4 && x < xCoord) {
                    return true;
                } else if (meta == 5 && x > xCoord) {
                    return true;
                } else
                    return false;
            }
            return false;
        } else
            return world.getTileEntity(x, y, z) instanceof TileEntitySciCraftEnergy;
    }

    public boolean tryEnergyTransfer() {
        if (this.currentEnergyAmount == 0)
            return false;

        ForgeDirection[] connections;
        if (worldObj.getTileEntity(xCoord, yCoord, zCoord) instanceof TileEntityPipe) {
            connections = ((TileEntityPipe)worldObj.getTileEntity(xCoord, yCoord, zCoord)).connections;
        } else {
            connections = getConnections();
        }

        for (int i = 0; i < connections.length; i++) {
            if (connections[i] != null) {
                int x = 0, y = 0, z = 0;
                if (connections[i] == ForgeDirection.UP)
                    y = 1;
                else if (connections[i] == ForgeDirection.DOWN)
                    y = -1;
                else if (connections[i] == ForgeDirection.NORTH)
                    z = -1;
                else if (connections[i] == ForgeDirection.SOUTH)
                    z = 1;
                else if (connections[i] == ForgeDirection.EAST)
                    x = 1;
                else if (connections[i] == ForgeDirection.WEST)
                    x = -1;

                TileEntitySciCraftEnergy tileEntity = (TileEntitySciCraftEnergy)worldObj.getTileEntity(xCoord + x, yCoord + y, zCoord + z);
                if (!tileEntity.acceptingEnergy)
                    return false;
                int minTransferRate = Math.min(this.transferRate, tileEntity.transferRate);

                if (tileEntity.maxEnergyAmount - tileEntity.currentEnergyAmount > 0) {
                    if (this.currentEnergyAmount >= minTransferRate) {
                        if (tileEntity.maxEnergyAmount - tileEntity.currentEnergyAmount >= minTransferRate) {
                            transferEnergy(this, tileEntity, minTransferRate);
                        } else {
                            transferEnergy(this, tileEntity, tileEntity.maxEnergyAmount - tileEntity.currentEnergyAmount);
                        }
                    } else {
                        if (tileEntity.maxEnergyAmount - tileEntity.currentEnergyAmount >= this.currentEnergyAmount) {
                            transferEnergy(this, tileEntity, this.currentEnergyAmount);
                        } else {
                            transferEnergy(this, tileEntity, tileEntity.maxEnergyAmount - tileEntity.currentEnergyAmount);
                        }
                    }
                }
            }
        }
        return true;
    }

    public void transferEnergyFromItem(ItemStack itemStack, int amount) {
        TileEntitySciCraftEnergy tileEntity = (TileEntitySciCraftEnergy)worldObj.getTileEntity(xCoord, yCoord, zCoord);
        if (itemStack.getMaxDamage() - itemStack.getItemDamage() >= amount) {
            if (tileEntity.maxEnergyAmount - tileEntity.currentEnergyAmount >= amount) {
                itemStack.setItemDamage(itemStack.getItemDamage() + amount);
                tileEntity.currentEnergyAmount += amount;
            } else {
                itemStack.setItemDamage(itemStack.getItemDamage() + (tileEntity.maxEnergyAmount - tileEntity.currentEnergyAmount));
                tileEntity.currentEnergyAmount = tileEntity.maxEnergyAmount;
            }
        } else {
            if (tileEntity.maxEnergyAmount - tileEntity.currentEnergyAmount >= itemStack.getMaxDamage() - itemStack.getItemDamage()) {
                tileEntity.currentEnergyAmount += itemStack.getMaxDamage() - itemStack.getItemDamage();
                itemStack.setItemDamage(itemStack.getMaxDamage());
            } else {
                itemStack.setItemDamage(itemStack.getItemDamage() + (tileEntity.maxEnergyAmount - tileEntity.currentEnergyAmount));
                tileEntity.currentEnergyAmount = tileEntity.maxEnergyAmount;
            }
        }
    }

    public boolean isBattery(ItemStack itemStack){
        for (int i = 0; i < Chargeables.batteries.length; i++)
        if (Chargeables.batteries[i] == itemStack.getItem())
            return true;
        return false;
    }
}
