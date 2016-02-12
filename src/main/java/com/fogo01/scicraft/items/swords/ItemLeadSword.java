package com.fogo01.scicraft.items.swords;

import com.fogo01.scicraft.items.ItemSciCraftSword;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemLeadSword extends ItemSciCraftSword {
    public ItemLeadSword() {
        super(Materials.Tools.TOOL_LEAD);
        this.setUnlocalizedName(Names.Items.SWORDS[3]);
    }
}
