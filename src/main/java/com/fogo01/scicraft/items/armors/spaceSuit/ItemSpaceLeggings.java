package com.fogo01.scicraft.items.armors.spaceSuit;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSpaceLeggings extends ItemSciCraftArmor {
    public ItemSpaceLeggings() {
        super(Materials.Armor.ARMOR_SPACESUIT, 2, 2);
        this.setUnlocalizedName(Names.Items.SPACE_SUIT[2]);
    }
}
