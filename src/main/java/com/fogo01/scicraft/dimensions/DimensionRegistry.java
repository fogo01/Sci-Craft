package com.fogo01.scicraft.dimensions;

import com.fogo01.scicraft.reference.Dimensions;
import net.minecraftforge.common.DimensionManager;

public class DimensionRegistry {
    public static void registerDimension() {
        DimensionManager.registerProviderType(Dimensions.IDs.DIMENSION_ID_MOON, WorldProviderMoon.class, false);
        DimensionManager.registerDimension(Dimensions.IDs.DIMENSION_ID_MOON, Dimensions.IDs.DIMENSION_ID_MOON);
    }
}
