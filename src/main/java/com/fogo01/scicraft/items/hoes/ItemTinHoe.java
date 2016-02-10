package com.fogo01.scicraft.items.hoes;

import com.fogo01.scicraft.items.ItemSciCraftHoe;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemTinHoe extends ItemSciCraftHoe {
    public ItemTinHoe() {
        super(Materials.Tools.TOOL_TIN);
        this.setUnlocalizedName(Names.Items.HOES[1]);
    }
}
