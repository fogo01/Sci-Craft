package com.fogo01.scicraft.items.axes;

import com.fogo01.scicraft.items.ItemSciCraftAxe;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;

public class ItemBronzeAxe extends ItemSciCraftAxe {
    public ItemBronzeAxe() {
        super(Materials.Tools.TOOL_BRONZE);
        this.setUnlocalizedName(Names.Items.AXES[2]);
    }
}
