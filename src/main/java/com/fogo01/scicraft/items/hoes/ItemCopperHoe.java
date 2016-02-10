package com.fogo01.scicraft.items.hoes;

import com.fogo01.scicraft.items.ItemSciCraftHoe;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemCopperHoe extends ItemSciCraftHoe {
    public ItemCopperHoe() {
        super(Materials.Tools.TOOL_COPPER);
        this.setUnlocalizedName(Names.Items.HOES[0]);
    }
}
