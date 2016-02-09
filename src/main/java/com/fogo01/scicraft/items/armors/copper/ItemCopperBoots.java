package com.fogo01.scicraft.items.armors.copper;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemCopperBoots extends ItemSciCraftArmor {
    public ItemCopperBoots() {
        super(Materials.ARMOR_COPPER, 1, 3);
        this.setUnlocalizedName(Names.Items.COPPER_ARMOR[3]);
    }
}
