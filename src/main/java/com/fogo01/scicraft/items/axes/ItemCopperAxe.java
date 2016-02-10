package com.fogo01.scicraft.items.axes;

import com.fogo01.scicraft.items.ItemSciCraftAxe;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemCopperAxe extends ItemSciCraftAxe {
    public ItemCopperAxe() {
        super(Materials.Tools.TOOL_COPPER);
        this.setUnlocalizedName(Names.Items.AXES[0]);
    }
}
