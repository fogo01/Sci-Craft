package com.fogo01.scicraft.init;

import com.fogo01.scicraft.items.*;
import com.fogo01.scicraft.items.ItemSciCraft;
import com.fogo01.scicraft.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {
    public static final ItemSciCraft ALUMINUM_INGOT = new ItemAluminumIngot();
    public static final ItemSciCraft COPPER_INGOT = new ItemCopperIngot();
    public static final ItemSciCraft TIN_INGOT = new ItemTinIngot();
    public static final ItemSciCraft STEEL_INGOT = new ItemSteelIngot();

    public static void init(){
        GameRegistry.registerItem(ALUMINUM_INGOT, Names.Items.ALUMINUM_INGOT);
        GameRegistry.registerItem(COPPER_INGOT, Names.Items.COPPER_INGOT);
        GameRegistry.registerItem(TIN_INGOT, Names.Items.TIN_INGOT);
        GameRegistry.registerItem(STEEL_INGOT, Names.Items.STEEL_INGOT);
	}
}
