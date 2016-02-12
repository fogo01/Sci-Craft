package com.fogo01.scicraft.items.armors.unobtanium;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemUnobtaniumLeggings extends ItemSciCraftArmor {
    public ItemUnobtaniumLeggings() {
        super(Materials.Armor.ARMOR_UNOBTANIUM, 2, 2);
        this.setUnlocalizedName(Names.Items.UNOBTANIUM_ARMOR[armorType]);
    }
}
