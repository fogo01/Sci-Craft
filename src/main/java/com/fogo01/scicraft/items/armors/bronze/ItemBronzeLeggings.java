package com.fogo01.scicraft.items.armors.bronze;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemBronzeLeggings extends ItemSciCraftArmor {
    public ItemBronzeLeggings() {
        super(Materials.Armor.ARMOR_BRONZE, 2, 2);
        this.setUnlocalizedName(Names.Items.BRONZE_ARMOR[2]);
    }
}
