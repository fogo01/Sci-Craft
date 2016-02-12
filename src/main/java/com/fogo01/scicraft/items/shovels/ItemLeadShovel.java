package com.fogo01.scicraft.items.shovels;

import com.fogo01.scicraft.items.ItemSciCraftShovel;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemLeadShovel extends ItemSciCraftShovel {
    public ItemLeadShovel() {
        super(Materials.Tools.TOOL_LEAD);
        this.setUnlocalizedName(Names.Items.SHOVELS[3]);
    }
}
