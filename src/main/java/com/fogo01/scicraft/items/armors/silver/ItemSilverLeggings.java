package com.fogo01.scicraft.items.armors.silver;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSilverLeggings extends ItemSciCraftArmor {
    public ItemSilverLeggings() {
        super(Materials.Armor.ARMOR_SILVER, 2, 2);
        this.setUnlocalizedName(Names.Items.SILVER_ARMOR[armorType]);
    }
}
