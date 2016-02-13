package com.fogo01.scicraft.handler;

import com.fogo01.scicraft.client.gui.inventory.GuiSolarPanel;
import com.fogo01.scicraft.container.inventory.ContainerSolarPanel;
import com.fogo01.scicraft.reference.GUIs;
import com.fogo01.scicraft.tileentity.TileEntitySolarPanel;
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
            }
        }
        return null;
    }
}
