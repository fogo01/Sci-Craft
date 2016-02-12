package com.fogo01.scicraft.items.buckets;

import com.fogo01.scicraft.init.ModBlocks;
import com.fogo01.scicraft.items.ItemSciCraftBucket;
import com.fogo01.scicraft.reference.Names;

public class ItemFuelBucket extends ItemSciCraftBucket {
    public ItemFuelBucket() {
        super(ModBlocks.FUEL_BLOCK);
        this.setUnlocalizedName(Names.Items.FUEL_BUCKET);
    }
}
