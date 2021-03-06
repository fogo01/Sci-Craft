package com.fogo01.scicraft.client.gui.inventory;

import com.fogo01.scicraft.container.inventory.ContainerCrusher;
import com.fogo01.scicraft.reference.Reference;
import com.fogo01.scicraft.tileentity.TileEntityCrusher;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiCrusher extends GuiContainer {
    private TileEntityCrusher tileEntityCrusher;

    public GuiCrusher(InventoryPlayer inventoryPlayer, TileEntityCrusher tileEntityCrusher) {
        super(new ContainerCrusher(inventoryPlayer, tileEntityCrusher));
        this.tileEntityCrusher = tileEntityCrusher;
        xSize = 176;
        ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        String name = this.tileEntityCrusher.hasCustomInventoryName() ? this.tileEntityCrusher.getInventoryName() : I18n.format(this.tileEntityCrusher.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(name, this.xSize / 2 -this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        name = I18n.format("container.inventory", new Object[0]);
        this.fontRendererObj.drawString(name, 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/GuiCrusher.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        int i = this.tileEntityCrusher.getEnergyAmountScaled(40);
        this.drawTexturedModalRect(k + 155, l + 57 - i, 176, 40 - i, 10, i);

        i = this.tileEntityCrusher.getCrushProgressScaled(24);
        this.drawTexturedModalRect(k + 79, l + 35, 186, 1, i + 1, 16);
    }
}
