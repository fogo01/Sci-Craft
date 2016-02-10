package com.fogo01.scicraft.items.armors.steel;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSteelChestplate extends ItemSciCraftArmor {
    public ItemSteelChestplate() {
        super(Materials.Armor.ARMOR_STEEL, 1, 1);
        this.setUnlocalizedName(Names.Items.STEEL_ARMOR[1]);
    }
}
