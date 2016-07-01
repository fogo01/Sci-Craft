package com.fogo01.scicraft.client.gui.inventory;

import com.fogo01.scicraft.container.inventory.ContainerTeleporter;
import com.fogo01.scicraft.entities.ExtendedPlayer;
import com.fogo01.scicraft.reference.Reference;
import com.fogo01.scicraft.reference.Values;
import com.fogo01.scicraft.tileentity.TileEntityTeleporter;
import com.fogo01.scicraft.utility.LogHelper;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuiTeleporter extends GuiContainer {
    private TileEntityTeleporter tileEntityTeleporter;

    float mouseX,mouseY;

    public GuiTeleporter(InventoryPlayer inventoryPlayer, TileEntityTeleporter tileEntityTeleporter) {
        super(new ContainerTeleporter(inventoryPlayer, tileEntityTeleporter));
        this.tileEntityTeleporter = tileEntityTeleporter;
        xSize = 176;
        ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        String name = this.tileEntityTeleporter.hasCustomInventoryName() ? this.tileEntityTeleporter.getInventoryName() : I18n.format(this.tileEntityTeleporter.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(name, this.xSize / 2 -this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        name = I18n.format("container.inventory", new Object[0]);
        this.fontRendererObj.drawString(name, 8, this.ySize - 96 + 2, 4210752);

        if (tileEntityTeleporter.getPlayer() != null) {
            ExtendedPlayer props = ExtendedPlayer.get(tileEntityTeleporter.getPlayer());
            int[][] pos = props.getTeleporterPositions();

            for (int i = 0; i < pos[0].length; i++) {
                name = "Dim: " + pos[0][i] + ", X: " + pos[1][i] + ", Y: " + pos[2][i] + ", Z: " + pos[3][i];
                this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 17 + 9 * i, 4210752);
            }
        }
    }

    public void drawScreen(int par1, int par2, float par3) {
        this.mouseX = (float)par1;
        this.mouseY = (float)par2;
        super.drawScreen(par1, par2, par3);

        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        int boxX = 154, boxY = 16, sizeX = 12, sizeY = 42;
        if (mouseX > boxX + k && mouseX < boxX + sizeX + k){
            if (mouseY > boxY + l && mouseY < boxY + sizeY + l){
                List list = new ArrayList();
                list.add("Energy");
                list.add(this.tileEntityTeleporter.currentEnergyAmount + "/" + this.tileEntityTeleporter.maxEnergyAmount + Values.ENERGY_STORAGE);
                this.drawHoveringText(list, (int)mouseX, (int)mouseY, this.fontRendererObj);
            }
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/GuiTeleporter.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        int i = this.tileEntityTeleporter.getEnergyAmountScaled(40);
        this.drawTexturedModalRect(k + 155, l + 57 - i, 176, 40 - i, 10, i);
    }
}
