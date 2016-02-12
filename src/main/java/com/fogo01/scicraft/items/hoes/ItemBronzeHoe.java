package com.fogo01.scicraft.items.hoes;

import com.fogo01.scicraft.items.ItemSciCraftHoe;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemBronzeHoe extends ItemSciCraftHoe {
    public ItemBronzeHoe() {
        super(Materials.Tools.TOOL_BRONZE);
        this.setUnlocalizedName(Names.Items.HOES[4]);
    }
}
