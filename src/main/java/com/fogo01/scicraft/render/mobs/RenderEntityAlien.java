package com.fogo01.scicraft.render.mobs;

import com.fogo01.scicraft.entities.monsters.EntityAlien;
import com.fogo01.scicraft.reference.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderEntityAlien extends RenderLiving {
    private static final ResourceLocation textures = new ResourceLocation(Reference.MOD_ID + ":textures/models/entities/Alien.png");

    public RenderEntityAlien(ModelBase modelBase, float float0) {
        super(modelBase, float0);
    }

    protected ResourceLocation getEntityTexture(EntityAlien entityAlien) {
        return textures;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntityAlien)entity);
    }
}
