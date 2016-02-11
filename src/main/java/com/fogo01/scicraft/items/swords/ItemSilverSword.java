package com.fogo01.scicraft.items.swords;

import com.fogo01.scicraft.items.ItemSciCraftSword;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSilverSword extends ItemSciCraftSword {
    public ItemSilverSword() {
        super(Materials.Tools.TOOL_SILVER);
        this.setUnlocalizedName(Names.Items.SWORDS[2]);
    }
}
