package com.fogo01.scicraft.items.swords;

import com.fogo01.scicraft.items.ItemSciCraftSword;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemCopperSword extends ItemSciCraftSword {
    public ItemCopperSword() {
        super(Materials.Tools.TOOL_COPPER);
        this.setUnlocalizedName(Names.Items.SWORDS[0]);
    }
}
