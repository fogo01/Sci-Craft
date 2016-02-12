package com.fogo01.scicraft.items.armors.unobtanium;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemUnobtaniumBoots extends ItemSciCraftArmor {
    public ItemUnobtaniumBoots() {
        super(Materials.Armor.ARMOR_UNOBTANIUM, 1, 3);
        this.setUnlocalizedName(Names.Items.UNOBTANIUM_ARMOR[armorType]);
    }
}
