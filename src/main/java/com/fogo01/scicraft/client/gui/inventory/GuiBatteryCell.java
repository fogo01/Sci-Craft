package com.fogo01.scicraft.client.gui.inventory;

import com.fogo01.scicraft.container.inventory.ContainerBatteryCell;
import com.fogo01.scicraft.reference.Reference;
import com.fogo01.scicraft.reference.Values;
import com.fogo01.scicraft.tileentity.TileEntityBatteryCell;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiBatteryCell extends GuiContainer {
    private TileEntityBatteryCell tileEntityBatteryCell;

    public GuiBatteryCell(InventoryPlayer inventoryPlayer, TileEntityBatteryCell tileEntityBatteryCell) {
        super(new ContainerBatteryCell(inventoryPlayer, tileEntityBatteryCell));
        this.tileEntityBatteryCell = tileEntityBatteryCell;
        xSize = 176;
        ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        String name = this.tileEntityBatteryCell.hasCustomInventoryName() ? this.tileEntityBatteryCell.getInventoryName() : I18n.format(this.tileEntityBatteryCell.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(name, this.xSize / 2 -this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        name = I18n.format("container.inventory", new Object[0]);
        this.fontRendererObj.drawString(name, this.xSize / 2 -this.fontRendererObj.getStringWidth(name) / 2, this.ySize - 96 + 2, 4210752);

        name = "Energy: " + tileEntityBatteryCell.currentEnergyAmount + "/" + tileEntityBatteryCell.maxEnergyAmount + Values.ENERGY_STORAGE;
        this.fontRendererObj.drawString(name, this.xSize / 2 -this.fontRendererObj.getStringWidth(name) / 2, 60, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/GuiBatteryCell.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        int i = this.tileEntityBatteryCell.getEnergyAmountScaled(101);
        this.drawTexturedModalRect(k + 37, l + 39, 100 - i, 166, i, 10);

        i = this.tileEntityBatteryCell.getItemEnergyAmount1Scaled(40);
        this.drawTexturedModalRect(k + 11, l + 57 - i, 176, 40 - i, 10, i);

        i = this.tileEntityBatteryCell.getItemEnergyAmount2Scaled(40);
        this.drawTexturedModalRect(k + 155, l + 57 - i, 176, 40 - i, 10, i);
    }
}
