package com.fogo01.scicraft.items.armors.spaceSuit;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSpaceChestplate extends ItemSciCraftArmor {
    public ItemSpaceChestplate() {
        super(Materials.Armor.ARMOR_SPACESUIT, 1, 1);
        this.setUnlocalizedName(Names.Items.SPACE_SUIT[1]);
    }
}
