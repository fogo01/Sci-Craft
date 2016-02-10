package com.fogo01.scicraft.items.shovels;

import com.fogo01.scicraft.items.ItemSciCraftShovel;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemBronzeShovel extends ItemSciCraftShovel {
    public ItemBronzeShovel() {
        super(Materials.Tools.TOOL_BRONZE);
        this.setUnlocalizedName(Names.Items.SHOVELS[2]);
    }
}
