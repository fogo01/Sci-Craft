package com.fogo01.scicraft.items.armors.bronze;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemBronzeHelmet extends ItemSciCraftArmor {
    public ItemBronzeHelmet() {
        super(Materials.ARMOR_BRONZE, 1, 0);
        this.setUnlocalizedName(Names.Items.BRONZE_ARMOR[0]);
    }
}
