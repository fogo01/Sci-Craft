package com.fogo01.scicraft.render.items;

import com.fogo01.scicraft.models.ModelPlasmaLauncher;
import com.fogo01.scicraft.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderPlasmaLauncher implements IItemRenderer {

    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":textures/models/items/PlasmaLauncher.png");
    private ModelPlasmaLauncher model;

    public RenderPlasmaLauncher() {
        model = new ModelPlasmaLauncher();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch (type) {
            case EQUIPPED:
                return true;
            case EQUIPPED_FIRST_PERSON:
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

                //GL11.glRotatef(10F, 1F, 0F, 0F);
                //GL11.glRotatef(195F, 0F, 1F, 0F);
                //GL11.glRotatef(167F, 0F, 0F, 1F);

                //GL11.glTranslatef(0.4F, 0.2F, 0F);

                GL11.glRotatef(95F, 1F, 0F, 0F);
                GL11.glRotatef(-55F, 0F, 1F, 0F);
                GL11.glRotatef(-85F, 0F, 0F, 1F);

                GL11.glTranslatef(0.05F, 0.2F, -0.7F);

                float scale = 1.8F;
                GL11.glScalef(scale, scale, scale);

                model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

                GL11.glPopMatrix();
                break;
            case EQUIPPED_FIRST_PERSON:
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(texture);

                /*
                GL11.glRotatef(10F, 1F, 0F, 0F);
                GL11.glRotatef(200F, 0F, 1F, 0F);
                GL11.glRotatef(165F, 0F, 0F, 1F);

                GL11.glTranslatef(0.4F, 0F, -0.1F);
                */

                GL11.glRotatef(95F, 1F, 0F, 0F);
                GL11.glRotatef(-55F, 0F, 1F, 0F);
                GL11.glRotatef(-85F, 0F, 0F, 1F);

                GL11.glTranslatef(0.2F, 0.4F, -0.7F);

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
