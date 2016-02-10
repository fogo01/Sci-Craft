package com.fogo01.scicraft.items.pickaxes;

import com.fogo01.scicraft.items.ItemSciCraftPickaxe;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemBronzePickaxe extends ItemSciCraftPickaxe {
    public ItemBronzePickaxe() {
        super(Materials.Tools.TOOL_BRONZE);
        this.setUnlocalizedName(Names.Items.PICKAXES[2]);
    }
}
