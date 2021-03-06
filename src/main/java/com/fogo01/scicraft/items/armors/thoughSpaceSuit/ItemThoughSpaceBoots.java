package com.fogo01.scicraft.items.armors.thoughSpaceSuit;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemThoughSpaceBoots extends ItemSciCraftArmor {
    public ItemThoughSpaceBoots() {
        super(Materials.Armor.ARMOR_THOUGH_SPACESUIT, 1, 3);
        this.setUnlocalizedName(Names.Items.THOUGH_SPACE_SUIT[armorType]);
    }
}
