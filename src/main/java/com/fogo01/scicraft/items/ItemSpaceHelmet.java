package com.fogo01.scicraft.items;

import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSpaceHelmet extends ItemSciCraftArmor {
    public ItemSpaceHelmet() {
        super(Materials.ARMOR_SPACESUIT, 1, 0);
        this.setUnlocalizedName(Names.Items.SPACE_SUIT[0]);
    }
}
