package com.fogo01.scicraft.items.armors.tin;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemTinLeggings extends ItemSciCraftArmor {
    public ItemTinLeggings() {
        super(Materials.Armor.ARMOR_TIN, 2, 2);
        this.setUnlocalizedName(Names.Items.TIN_ARMOR[2]);
    }
}
