package com.fogo01.scicraft.client.gui.inventory;

import com.fogo01.scicraft.container.inventory.ContainerRefinery;
import com.fogo01.scicraft.reference.Reference;
import com.fogo01.scicraft.tileentity.TileEntityRefinery;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class GuiRefinery extends GuiContainer {
    private TileEntityRefinery tileEntityRefinery;

    float mouseX,mouseY;

    public GuiRefinery(InventoryPlayer inventoryPlayer, TileEntityRefinery tileEntityRefinery) {
        super(new ContainerRefinery(inventoryPlayer, tileEntityRefinery));
        this.tileEntityRefinery = tileEntityRefinery;
        xSize = 176;
        ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        String name = this.tileEntityRefinery.hasCustomInventoryName() ? this.tileEntityRefinery.getInventoryName() : I18n.format(this.tileEntityRefinery.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(name, this.xSize / 2 -this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        name = I18n.format("container.inventory", new Object[0]);
        this.fontRendererObj.drawString(name, 27, this.ySize - 96 + 2, 4210752);
    }

    public void drawScreen(int par1, int par2, float par3) {
        this.mouseX = (float)par1;
        this.mouseY = (float)par2;
        super.drawScreen(par1, par2, par3);

        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        int boxX = 10, boxY = 16, sizeX = 12, sizeY = 42;
        if (mouseX > boxX + k && mouseX < boxX + sizeX + k){
            if (mouseY > boxY + l && mouseY < boxY + sizeY + l){
                List list = new ArrayList();
                list.add("Oil");
                list.add(this.tileEntityRefinery.currentOilAmount + "/" + this.tileEntityRefinery.maxOilAmount + "mb");
                this.drawHoveringText(list, (int)mouseX, (int)mouseY, this.fontRendererObj);
            }
        }
        boxX = 154; boxY = 16; sizeX = 12; sizeY = 42;
        if (mouseX > boxX + k && mouseX < boxX + sizeX + k){
            if (mouseY > boxY + l && mouseY < boxY + sizeY + l){
                List list = new ArrayList();
                list.add("Fuel");
                list.add(this.tileEntityRefinery.currentFuelAmount + "/" + this.tileEntityRefinery.maxFuelAmount + "mb");
                this.drawHoveringText(list, (int)mouseX, (int)mouseY, this.fontRendererObj);
            }
        }
        boxX = 59; boxY = 46; sizeX = 80; sizeY = 12;
        if (mouseX > boxX + k && mouseX < boxX + sizeX + k){
            if (mouseY > boxY + l && mouseY < boxY + sizeY + l){
                List list = new ArrayList();
                list.add("Energy");
                list.add(this.tileEntityRefinery.currentEnergyAmount + "/" + this.tileEntityRefinery.maxEnergyAmount + "mb");
                this.drawHoveringText(list, (int)mouseX, (int)mouseY, this.fontRendererObj);
            }
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/GuiRefinery.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        int i = this.tileEntityRefinery.getEnergyAmountScaled(78);
        this.drawTexturedModalRect(k + 60, l + 47, 78 - i, 166, i, 10);

        i = this.tileEntityRefinery.getOilAmountScaled(40);
        this.drawTexturedModalRect(k + 11, l + 57 - i, 176, 40 - i, 10, i);

        i = this.tileEntityRefinery.getFuelAmountScaled(40);
        this.drawTexturedModalRect(k + 155, l + 57 - i, 186, 40 - i, 10, i);

        i = this.tileEntityRefinery.getRefiningProgressScaled(80);
        this.drawTexturedModalRect(k + 48, l + 16, 176, 40, i, 27);
    }
}