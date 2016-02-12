package com.fogo01.scicraft.items.axes;

import com.fogo01.scicraft.items.ItemSciCraftAxe;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSteelAxe extends ItemSciCraftAxe {
    public ItemSteelAxe() {
        super(Materials.Tools.TOOL_STEEL);
        this.setUnlocalizedName(Names.Items.AXES[5]);
    }
}
