package com.fogo01.scicraft.items.pickaxes;

import com.fogo01.scicraft.items.ItemSciCraftPickaxe;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemCopperPickaxe extends ItemSciCraftPickaxe {
    public ItemCopperPickaxe() {
        super(Materials.Tools.TOOL_COPPER);
        this.setUnlocalizedName(Names.Items.PICKAXES[0]);
    }
}
