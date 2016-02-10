package com.fogo01.scicraft.items.swords;


import com.fogo01.scicraft.items.ItemSciCraftSword;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemBronzeSword extends ItemSciCraftSword {
    public ItemBronzeSword() {
        super(Materials.Tools.TOOL_BRONZE);
        this.setUnlocalizedName(Names.Items.SWORDS[2]);
    }
}
