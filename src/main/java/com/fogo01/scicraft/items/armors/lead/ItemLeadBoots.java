package com.fogo01.scicraft.items.armors.lead;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemLeadBoots extends ItemSciCraftArmor {
    public ItemLeadBoots() {
        super(Materials.Armor.ARMOR_LEAD, 1, 3);
        this.setUnlocalizedName(Names.Items.LEAD_ARMOR[armorType]);
    }
}
