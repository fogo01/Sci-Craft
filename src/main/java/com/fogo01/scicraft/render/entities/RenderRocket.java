package com.fogo01.scicraft.render.entities;

import com.fogo01.scicraft.entities.rockets.EntityRocket;
import com.fogo01.scicraft.models.ModelRocketBoosterT2;
import com.fogo01.scicraft.models.ModelRocket;
import com.fogo01.scicraft.models.ModelRocketBooster;
import com.fogo01.scicraft.reference.Reference;
import com.fogo01.scicraft.utility.LogHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderRocket extends Render {
    private static final ResourceLocation textures = new ResourceLocation(Reference.MOD_ID + ":textures/models/Rocket.png");
    private static final ResourceLocation boosterT1Texture = new ResourceLocation(Reference.MOD_ID + ":textures/models/RocketBooster.png");
    private static final ResourceLocation boosterT2Texture = new ResourceLocation(Reference.MOD_ID + ":textures/models/RocketBoosterT2.png");

    protected ModelBase modelRocket;
    protected ModelBase modelBoosterT1;
    protected ModelBase modelBoosterT2;

    public RenderRocket() {
        this.shadowSize = 0.5F;
        this.modelRocket = new ModelRocket();
        this.modelBoosterT1 = new ModelRocketBooster();
        this.modelBoosterT2 = new ModelRocketBoosterT2();
    }

    public void doRender(EntityRocket entity, double d0, double d1, double d2, float d3, float d4) {
        GL11.glPushMatrix();

        GL11.glTranslatef((float)d0, (float)d1, (float)d2);
        GL11.glRotatef(180F - d3, 0F, 1F, 0F);
        GL11.glRotatef(180F, 1F, 0F, 0F);

        this.bindEntityTexture(entity);
        this.modelRocket.render(entity, 0F, 0F, 0.1F, 0F, 0F, 0.0625F);

        if (entity.getPart(4) == 1) {
            this.bindTexture(boosterT1Texture);

            GL11.glTranslatef(0F, -2.5F, 1F);
            this.modelBoosterT1.render(entity, 0F, 0F, -0.1F, 0F, 0F, 0.0625F);
            GL11.glTranslatef(0F, 0F, -1F);

            GL11.glTranslatef(0F, 0F, -1F);
            this.modelBoosterT1.render(entity, 0F, 0F, -0.1F, 0F, 0F, 0.0625F);
            GL11.glTranslatef(0F, 0F, 1F);

            GL11.glTranslatef(1F, 0F, 0F);
            this.modelBoosterT1.render(entity, 0F, 0F, -0.1F, 0F, 0F, 0.0625F);
            GL11.glTranslatef(-1F, 0F, 0F);

            GL11.glTranslatef(-1F, 0F, 0F);
            this.modelBoosterT1.render(entity, 0F, 0F, -0.1F, 0F, 0F, 0.0625F);
            GL11.glTranslatef(1F, 2.5F, 0F);
        } else if (entity.getPart(4) == 2) {
            this.bindTexture(boosterT2Texture);

            GL11.glTranslatef(0F, -2.5F, 1.2F);
            this.modelBoosterT2.render(entity, 0F, 0F, -0.1F, 0F, 0F, 0.0625F);
            GL11.glTranslatef(0F, 0F, -1.2F);

            GL11.glTranslatef(0F, 0F, -1.2F);
            this.modelBoosterT2.render(entity, 0F, 0F, -0.1F, 0F, 0F, 0.0625F);
            GL11.glTranslatef(0F, 0F, 1.2F);

            GL11.glTranslatef(1.2F, 0F, 0F);
            this.modelBoosterT2.render(entity, 0F, 0F, -0.1F, 0F, 0F, 0.0625F);
            GL11.glTranslatef(-1.2F, 0F, 0F);

            GL11.glTranslatef(-1.2F, 0F, 0F);
            this.modelBoosterT2.render(entity, 0F, 0F, -0.1F, 0F, 0F, 0.0625F);
            GL11.glTranslatef(1.2F, 2.5F, 0F);
        }



        GL11.glPopMatrix();
    }

    protected ResourceLocation getEntityTexture(EntityRocket entity) {
        return textures;
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntityRocket) entity);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float d3, float d4) {
        this.doRender((EntityRocket) entity, d, d1, d2, d3, d4);
    }
}
