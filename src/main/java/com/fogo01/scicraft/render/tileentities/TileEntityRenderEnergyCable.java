package com.fogo01.scicraft.render.tileentities;

import com.fogo01.scicraft.reference.Reference;
import net.minecraft.util.ResourceLocation;

public class TileEntityRenderEnergyCable extends TileEntityRenderPipe {
    public TileEntityRenderEnergyCable() {
        texture = new ResourceLocation(Reference.MOD_ID + ":textures/models/EnergyCable.png");
        drawInside = false;
    }
}
