package com.fogo01.scicraft.init;

import com.fogo01.scicraft.items.*;
import com.fogo01.scicraft.items.ItemSciCraft;
import com.fogo01.scicraft.items.armors.copper.*;
import com.fogo01.scicraft.items.armors.tin.*;
import com.fogo01.scicraft.items.armors.bronze.*;
import com.fogo01.scicraft.items.armors.steel.*;
import com.fogo01.scicraft.items.armors.spaceSuit.*;
import com.fogo01.scicraft.items.armors.thoughSpaceSuit.*;
import com.fogo01.scicraft.items.swords.*;
import com.fogo01.scicraft.items.pickaxes.*;
import com.fogo01.scicraft.items.shovels.*;
import com.fogo01.scicraft.items.axes.*;
import com.fogo01.scicraft.items.hoes.*;
import com.fogo01.scicraft.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {
    public static final ItemSciCraft ALUMINUM_INGOT = new ItemAluminumIngot();
    public static final ItemSciCraft COPPER_INGOT = new ItemCopperIngot();
    public static final ItemSciCraft TIN_INGOT = new ItemTinIngot();
    public static final ItemSciCraft SILVER_INGOT = new ItemSilverIngot();
    public static final ItemSciCraft LEAD_INGOT = new ItemLeadIngot();
    public static final ItemSciCraft URANIUM_INGOT = new ItemUraniumIngot();
    public static final ItemSciCraft BRONZE_INGOT = new ItemBronzeIngot();
    public static final ItemSciCraft STEEL_INGOT = new ItemSteelIngot();
    public static final ItemSciCraft UNOBTANIUM_INGOT = new ItemUnobtaniumIngot();

    public static final ItemSciCraftSword[] SWORDS = {new ItemCopperSword(), new ItemTinSword(), new ItemBronzeSword(), new ItemSteelSword()};
    public static final ItemSciCraftPickaxe[] PICKAXES = {new ItemCopperPickaxe(), new ItemTinPickaxe(), new ItemBronzePickaxe(), new ItemSteelPickaxe()};
    public static final ItemSciCraftShovel[] SHOVELS = {new ItemCopperShovel(), new ItemTinShovel(), new ItemBronzeShovel(), new ItemSteelShovel()};
    public static final ItemSciCraftAxe[] AXES = {new ItemCopperAxe(), new ItemTinAxe(), new ItemBronzeAxe(), new ItemSteelAxe()};
    public static final ItemSciCraftHoe[] HOES = {new ItemCopperHoe(), new ItemTinHoe(), new ItemBronzeHoe(), new ItemSteelHoe()};

    public static final ItemSciCraftArmor[] COPPER_ARMOR = {new ItemCopperHelmet(), new ItemCopperChestplate(), new ItemCopperLeggings(), new ItemCopperBoots()};

    public static final ItemSciCraftArmor[] TIN_ARMOR = {new ItemTinHelmet(), new ItemTinChestplate(), new ItemTinLeggings(), new ItemTinBoots()};

    public static final ItemSciCraftArmor[] BRONZE_ARMOR = {new ItemBronzeHelmet(), new ItemBronzeChestplate(), new ItemBronzeLeggings(), new ItemBronzeBoots()};

    public static final ItemSciCraftArmor[] STEEL_ARMOR = {new ItemSteelHelmet(), new ItemSteelChestplate(), new ItemSteelLeggings(), new ItemSteelBoots()};

    public static final ItemSciCraftArmor[] SPACE_SUIT = {new ItemSpaceHelmet(), new ItemSpaceChestplate(), new ItemSpaceLeggings(), new ItemSpaceBoots()};

    public static final ItemSciCraftArmor[] THOUGH_SPACE_SUIT = {new ItemThoughSpaceHelmet(), new ItemThoughSpaceChestplate(), new ItemThoughSpaceLeggings(), new ItemThoughSpaceBoots()};

    public static void init(){
        GameRegistry.registerItem(ALUMINUM_INGOT, Names.Items.ALUMINUM_INGOT);
        GameRegistry.registerItem(COPPER_INGOT, Names.Items.COPPER_INGOT);
        GameRegistry.registerItem(TIN_INGOT, Names.Items.TIN_INGOT);
        GameRegistry.registerItem(SILVER_INGOT, Names.Items.SILVER_INGOT);
        GameRegistry.registerItem(LEAD_INGOT, Names.Items.LEAD_INGOT);
        GameRegistry.registerItem(URANIUM_INGOT, Names.Items.URANIUM_INGOT);
        GameRegistry.registerItem(BRONZE_INGOT, Names.Items.BRONZE_INGOT);
        GameRegistry.registerItem(STEEL_INGOT, Names.Items.STEEL_INGOT);
        GameRegistry.registerItem(UNOBTANIUM_INGOT, Names.Items.UNOBTANIUM_INGOT);

        for (int i = 0; i < SWORDS.length; i++)
            GameRegistry.registerItem(SWORDS[i], Names.Items.SWORDS[i]);
        for (int i = 0; i < PICKAXES.length; i++)
            GameRegistry.registerItem(PICKAXES[i], Names.Items.PICKAXES[i]);
        for (int i = 0; i < SHOVELS.length; i++)
            GameRegistry.registerItem(SHOVELS[i], Names.Items.SHOVELS[i]);
        for (int i = 0; i < AXES.length; i++)
            GameRegistry.registerItem(AXES[i], Names.Items.AXES[i]);
        for (int i = 0; i < HOES.length; i++)
            GameRegistry.registerItem(HOES[i], Names.Items.HOES[i]);


        for (int i = 0; i < COPPER_ARMOR.length; i++)
            GameRegistry.registerItem(COPPER_ARMOR[i], Names.Items.COPPER_ARMOR[i]);
        for (int i = 0; i < TIN_ARMOR.length; i++)
            GameRegistry.registerItem(TIN_ARMOR[i], Names.Items.TIN_ARMOR[i]);
        for (int i = 0; i < BRONZE_ARMOR.length; i++)
            GameRegistry.registerItem(BRONZE_ARMOR[i], Names.Items.BRONZE_ARMOR[i]);
        for (int i = 0; i < STEEL_ARMOR.length; i++)
            GameRegistry.registerItem(STEEL_ARMOR[i], Names.Items.STEEL_ARMOR[i]);
        for (int i = 0; i < SPACE_SUIT.length; i++)
            GameRegistry.registerItem(SPACE_SUIT[i], Names.Items.SPACE_SUIT[i]);
        for (int i = 0; i < THOUGH_SPACE_SUIT.length; i++)
            GameRegistry.registerItem(THOUGH_SPACE_SUIT[i], Names.Items.THOUGH_SPACE_SUIT[i]);

	}
}
