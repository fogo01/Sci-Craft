package com.fogo01.scicraft.render.items;

import com.fogo01.scicraft.models.ModelLaserRifle;
import com.fogo01.scicraft.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderLaserRifle implements IItemRenderer {
    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":textures/models/items/LaserRifle.png");
    private ModelLaserRifle model;

    public RenderLaserRifle() {
        model = new ModelLaserRifle();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch (type) {
            case EQUIPPED:
                return true;
            case EQUIPPED_FIRST_PERSON:
                return true;
            case ENTITY:
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type) {
            case EQUIPPED:
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);

                GL11.glRotatef(10F, 1F, 0F, 0F);
                GL11.glRotatef(195F, 0F, 1F, 0F);
                GL11.glRotatef(167F, 0F, 0F, 1F);

                GL11.glTranslatef(0.4F, 0.2F, -0.2F);

                //GL11.glRotatef(95F, 1F, 0F, 0F);
                //GL11.glRotatef(-55F, 0F, 1F, 0F);
                //GL11.glRotatef(-85F, 0F, 0F, 1F);

                //GL11.glTranslatef(0.05F, 0.2F, -0.7F);

                float scale = 1.8F;
                GL11.glScalef(scale, scale, scale);

                model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

                GL11.glPopMatrix();
                break;
            case EQUIPPED_FIRST_PERSON:
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);

                GL11.glRotatef(95F, 1F, 0F, 0F);
                GL11.glRotatef(-55F, 0F, 1F, 0F);
                GL11.glRotatef(-85F, 0F, 0F, 1F);

                GL11.glTranslatef(0.2F, 0.4F, -0.7F);

                scale = 1.5F;
                GL11.glScalef(scale, scale, scale);

                model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

                GL11.glPopMatrix();
                break;
            case ENTITY:
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);

                GL11.glRotatef(180, 1F, 0F, 0F);

                GL11.glRotatef(-((Entity)data[1]).worldObj.getWorldTime(), 0F, 0.25F, 0F);

                scale = 1.5F;
                GL11.glScalef(scale, scale, scale);

                model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

                GL11.glPopMatrix();
                break;
            default:
                break;
        }
    }
}
