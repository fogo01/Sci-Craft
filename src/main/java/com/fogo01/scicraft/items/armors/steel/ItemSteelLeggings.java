package com.fogo01.scicraft.items.armors.steel;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSteelLeggings extends ItemSciCraftArmor {
    public ItemSteelLeggings() {
        super(Materials.ARMOR_STEEL, 2, 2);
        this.setUnlocalizedName(Names.Items.STEEL_ARMOR[2]);
    }
}
