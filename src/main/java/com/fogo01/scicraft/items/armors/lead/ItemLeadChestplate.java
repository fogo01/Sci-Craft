package com.fogo01.scicraft.items.armors.lead;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemLeadChestplate extends ItemSciCraftArmor {
    public ItemLeadChestplate() {
        super(Materials.Armor.ARMOR_LEAD, 1, 1);
        this.setUnlocalizedName(Names.Items.LEAD_ARMOR[armorType]);
    }
}
