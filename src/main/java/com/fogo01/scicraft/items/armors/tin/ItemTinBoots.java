package com.fogo01.scicraft.items.armors.tin;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemTinBoots extends ItemSciCraftArmor {
    public ItemTinBoots() {
        super(Materials.Armor.ARMOR_TIN, 1, 3);
        this.setUnlocalizedName(Names.Items.TIN_ARMOR[armorType]);
    }
}
