package com.fogo01.scicraft.items.armors.unobtanium;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemUnobtaniumHelmet extends ItemSciCraftArmor {
    public ItemUnobtaniumHelmet() {
        super(Materials.Armor.ARMOR_UNOBTANIUM, 1, 0);
        this.setUnlocalizedName(Names.Items.UNOBTANIUM_ARMOR[armorType]);
    }
}
