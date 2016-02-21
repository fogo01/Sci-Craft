package com.fogo01.scicraft.init;

import com.fogo01.scicraft.crafting.MachineRecipes;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipies {
	public static void init(){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.METAL_BLOCK, 1, 0), "III", "III", "III", 'I', "ingotAluminum"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.METAL_BLOCK, 1, 1), "III", "III", "III", 'I', "ingotCopper"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.METAL_BLOCK, 1, 2), "III", "III", "III", 'I', "ingotTin"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.METAL_BLOCK, 1, 3), "III", "III", "III", 'I', "ingotSilver"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.METAL_BLOCK, 1, 4), "III", "III", "III", 'I', "ingotLead"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.METAL_BLOCK, 1, 5),"III", "III", "III", 'I', "ingotBronze"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.METAL_BLOCK, 1, 6),"III", "III", "III", 'I', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.METAL_BLOCK, 1, 7), "III", "III", "III", 'I', "ingotUranium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.METAL_BLOCK, 1, 8),"III", "III", "III", 'I', "ingotUnobtanium"));

        String[] metals = {"Copper", "Tin", "Silver", "Lead", "Bronze", "Steel", "Unobtanium"};
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
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.TIN_ARMOR[1]), "I I", "III", "III", 'I', "ingotTin"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.TIN_ARMOR[2]), "III", "I I", "I I", 'I', "ingotTin"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.TIN_ARMOR[3]), "I I", "I I", 'I', "ingotTin"));
            
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.SILVER_ARMOR[0]), "III", "I I", 'I', "ingotSilver"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.SILVER_ARMOR[1]), "I I", "III", "III", 'I', "ingotSilver"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.SILVER_ARMOR[2]), "III", "I I", "I I", 'I', "ingotSilver"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.SILVER_ARMOR[3]), "I I", "I I", 'I', "ingotSilver"));
        
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.LEAD_ARMOR[0]), "III", "I I", 'I', "ingotLead"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.LEAD_ARMOR[1]), "I I", "III", "III", 'I', "ingotLead"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.LEAD_ARMOR[2]), "III", "I I", "I I", 'I', "ingotLead"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.LEAD_ARMOR[3]), "I I", "I I", 'I', "ingotLead"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.BRONZE_ARMOR[0]), "III", "I I", 'I', "ingotBronze"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.BRONZE_ARMOR[1]), "I I", "III", "III", 'I', "ingotBronze"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.BRONZE_ARMOR[2]), "III", "I I", "I I", 'I', "ingotBronze"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.BRONZE_ARMOR[3]), "I I", "I I", 'I', "ingotBronze"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.STEEL_ARMOR[0]), "III", "I I", 'I', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.STEEL_ARMOR[1]), "I I", "III", "III", 'I', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.STEEL_ARMOR[2]), "III", "I I", "I I", 'I', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.STEEL_ARMOR[3]), "I I", "I I", 'I', "ingotSteel"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.UNOBTANIUM_ARMOR[0]), "III", "I I", 'I', "ingotUnobtanium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.UNOBTANIUM_ARMOR[1]), "I I", "III", "III", 'I', "ingotUnobtanium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.UNOBTANIUM_ARMOR[2]), "III", "I I", "I I", 'I', "ingotUnobtanium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.UNOBTANIUM_ARMOR[3]), "I I", "I I", 'I', "ingotUnobtanium"));


        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.ALUMINUM_INGOT, 9), new ItemStack(ModBlocks.METAL_BLOCK, 1, 0)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.COPPER_INGOT, 9), new ItemStack(ModBlocks.METAL_BLOCK, 1, 1)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.TIN_INGOT, 9), new ItemStack(ModBlocks.METAL_BLOCK, 1, 2)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.SILVER_INGOT, 9), new ItemStack(ModBlocks.METAL_BLOCK, 1, 3)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.LEAD_INGOT, 9), new ItemStack(ModBlocks.METAL_BLOCK, 1, 4)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.BRONZE_INGOT, 9), new ItemStack(ModBlocks.METAL_BLOCK, 1, 5)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.STEEL_INGOT, 9), new ItemStack(ModBlocks.METAL_BLOCK, 1, 6)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.URANIUM_INGOT, 9), new ItemStack(ModBlocks.METAL_BLOCK, 1, 7)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.UNOBTANIUM_INGOT, 9), new ItemStack(ModBlocks.METAL_BLOCK, 1, 8)));

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

        MachineRecipes.CrusherRecipes.crushing().addRecipe(new ItemStack(Blocks.stone), new ItemStack(Blocks.cobblestone));
        MachineRecipes.CrusherRecipes.crushing().addRecipe(new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.gravel));
        MachineRecipes.CrusherRecipes.crushing().addRecipe(new ItemStack(Blocks.gravel), new ItemStack(Blocks.sand));
        MachineRecipes.CrusherRecipes.crushing().addRecipe(new ItemStack(Blocks.sandstone), new ItemStack(Blocks.sand, 4));
        MachineRecipes.CrusherRecipes.crushing().addRecipe(new ItemStack(Blocks.clay), new ItemStack(Items.clay_ball, 4));
        MachineRecipes.CrusherRecipes.crushing().addRecipe(new ItemStack(Blocks.glowstone), new ItemStack(Items.glowstone_dust, 4));

        MachineRecipes.AlloySmelterRecipes.smelting().addRecipe(new ItemStack(ModItems.COPPER_INGOT, 3), new ItemStack(ModItems.TIN_INGOT, 1), new ItemStack(ModItems.BRONZE_INGOT, 4));
        MachineRecipes.AlloySmelterRecipes.smelting().addRecipe(new ItemStack(Items.iron_ingot, 1), new ItemStack(Items.coal, 4), new ItemStack(ModItems.STEEL_INGOT, 1));
	}
}
