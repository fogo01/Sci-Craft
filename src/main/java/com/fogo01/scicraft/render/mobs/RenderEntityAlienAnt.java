package com.fogo01.scicraft.render.mobs;

import com.fogo01.scicraft.entities.monsters.EntityAlienAnt;
import com.fogo01.scicraft.reference.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderEntityAlienAnt extends RenderLiving {
    private static final ResourceLocation textures = new ResourceLocation(Reference.MOD_ID + ":textures/models/entities/AlienAnt.png");

    public RenderEntityAlienAnt(ModelBase modelBase, float float0) {
        super(modelBase, float0);
    }

    protected ResourceLocation getEntityTexture(EntityAlienAnt entityAlienAnt) {
        return textures;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((EntityAlienAnt)entity);
    }
}
