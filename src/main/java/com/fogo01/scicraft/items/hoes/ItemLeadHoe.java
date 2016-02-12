package com.fogo01.scicraft.items.hoes;

import com.fogo01.scicraft.items.ItemSciCraftHoe;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemLeadHoe extends ItemSciCraftHoe {
    public ItemLeadHoe() {
        super(Materials.Tools.TOOL_LEAD);
        this.setUnlocalizedName(Names.Items.HOES[3]);
    }
}
