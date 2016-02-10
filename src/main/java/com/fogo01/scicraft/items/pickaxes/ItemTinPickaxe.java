package com.fogo01.scicraft.items.pickaxes;

import com.fogo01.scicraft.items.ItemSciCraftPickaxe;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemTinPickaxe extends ItemSciCraftPickaxe {
    public ItemTinPickaxe() {
        super(Materials.Tools.TOOL_TIN);
        this.setUnlocalizedName(Names.Items.PICKAXES[1]);
    }
}
