package com.fogo01.scicraft.items.shovels;

import com.fogo01.scicraft.items.ItemSciCraftShovel;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSilverShovel extends ItemSciCraftShovel {
    public ItemSilverShovel() {
        super(Materials.Tools.TOOL_SILVER);
        this.setUnlocalizedName(Names.Items.SHOVELS[2]);
    }
}
