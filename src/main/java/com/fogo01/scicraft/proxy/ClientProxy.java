package com.fogo01.scicraft.proxy;

import com.fogo01.scicraft.entities.monsters.*;
import com.fogo01.scicraft.entities.rockets.EntityRocket;
import com.fogo01.scicraft.init.ModItems;
import com.fogo01.scicraft.models.*;
import com.fogo01.scicraft.render.entities.RenderRocket;
import com.fogo01.scicraft.render.items.RenderPlasmaLauncher;
import com.fogo01.scicraft.render.tileentities.*;
import com.fogo01.scicraft.render.mobs.*;
import com.fogo01.scicraft.tileentity.TileEntityEnergyCable;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
    @Override
    public ClientProxy getClientProxy() {
        return this;
    }

    @Override
    public void registerRenderThings() {
        RenderingRegistry.registerEntityRenderingHandler(EntityAlien.class, new RenderEntityAlien(new ModelAlien(), 0));
        RenderingRegistry.registerEntityRenderingHandler(EntityAlienAnt.class, new RenderEntityAlienAnt(new ModelAlienAnt(), 0));
        RenderingRegistry.registerEntityRenderingHandler(EntityRocket.class, new RenderRocket());

        MinecraftForgeClient.registerItemRenderer(ModItems.PLASMA_LAUNCHER, (IItemRenderer)new RenderPlasmaLauncher());
    }

    @Override
    public void registerTileEntitySpecialRender() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnergyCable.class, new TileEntityRenderEnergyCable());
    }
}
