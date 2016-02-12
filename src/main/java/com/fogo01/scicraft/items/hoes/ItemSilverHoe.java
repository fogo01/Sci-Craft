package com.fogo01.scicraft.items.hoes;

import com.fogo01.scicraft.items.ItemSciCraftHoe;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSilverHoe extends ItemSciCraftHoe {
    public ItemSilverHoe() {
        super(Materials.Tools.TOOL_SILVER);
        this.setUnlocalizedName(Names.Items.HOES[2]);
    }
}
