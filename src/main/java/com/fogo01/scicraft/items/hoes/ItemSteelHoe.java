package com.fogo01.scicraft.items.hoes;

import com.fogo01.scicraft.items.ItemSciCraftHoe;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSteelHoe extends ItemSciCraftHoe {
    public ItemSteelHoe() {
        super(Materials.Tools.TOOL_STEEL);
        this.setUnlocalizedName(Names.Items.HOES[5]);
    }
}
