package com.fogo01.scicraft.items.armors.unobtanium;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemUnobtaniumChestplate extends ItemSciCraftArmor {
    public ItemUnobtaniumChestplate() {
        super(Materials.Armor.ARMOR_UNOBTANIUM, 1, 1);
        this.setUnlocalizedName(Names.Items.UNOBTANIUM_ARMOR[armorType]);
    }
}
