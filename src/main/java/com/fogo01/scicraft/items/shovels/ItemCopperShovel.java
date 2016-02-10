package com.fogo01.scicraft.items.shovels;

import com.fogo01.scicraft.items.ItemSciCraftShovel;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemCopperShovel extends ItemSciCraftShovel {
    public ItemCopperShovel() {
        super(Materials.Tools.TOOL_COPPER);
        this.setUnlocalizedName(Names.Items.SHOVELS[0]);
    }
}
