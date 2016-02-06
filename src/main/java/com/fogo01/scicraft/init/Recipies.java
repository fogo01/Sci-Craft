package com.fogo01.scicraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipies {
	public static void init(){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.ALUMINUM_BLOCK), "III", "III", "III", 'I', "ingotAluminum"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.COPPER_BLOCK), "III", "III", "III", 'I', "ingotCopper"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.TIN_BLOCK), "III", "III", "III", 'I', "ingotTin"));


        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.ALUMINUM_INGOT, 9), ModBlocks.ALUMINUM_BLOCK));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.COPPER_INGOT, 9), ModBlocks.COPPER_BLOCK));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.TIN_INGOT, 9), ModBlocks.TIN_BLOCK));


        GameRegistry.addSmelting(ModBlocks.ALUMINUM_ORE, new ItemStack(ModItems.ALUMINUM_INGOT), 0.8F);
        GameRegistry.addSmelting(ModBlocks.COPPER_ORE, new ItemStack(ModItems.COPPER_INGOT), 0.4F);
        GameRegistry.addSmelting(ModBlocks.TIN_ORE, new ItemStack(ModItems.TIN_INGOT), 0.4F);
	}
}
