package com.fogo01.scicraft.items.armors.lead;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemLeadLeggings extends ItemSciCraftArmor {
    public ItemLeadLeggings() {
        super(Materials.Armor.ARMOR_LEAD, 2, 2);
        this.setUnlocalizedName(Names.Items.LEAD_ARMOR[armorType]);
    }
}
