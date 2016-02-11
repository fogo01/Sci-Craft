package com.fogo01.scicraft.items.pickaxes;

import com.fogo01.scicraft.items.ItemSciCraftPickaxe;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemLeadPickaxe extends ItemSciCraftPickaxe {
    public ItemLeadPickaxe() {
        super(Materials.Tools.TOOL_LEAD);
        this.setUnlocalizedName(Names.Items.PICKAXES[3]);
    }
}
