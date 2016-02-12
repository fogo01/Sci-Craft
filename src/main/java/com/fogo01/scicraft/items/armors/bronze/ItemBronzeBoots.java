package com.fogo01.scicraft.items.armors.bronze;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemBronzeBoots extends ItemSciCraftArmor {
    public ItemBronzeBoots() {
        super(Materials.Armor.ARMOR_BRONZE, 1, 3);
        this.setUnlocalizedName(Names.Items.BRONZE_ARMOR[armorType]);
    }
}
