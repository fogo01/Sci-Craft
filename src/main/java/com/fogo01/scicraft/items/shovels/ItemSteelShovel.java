package com.fogo01.scicraft.items.shovels;

import com.fogo01.scicraft.items.ItemSciCraftShovel;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSteelShovel extends ItemSciCraftShovel {
    public ItemSteelShovel() {
        super(Materials.Tools.TOOL_STEEL);
        this.setUnlocalizedName(Names.Items.SHOVELS[5]);
    }
}
