package com.fogo01.scicraft.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDict {
    public static void init() {
        OreDictionary.registerOre("ingotAluminum", ModItems.ALUMINUM_INGOT);
        OreDictionary.registerOre("ingotCopper", ModItems.COPPER_INGOT);
        OreDictionary.registerOre("ingotTin", ModItems.TIN_INGOT);

        OreDictionary.registerOre("oreAluminum", new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 0));
        OreDictionary.registerOre("oreCopper", new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 1));
        OreDictionary.registerOre("oreTin", new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 2));

        OreDictionary.registerOre("blockAluminum", ModBlocks.ALUMINUM_BLOCK);
        OreDictionary.registerOre("blockCopper", ModBlocks.COPPER_BLOCK);
        OreDictionary.registerOre("blockTin", ModBlocks.TIN_BLOCK);
    }
}
