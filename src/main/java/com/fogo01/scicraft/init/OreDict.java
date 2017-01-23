package com.fogo01.scicraft.init;

import com.fogo01.scicraft.reference.Names;
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

        OreDictionary.registerOre("oreAluminum", ModBlocks.ALUMINUM_ORE);
        OreDictionary.registerOre("oreCopper", ModBlocks.COPPER_ORE);
        OreDictionary.registerOre("oreTin", ModBlocks.TIN_ORE);
        OreDictionary.registerOre("oreSilver", ModBlocks.SILVER_ORE);
        OreDictionary.registerOre("oreLead", ModBlocks.LEAD_ORE);
        OreDictionary.registerOre("oreUranium", ModBlocks.URANIUM_ORE);

        String[] metals = {"Iron", "Gold", "Aluminum", "Copper", "Tin", "Silver", "Lead", "Bronze", "Steel", "Unobtanium"};
        for (int i = 0; i < Names.Items.METAL_DUSTS.length; i++)
            OreDictionary.registerOre("dust" + metals[i], new ItemStack(ModItems.METAL_DUST, 1, i));


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
