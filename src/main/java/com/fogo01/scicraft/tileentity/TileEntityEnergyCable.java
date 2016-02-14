package com.fogo01.scicraft.tileentity;

import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityEnergyCable extends TileEntityPipe {
    public TileEntityEnergyCable() {
        maxEnergyAmount = 1600;
        currentEnergyAmount = 0;
        transferRate = 800;
        acceptingEnergy = true;
    }

    @Override
    public void updateEntity() {
        this.updateConnections();

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
                if (worldObj.getTileEntity(xCoord + x, yCoord + y, zCoord + z) instanceof TileEntitySciCraftEnergy) {
                    TileEntitySciCraftEnergy tileEntity = (TileEntitySciCraftEnergy)worldObj.getTileEntity(xCoord + x, yCoord + y, zCoord + z);
                    int localTransfer = Math.min(this.transferRate, tileEntity.transferRate);

                    if (this.currentEnergyAmount < this.maxEnergyAmount) {
                        if (tileEntity.currentEnergyAmount > this.currentEnergyAmount && this.acceptingEnergy) {
                            if (this.currentEnergyAmount + localTransfer <= this.maxEnergyAmount){
                                if(tileEntity.currentEnergyAmount >= localTransfer) {
                                    this.currentEnergyAmount += localTransfer;
                                    tileEntity.currentEnergyAmount -= localTransfer;
                                } else {
                                    this.currentEnergyAmount += tileEntity.currentEnergyAmount;
                                    tileEntity.currentEnergyAmount = 0;
                                }
                            } else {
                                if (tileEntity.currentEnergyAmount >= this.maxEnergyAmount - this.currentEnergyAmount) {
                                    tileEntity.currentEnergyAmount -= (this.maxEnergyAmount - this.currentEnergyAmount);
                                    this.currentEnergyAmount = this.maxEnergyAmount;
                                } else {
                                    this.currentEnergyAmount += tileEntity.currentEnergyAmount;
                                    tileEntity.currentEnergyAmount = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
