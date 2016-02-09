package com.fogo01.scicraft.items.armors.copper;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemCopperChestplate extends ItemSciCraftArmor {
    public ItemCopperChestplate() {
        super(Materials.ARMOR_COPPER, 1, 1);
        this.setUnlocalizedName(Names.Items.COPPER_ARMOR[1]);
    }
}
