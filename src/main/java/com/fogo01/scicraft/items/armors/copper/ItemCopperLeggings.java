package com.fogo01.scicraft.items.armors.copper;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemCopperLeggings extends ItemSciCraftArmor {
    public ItemCopperLeggings() {
        super(Materials.Armor.ARMOR_COPPER, 2, 2);
        this.setUnlocalizedName(Names.Items.COPPER_ARMOR[2]);
    }
}
