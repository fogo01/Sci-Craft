package com.fogo01.scicraft.items.swords;

import com.fogo01.scicraft.items.ItemSciCraftSword;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSteelSword extends ItemSciCraftSword {
    public ItemSteelSword() {
        super(Materials.Tools.TOOL_STEEL);
        this.setUnlocalizedName(Names.Items.SWORDS[3]);
    }
}
