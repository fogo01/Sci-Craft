package com.fogo01.scicraft.init;

import com.fogo01.scicraft.reference.Names;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {
    public static final Fluid OIL = new Fluid(Names.Fluids.FLUID_OIL).setViscosity(3000).setUnlocalizedName(Names.Fluids.FLUID_OIL);
    public static final Fluid FUEL = new Fluid(Names.Fluids.FLUID_FUEL).setViscosity(1000).setUnlocalizedName(Names.Fluids.FLUID_FUEL);

    public static void init() {
        FluidRegistry.registerFluid(OIL);
        FluidRegistry.registerFluid(FUEL);
    }
}