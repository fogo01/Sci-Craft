package com.fogo01.scicraft.items.armors.bronze;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemBronzeChestplate extends ItemSciCraftArmor {
    public ItemBronzeChestplate() {
        super(Materials.ARMOR_BRONZE, 1, 1);
        this.setUnlocalizedName(Names.Items.BRONZE_ARMOR[1]);
    }
}
