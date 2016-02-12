package com.fogo01.scicraft.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class ModBuckets {
    public static void init() {
        FluidContainerRegistry.registerFluidContainer(ModFluids.OIL, new ItemStack(ModItems.OIL_BUCKET), new ItemStack(Items.bucket));
    }
}
