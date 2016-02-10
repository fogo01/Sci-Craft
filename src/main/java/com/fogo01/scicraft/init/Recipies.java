package com.fogo01.scicraft.init;

import com.fogo01.scicraft.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipies {
	public static void init(){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.ALUMINUM_BLOCK), "III", "III", "III", 'I', "ingotAluminum"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.COPPER_BLOCK), "III", "III", "III", 'I', "ingotCopper"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.TIN_BLOCK), "III", "III", "III", 'I', "ingotTin"));

        String[] metals = {"Copper", "Tin", "Bronze", "Steel"};
        for (int i = 0; i < ModItems.SWORDS.length; i++)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.SWORDS[i]), "I", "I", "S", 'I', "ingot" + metals[i], 'S', "stickWood"));
        for (int i = 0; i < ModItems.PICKAXES.length; i++)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.PICKAXES[i]), "III", " S ", " S ", 'I', "ingot" + metals[i], 'S', "stickWood"));
        for (int i = 0; i < ModItems.SHOVELS.length; i++)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.SHOVELS[i]), "I", "S", "S", 'I', "ingot" + metals[i], 'S', "stickWood"));
        for (int i = 0; i < ModItems.AXES.length; i++)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.AXES[i]), "II", "IS", " S", 'I', "ingot" + metals[i], 'S', "stickWood"));
        for (int i = 0; i < ModItems.HOES.length; i++)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.HOES[i]), "II", " S", " S", 'I', "ingot" + metals[i], 'S', "stickWood"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.COPPER_ARMOR[0]), "III", "I I", 'I', "ingotCopper"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.COPPER_ARMOR[1]), "I I", "III", "III", 'I', "ingotCopper"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.COPPER_ARMOR[2]), "III", "I I", "I I", 'I', "ingotCopper"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.COPPER_ARMOR[3]), "I I", "I I", 'I', "ingotCopper"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.TIN_ARMOR[0]), "III", "I I", 'I', "ingotTin"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.TIN_ARMOR[1]), "I I", "III", "III", 'I', "ingotCopper"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.TIN_ARMOR[2]), "III", "I I", "I I", 'I', "ingotCopper"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.TIN_ARMOR[3]), "I I", "I I", 'I', "ingotCopper"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.BRONZE_ARMOR[0]), "III", "I I", 'I', "ingotBronze"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.BRONZE_ARMOR[1]), "I I", "III", "III", 'I', "ingotBronze"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.BRONZE_ARMOR[2]), "III", "I I", "I I", 'I', "ingotBronze"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.BRONZE_ARMOR[3]), "I I", "I I", 'I', "ingotBronze"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.STEEL_ARMOR[0]), "III", "I I", 'I', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.STEEL_ARMOR[1]), "I I", "III", "III", 'I', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.STEEL_ARMOR[2]), "III", "I I", "I I", 'I', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.STEEL_ARMOR[3]), "I I", "I I", 'I', "ingotSteel"));

        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.ALUMINUM_INGOT, 9), ModBlocks.ALUMINUM_BLOCK));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.COPPER_INGOT, 9), ModBlocks.COPPER_BLOCK));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.TIN_INGOT, 9), ModBlocks.TIN_BLOCK));


        GameRegistry.addSmelting(ModBlocks.ALUMINUM_ORE, new ItemStack(ModItems.ALUMINUM_INGOT), 0.8F);
        GameRegistry.addSmelting(ModBlocks.COPPER_ORE, new ItemStack(ModItems.COPPER_INGOT), 0.4F);
        GameRegistry.addSmelting(ModBlocks.TIN_ORE, new ItemStack(ModItems.TIN_INGOT), 0.4F);

        GameRegistry.addSmelting(new ItemStack(ModBlocks.MOON_ORE, 1, 0), new ItemStack(ModBlocks.ALUMINUM_ORE), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.MOON_ORE, 1, 1), new ItemStack(ModBlocks.COPPER_ORE), 0.0F);
        GameRegistry.addSmelting(new ItemStack(ModBlocks.MOON_ORE, 1, 2), new ItemStack(ModBlocks.TIN_ORE), 0.0F);
	}
}
