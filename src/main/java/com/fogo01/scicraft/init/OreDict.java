package com.fogo01.scicraft.init;

import net.minecraftforge.oredict.OreDictionary;

public class OreDict {
    public static void init() {
        OreDictionary.registerOre("ingotAluminum", ModItems.ALUMINUM_INGOT);
        OreDictionary.registerOre("ingotCopper", ModItems.COPPER_INGOT);
        OreDictionary.registerOre("ingotTin", ModItems.TIN_INGOT);
        OreDictionary.registerOre("ingotBronze", ModItems.BRONZE_INGOT);
        OreDictionary.registerOre("ingotSteel", ModItems.STEEL_INGOT);

        OreDictionary.registerOre("oreAluminum", ModBlocks.ALUMINUM_ORE);
        OreDictionary.registerOre("oreCopper", ModBlocks.COPPER_ORE);
        OreDictionary.registerOre("oreTin", ModBlocks.TIN_ORE);

        OreDictionary.registerOre("blockAluminum", ModBlocks.ALUMINUM_BLOCK);
        OreDictionary.registerOre("blockCopper", ModBlocks.COPPER_BLOCK);
        OreDictionary.registerOre("blockTin", ModBlocks.TIN_BLOCK);
        OreDictionary.registerOre("blockBronze", ModBlocks.BRONZE_BLOCK);
        OreDictionary.registerOre("blockSteel", ModBlocks.STEEL_BLOCK);
    }
}
