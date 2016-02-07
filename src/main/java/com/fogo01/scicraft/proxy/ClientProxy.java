package com.fogo01.scicraft.proxy;

import com.fogo01.scicraft.entities.monsters.EntityAlien;
import com.fogo01.scicraft.models.ModelAlien;
import com.fogo01.scicraft.render.mobs.RenderEntityAlien;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public ClientProxy getClientProxy() {
        return this;
    }

    @Override
    public void registerRenderThings() {
        RenderingRegistry.registerEntityRenderingHandler(EntityAlien.class, new RenderEntityAlien(new ModelAlien(), 0));
    }

    @Override
    public void registerTileEntitySpecialRender() {

    }
}
