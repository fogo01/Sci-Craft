package com.fogo01.scicraft.tileentity;

import net.minecraft.inventory.ISidedInventory;

public class TileEntitySciCraftEnergy extends TileEntitySciCraft implements ISidedInventory {
    public int maxEnergyAmount;
    public int currentEnergyAmount;
    public int transferRate;
}
