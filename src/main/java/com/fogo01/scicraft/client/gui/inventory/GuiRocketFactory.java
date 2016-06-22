package com.fogo01.scicraft.client.gui.inventory;

import com.fogo01.scicraft.container.inventory.ContainerRocketFactory;
import com.fogo01.scicraft.reference.Reference;
import com.fogo01.scicraft.tileentity.TileEntityRocketFactory;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiRocketFactory extends GuiContainer {
    private TileEntityRocketFactory tileEntityRocketFactory;

    public GuiRocketFactory(InventoryPlayer inventoryPlayer, TileEntityRocketFactory tileEntityRocketFactory) {
        super(new ContainerRocketFactory(inventoryPlayer, tileEntityRocketFactory));
        this.tileEntityRocketFactory = tileEntityRocketFactory;
        xSize = 176;
        ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        String name = this.tileEntityRocketFactory.hasCustomInventoryName() ? this.tileEntityRocketFactory.getInventoryName() : I18n.format(this.tileEntityRocketFactory.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(name, this.xSize / 2 -this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        name = I18n.format("container.inventory", new Object[0]);
        this.fontRendererObj.drawString(name, 8, this.ySize - 96 + 2, 4210752);

        name = "T" + this.tileEntityRocketFactory.noseCone;
        this.fontRendererObj.drawString(name, 150, 20, 4210752);
        name = "T" + this.tileEntityRocketFactory.fuselage;
        this.fontRendererObj.drawString(name, 150, 28, 4210752);
        name = "T" + this.tileEntityRocketFactory.engine;
        this.fontRendererObj.drawString(name, 150, 36, 4210752);
        name = "T" + this.tileEntityRocketFactory.fin;
        this.fontRendererObj.drawString(name, 150, 44, 4210752);
        name = "T" + this.tileEntityRocketFactory.booster;
        this.fontRendererObj.drawString(name, 150, 52, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/GuiRocketFactory.png"));
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}
