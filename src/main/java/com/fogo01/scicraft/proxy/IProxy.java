package com.fogo01.scicraft.proxy;

public interface IProxy {
    public abstract ClientProxy getClientProxy();

    public abstract void registerRenderThings();

    public abstract void registerTileEntitySpecialRender();
}
