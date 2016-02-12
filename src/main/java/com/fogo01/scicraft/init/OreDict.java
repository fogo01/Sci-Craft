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
        OreDictionary.registerOre("ingotBronze", ModItems.BRONZE_INGOT);
        OreDictionary.registerOre("ingotSteel", ModItems.STEEL_INGOT);
        OreDictionary.registerOre("ingotUranium", ModItems.URANIUM_INGOT);
        OreDictionary.registerOre("ingotUnobtanium", ModItems.UNOBTANIUM_INGOT);

        OreDictionary.registerOre("oreAluminum", new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 0));
        OreDictionary.registerOre("oreCopper", new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 1));
        OreDictionary.registerOre("oreTin", new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 2));
        OreDictionary.registerOre("oreSilver", new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 3));
        OreDictionary.registerOre("oreLead", new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 4));
        OreDictionary.registerOre("oreUranium", new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 5));

        OreDictionary.registerOre("blockAluminum", new ItemStack(ModBlocks.METAL_BLOCK, 1, 0));
        OreDictionary.registerOre("blockCopper", new ItemStack(ModBlocks.METAL_BLOCK, 1, 1));
        OreDictionary.registerOre("blockTin", new ItemStack(ModBlocks.METAL_BLOCK, 1, 2));
        OreDictionary.registerOre("blockSilver", new ItemStack(ModBlocks.METAL_BLOCK, 1, 3));
        OreDictionary.registerOre("blockLead", new ItemStack(ModBlocks.METAL_BLOCK, 1, 4));
        OreDictionary.registerOre("blockBronze", new ItemStack(ModBlocks.METAL_BLOCK, 1, 5));
        OreDictionary.registerOre("blockSteel", new ItemStack(ModBlocks.METAL_BLOCK, 1, 6));
        OreDictionary.registerOre("blockUranium", new ItemStack(ModBlocks.METAL_BLOCK, 1, 7));
        OreDictionary.registerOre("blockUnobtanium", new ItemStack(ModBlocks.METAL_BLOCK, 1, 8));
    }
}
