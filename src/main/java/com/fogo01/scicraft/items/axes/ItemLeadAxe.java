package com.fogo01.scicraft.items.axes;

import com.fogo01.scicraft.items.ItemSciCraftAxe;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemLeadAxe extends ItemSciCraftAxe {
    public ItemLeadAxe() {
        super(Materials.Tools.TOOL_LEAD);
        this.setUnlocalizedName(Names.Items.AXES[3]);
    }
}
