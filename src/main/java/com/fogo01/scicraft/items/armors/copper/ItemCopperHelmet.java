package com.fogo01.scicraft.items.armors.copper;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemCopperHelmet extends ItemSciCraftArmor {
    public ItemCopperHelmet() {
        super(Materials.ARMOR_COPPER, 1, 0);
        this.setUnlocalizedName(Names.Items.COPPER_ARMOR[0]);
    }
}
