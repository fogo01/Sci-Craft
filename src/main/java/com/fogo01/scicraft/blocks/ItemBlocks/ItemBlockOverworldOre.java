package com.fogo01.scicraft.blocks.ItemBlocks;

import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockOverworldOre extends ItemBlockWithMetadata {
    public ItemBlockOverworldOre(Block block) {
        super(block, block);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", Names.Blocks.OVERWORLD_ORES[itemStack.getItemDamage()]);
    }
}
