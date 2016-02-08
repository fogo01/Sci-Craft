package com.fogo01.scicraft.items;

import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSpaceBoots extends ItemSciCraftArmor {
    public ItemSpaceBoots() {
        super(Materials.ARMOR_SPACESUIT, 1, 3);
        this.setUnlocalizedName(Names.Items.SPACE_SUIT[3]);
    }
}
