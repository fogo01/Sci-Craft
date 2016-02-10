package com.fogo01.scicraft.items.axes;

import com.fogo01.scicraft.items.ItemSciCraftAxe;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemTinAxe extends ItemSciCraftAxe {
    public ItemTinAxe() {
        super(Materials.Tools.TOOL_TIN);
        this.setUnlocalizedName(Names.Items.AXES[1]);
    }
}
