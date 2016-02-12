package com.fogo01.scicraft.items.armors.steel;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSteelBoots extends ItemSciCraftArmor {
    public ItemSteelBoots() {
        super(Materials.Armor.ARMOR_STEEL, 1, 3);
        this.setUnlocalizedName(Names.Items.STEEL_ARMOR[armorType]);
    }
}
