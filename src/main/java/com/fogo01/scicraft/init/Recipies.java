package com.fogo01.scicraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipies {
	public static void init(){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.ALUMINUM_BLOCK), "III", "III", "III", 'I', "ingotAluminum"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.COPPER_BLOCK), "III", "III", "III", 'I', "ingotCopper"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.TIN_BLOCK), "III", "III", "III", 'I', "ingotTin"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.SILVER_BLOCK), "III", "III", "III", 'I', "ingotSilver"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.LEAD_BLOCK), "III", "III", "III", 'I', "ingotLead"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.URANIUM_BLOCK), "III", "III", "III", 'I', "ingotUranium"));


        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.ALUMINUM_INGOT, 9), ModBlocks.ALUMINUM_BLOCK));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.COPPER_INGOT, 9), ModBlocks.COPPER_BLOCK));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.TIN_INGOT, 9), ModBlocks.TIN_BLOCK));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.SILVER_INGOT, 9), ModBlocks.SILVER_BLOCK));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.LEAD_INGOT, 9), ModBlocks.LEAD_BLOCK));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.URANIUM_INGOT, 9), ModBlocks.URANIUM_BLOCK));


        GameRegistry.addSmelting(new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 0), new ItemStack(ModItems.ALUMINUM_INGOT), 0.6F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 1), new ItemStack(ModItems.COPPER_INGOT), 0.4F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 2), new ItemStack(ModItems.TIN_INGOT), 0.4F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 3), new ItemStack(ModItems.SILVER_INGOT), 0.8F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.OVERWORLD_ORE, 1, 4), new ItemStack(ModItems.LEAD_INGOT), 0.8F);

        GameRegistry.addSmelting(new ItemStack(ModBlocks.MOON_ORE, 1, 0), new ItemStack(Blocks.coal_ore, 2), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.MOON_ORE, 1, 1), new ItemStack(Blocks.iron_ore, 2), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.MOON_ORE, 1, 2), new ItemStack(Blocks.gold_ore, 2), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.MOON_ORE, 1, 3), new ItemStack(Blocks.lapis_ore, 2), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.MOON_ORE, 1, 4), new ItemStack(Blocks.redstone_ore, 2), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.MOON_ORE, 1, 5), new ItemStack(Blocks.diamond_ore, 2), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.MOON_ORE, 1, 6), new ItemStack(ModBlocks.OVERWORLD_ORE, 2, 0), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.MOON_ORE, 1, 7), new ItemStack(ModBlocks.OVERWORLD_ORE, 2, 1), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.MOON_ORE, 1, 8), new ItemStack(ModBlocks.OVERWORLD_ORE, 2, 2), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.MOON_ORE, 1, 9), new ItemStack(ModBlocks.OVERWORLD_ORE, 2, 3), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.MOON_ORE, 1, 10), new ItemStack(ModBlocks.OVERWORLD_ORE, 2, 4), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.MOON_ORE, 1, 11), new ItemStack(ModItems.UNOBTANIUM_INGOT), 1.0F);
	}
}
