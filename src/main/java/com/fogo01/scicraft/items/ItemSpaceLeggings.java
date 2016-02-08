package com.fogo01.scicraft.items;

import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSpaceLeggings extends ItemSciCraftArmor {
    public ItemSpaceLeggings() {
        super(Materials.ARMOR_SPACESUIT, 2, 2);
        this.setUnlocalizedName(Names.Items.SPACE_SUIT[2]);
    }
}
