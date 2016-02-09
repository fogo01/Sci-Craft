package com.fogo01.scicraft.items.armors.steel;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSteelHelmet extends ItemSciCraftArmor {
    public ItemSteelHelmet() {
        super(Materials.ARMOR_STEEL, 1, 0);
        this.setUnlocalizedName(Names.Items.STEEL_ARMOR[0]);
    }
}
