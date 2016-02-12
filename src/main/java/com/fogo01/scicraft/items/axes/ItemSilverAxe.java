package com.fogo01.scicraft.items.axes;

import com.fogo01.scicraft.items.ItemSciCraftAxe;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemSilverAxe extends ItemSciCraftAxe {
    public ItemSilverAxe() {
        super(Materials.Tools.TOOL_SILVER);
        this.setUnlocalizedName(Names.Items.AXES[2]);
    }
}
