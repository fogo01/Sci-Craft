package com.fogo01.scicraft.handler;

import com.fogo01.scicraft.client.gui.inventory.*;
import com.fogo01.scicraft.container.inventory.*;
import com.fogo01.scicraft.reference.GUIs;
import com.fogo01.scicraft.tileentity.*;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y ,z);

        if (entity != null) {
            if (ID == GUIs.SOLAR_PANEL.ordinal()) {
                TileEntitySolarPanel tileEntitySolarPanel = (TileEntitySolarPanel) world.getTileEntity(x, y, z);
                return new ContainerSolarPanel(player.inventory, tileEntitySolarPanel);
            } else if (ID == GUIs.BATTERY_CELL.ordinal()) {
                TileEntityBatteryCell tileEntityBatteryCell = (TileEntityBatteryCell) world.getTileEntity(x, y, z);
                return new ContainerBatteryCell(player.inventory, tileEntityBatteryCell);
            } else if (ID == GUIs.POWERED_FURNACE.ordinal()) {
                TileEntityPoweredFurnace tileEntityPoweredFurnace = (TileEntityPoweredFurnace) world.getTileEntity(x, y, z);
                return new ContainerPoweredFurnace(player.inventory, tileEntityPoweredFurnace);
            } else if (ID == GUIs.CRUSHER.ordinal()) {
                TileEntityCrusher tileEntityCrusher = (TileEntityCrusher) world.getTileEntity(x, y, z);
                return new ContainerCrusher(player.inventory, tileEntityCrusher);
            } else if (ID == GUIs.ALLOY_SMELTER.ordinal()) {
                TileEntityAlloySmelter tileEntityAlloySmelter = (TileEntityAlloySmelter) world.getTileEntity(x, y, z);
                return new ContainerAlloySmelter(player.inventory, tileEntityAlloySmelter);
            } else if (ID == GUIs.CENTRIFUGE.ordinal()) {
                TileEntityCentrifuge tileEntityCentrifuge = (TileEntityCentrifuge) world.getTileEntity(x, y, z);
                return new ContainerCentrifuge(player.inventory, tileEntityCentrifuge);
            } else if (ID == GUIs.REFINERY.ordinal()) {
                TileEntityRefinery tileEntityRefinery = (TileEntityRefinery) world.getTileEntity(x, y, z);
                return new ContainerRefinery(player.inventory, tileEntityRefinery);
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y ,z);

        if (entity != null) {
            if (ID == GUIs.SOLAR_PANEL.ordinal()) {
                TileEntitySolarPanel tileEntitySolarPanel = (TileEntitySolarPanel) world.getTileEntity(x, y, z);
                return new GuiSolarPanel(player.inventory, tileEntitySolarPanel);
            } else if (ID == GUIs.BATTERY_CELL.ordinal()) {
                TileEntityBatteryCell tileEntityBatteryCell = (TileEntityBatteryCell) world.getTileEntity(x, y, z);
                return new GuiBatteryCell(player.inventory, tileEntityBatteryCell);
            } else if (ID == GUIs.POWERED_FURNACE.ordinal()) {
                TileEntityPoweredFurnace tileEntityPoweredFurnace = (TileEntityPoweredFurnace) world.getTileEntity(x, y, z);
                return new GuiPoweredFurnace(player.inventory, tileEntityPoweredFurnace);
            } else if (ID == GUIs.CRUSHER.ordinal()) {
                TileEntityCrusher tileEntityCrusher = (TileEntityCrusher) world.getTileEntity(x, y, z);
                return new GuiCrusher(player.inventory, tileEntityCrusher);
            } else if (ID == GUIs.ALLOY_SMELTER.ordinal()) {
                TileEntityAlloySmelter tileEntityAlloySmelter = (TileEntityAlloySmelter) world.getTileEntity(x, y, z);
                return new GuiAlloySmelter(player.inventory, tileEntityAlloySmelter);
            } else if (ID == GUIs.CENTRIFUGE.ordinal()) {
                TileEntityCentrifuge tileEntityCentrifuge = (TileEntityCentrifuge) world.getTileEntity(x, y, z);
                return new GuiCentrifuge(player.inventory, tileEntityCentrifuge);
            } else if (ID == GUIs.REFINERY.ordinal()) {
                TileEntityRefinery tileEntityRefinery = (TileEntityRefinery) world.getTileEntity(x, y, z);
                return new GuiRefinery(player.inventory, tileEntityRefinery);
            }
        }
        return null;
    }
}
