package com.fogo01.scicraft.items.swords;

import com.fogo01.scicraft.items.ItemSciCraftSword;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemTinSword extends ItemSciCraftSword {
    public ItemTinSword() {
        super(Materials.Tools.TOOL_TIN);
        this.setUnlocalizedName(Names.Items.SWORDS[1]);
    }
}
