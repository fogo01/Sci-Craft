package com.fogo01.scicraft.items.armors.silver;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSilverHelmet extends ItemSciCraftArmor {
    public ItemSilverHelmet() {
        super(Materials.Armor.ARMOR_SILVER, 1, 0);
        this.setUnlocalizedName(Names.Items.SILVER_ARMOR[armorType]);
    }
}
