package com.fogo01.scicraft.items;

import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSpaceChestplate extends ItemSciCraftArmor {
    public ItemSpaceChestplate() {
        super(Materials.ARMOR_SPACESUIT, 1, 1);
        this.setUnlocalizedName(Names.Items.SPACE_SUIT[1]);
    }
}
