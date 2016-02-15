package com.fogo01.scicraft.client.gui.inventory;

import com.fogo01.scicraft.container.inventory.ContainerSolarPanel;
import com.fogo01.scicraft.reference.Reference;
import com.fogo01.scicraft.reference.Units;
import com.fogo01.scicraft.tileentity.TileEntitySolarPanel;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiSolarPanel extends GuiContainer {
    private TileEntitySolarPanel tileEntitySolarPanel;

    public GuiSolarPanel(InventoryPlayer inventoryPlayer, TileEntitySolarPanel tileEntitySolarPanel) {
        super(new ContainerSolarPanel(inventoryPlayer, tileEntitySolarPanel));
        this.tileEntitySolarPanel = tileEntitySolarPanel;
        xSize = 176;
        ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        String name = this.tileEntitySolarPanel.hasCustomInventoryName() ? this.tileEntitySolarPanel.getInventoryName() : I18n.format(this.tileEntitySolarPanel.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(name, this.xSize / 2 -this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        name = I18n.format("container.inventory", new Object[0]);
        this.fontRendererObj.drawString(name, 8, this.ySize - 96 + 2, 4210752);

        name = "Energy Production: " + tileEntitySolarPanel.energyProduction + Units.Energy.ENERGY_GAIN_SHORT;
        this.fontRendererObj.drawString(name, this.xSize / 2 -this.fontRendererObj.getStringWidth(name) / 2, 20, 4210752);

        name = "Energy: " + tileEntitySolarPanel.currentEnergyAmount + "/" + tileEntitySolarPanel.maxEnergyAmount + Units.Energy.ENERGY_STORAGE_SHORT;
        this.fontRendererObj.drawString(name, this.xSize / 2 -this.fontRendererObj.getStringWidth(name) / 2, 60, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/GuiSolarPanel.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        int i = this.tileEntitySolarPanel.getEnergyAmountScaled(101);
        this.drawTexturedModalRect(k + 37, l + 39, 100 - i, 166, i, 10);

        i = this.tileEntitySolarPanel.getItemEnergyAmountScaled(40);
        this.drawTexturedModalRect(k + 155, l + 57 - i, 176, 40 - i, 10, i);
    }
}
