package com.fogo01.scicraft.items.pickaxes;

import com.fogo01.scicraft.items.ItemSciCraftPickaxe;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSilverPickaxe extends ItemSciCraftPickaxe {
    public ItemSilverPickaxe() {
        super(Materials.Tools.TOOL_SILVER);
        this.setUnlocalizedName(Names.Items.PICKAXES[2]);
    }
}
