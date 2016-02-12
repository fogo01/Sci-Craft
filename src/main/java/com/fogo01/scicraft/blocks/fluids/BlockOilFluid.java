package com.fogo01.scicraft.blocks.fluids;

import com.fogo01.scicraft.blocks.BlockSciCraftFluid;
import com.fogo01.scicraft.init.ModFluids;
import com.fogo01.scicraft.reference.Names;
import net.minecraft.block.material.Material;

public class BlockOilFluid extends BlockSciCraftFluid {
    public BlockOilFluid() {
        super(ModFluids.OIL, Material.water);
        this.setBlockName(Names.Blocks.OIL_BLOCK);
        this.setCreativeTab(null);
    }
}
