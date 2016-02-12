package com.fogo01.scicraft.blocks.fluids;

import com.fogo01.scicraft.blocks.BlockSciCraftFluid;
import com.fogo01.scicraft.init.ModFluids;
import com.fogo01.scicraft.reference.Names;
import net.minecraft.block.material.Material;

public class BlockFuelFluid extends BlockSciCraftFluid{
    public BlockFuelFluid() {
        super(ModFluids.FUEL, Material.water);
        this.setBlockName(Names.Blocks.FUEL_BLOCK);
        this.setCreativeTab(null);
    }
}
