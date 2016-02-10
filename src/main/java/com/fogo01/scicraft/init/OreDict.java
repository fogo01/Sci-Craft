package com.fogo01.scicraft.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDict {
    public static void init() {
        OreDictionary.registerOre("ingotAluminum", ModItems.ALUMINUM_INGOT);
        OreDictionary.registerOre("ingotCopper", ModItems.COPPER_INGOT);
        OreDictionary.registerOre("ingotTin", ModItems.TIN_INGOT);
        OreDictionary.registerOre("ingotSilver", ModItems.SILVER_INGOT);
        OreDictionary.registerOre("ingotLead", ModItems.LEAD_INGOT);
        OreDictionary.registerOre("ingotUranium", ModItems.URANIUM_INGOT);

        OreDictionary.registerOre("oreAluminum", new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 0));
        OreDictionary.registerOre("oreCopper", new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 1));
        OreDictionary.registerOre("oreTin", new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 2));
        OreDictionary.registerOre("oreSilver", new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 3));
        OreDictionary.registerOre("oreLead", new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 4));
        OreDictionary.registerOre("oreUranium", new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 5));

        OreDictionary.registerOre("blockAluminum", ModBlocks.ALUMINUM_BLOCK);
        OreDictionary.registerOre("blockCopper", ModBlocks.COPPER_BLOCK);
        OreDictionary.registerOre("blockTin", ModBlocks.TIN_BLOCK);
        OreDictionary.registerOre("blockSilver", ModBlocks.SILVER_BLOCK);
        OreDictionary.registerOre("blockLead", ModBlocks.LEAD_BLOCK);
        OreDictionary.registerOre("blockUranium", ModBlocks.URANIUM_BLOCK);
    }
}
