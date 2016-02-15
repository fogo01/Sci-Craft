package com.fogo01.scicraft.tileentity;

import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityPipe extends TileEntitySciCraftEnergy {
    public ForgeDirection[] connections = new ForgeDirection[6];

    /**
     * UP, DOWN, NORTH, SOUTH, EAST, WEST
     */

    public TileEntityPipe() {

    }

    @Override
    public void updateEntity() {
        this.updateConnections();
    }

    public void updateConnections() {
        if (this.canConnectTo(worldObj, xCoord, yCoord + 1, zCoord))
            connections[0] = ForgeDirection.UP;
        else
            connections[0] = null;
        if (this.canConnectTo(worldObj, xCoord, yCoord - 1, zCoord))
            connections[1] = ForgeDirection.DOWN;
        else
            connections[1] = null;
        if (this.canConnectTo(worldObj, xCoord, yCoord, zCoord - 1))
            connections[2] = ForgeDirection.NORTH;
        else
            connections[2] = null;
        if (this.canConnectTo(worldObj, xCoord, yCoord, zCoord + 1))
            connections[3] = ForgeDirection.SOUTH;
        else
            connections[3] = null;
        if (this.canConnectTo(worldObj, xCoord + 1, yCoord, zCoord))
            connections[4] = ForgeDirection.EAST;
        else
            connections[4] = null;
        if (this.canConnectTo(worldObj, xCoord - 1, yCoord, zCoord))
            connections[5] = ForgeDirection.WEST;
        else
            connections[5] = null;
    }

    public boolean canConnectTo(World world, int x, int y, int z) {
        if (world.getTileEntity(x, y, z) instanceof TileEntitySolarPanel) {
            int meta = world.getBlockMetadata(x, y, z);
            if (meta == 2 && z > zCoord) {
                return true;
            } else if (meta == 3 && z < zCoord) {
                return true;
            } else if (meta == 4 && x > xCoord) {
                return true;
            } else if (meta == 5 && x < xCoord) {
                return true;
            } else
                return false;
        } else
            return world.getTileEntity(x, y, z) instanceof TileEntityPipe || world.getTileEntity(x, y, z) instanceof TileEntityBatteryCell;
    }

    public boolean onlyOneOpposite(ForgeDirection[] directions) {
        ForgeDirection mainDirection = null;
        boolean isOpposite = false;
        for (int i = 0; i < directions.length; i++) {
            if (mainDirection == null && directions[i] != null)
                mainDirection = directions[i];
            if (directions[i] != null && mainDirection != directions[i]) {
                if (!isOpposite(mainDirection, directions[i]))
                    return false;
                else
                    isOpposite = true;
            }
        }

        return isOpposite;
    }

    public boolean isOpposite(ForgeDirection firstDirection, ForgeDirection secondDirection) {
        if ((firstDirection == ForgeDirection.UP && secondDirection == ForgeDirection.DOWN) || (firstDirection == ForgeDirection.DOWN && secondDirection == ForgeDirection.UP))
            return true;
        if ((firstDirection == ForgeDirection.NORTH && secondDirection == ForgeDirection.SOUTH) || (firstDirection == ForgeDirection.SOUTH && secondDirection == ForgeDirection.NORTH))
            return true;
        if ((firstDirection == ForgeDirection.EAST && secondDirection == ForgeDirection.WEST) || (firstDirection == ForgeDirection.WEST && secondDirection == ForgeDirection.EAST))
            return true;
        return false;
    }
}
