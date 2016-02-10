package com.fogo01.scicraft.items.shovels;

import com.fogo01.scicraft.items.ItemSciCraftShovel;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemTinShovel extends ItemSciCraftShovel {
    public ItemTinShovel() {
        super(Materials.Tools.TOOL_TIN);
        this.setUnlocalizedName(Names.Items.SHOVELS[1]);
    }
}
