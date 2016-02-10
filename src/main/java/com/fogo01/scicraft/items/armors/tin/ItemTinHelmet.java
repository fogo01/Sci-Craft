package com.fogo01.scicraft.items.armors.tin;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemTinHelmet extends ItemSciCraftArmor {
    public ItemTinHelmet() {
        super(Materials.Armor.ARMOR_TIN, 1, 0);
        this.setUnlocalizedName(Names.Items.TIN_ARMOR[0]);
    }
}
