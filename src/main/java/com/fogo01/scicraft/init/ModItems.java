package com.fogo01.scicraft.init;

import com.fogo01.scicraft.items.*;
import com.fogo01.scicraft.items.ItemSciCraft;
import com.fogo01.scicraft.items.armors.copper.*;
import com.fogo01.scicraft.items.armors.tin.*;
import com.fogo01.scicraft.items.armors.silver.*;
import com.fogo01.scicraft.items.armors.lead.*;
import com.fogo01.scicraft.items.armors.bronze.*;
import com.fogo01.scicraft.items.armors.steel.*;
import com.fogo01.scicraft.items.armors.unobtanium.*;
import com.fogo01.scicraft.items.armors.spaceSuit.*;
import com.fogo01.scicraft.items.armors.thoughSpaceSuit.*;
import com.fogo01.scicraft.items.buckets.*;
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

    public static final ItemSciCraft WRENCH = new ItemWrench();
    public static final ItemSciCraft MULTIMETER = new ItemMultimeter();

    public static final ItemSciCraft BATTERY = new ItemBattery();
    public static final ItemSciCraft MEDIUM_BATTERY = new ItemMediumBattery();

    public static final ItemSciCraftBucket OIL_BUCKET = new ItemOilBucket();
    public static final ItemSciCraftBucket FUEL_BUCKET = new ItemFuelBucket();

    public static final ItemSciCraftSword[] SWORDS = {new ItemCopperSword(), new ItemTinSword(), new ItemSilverSword(), new ItemLeadSword(), new ItemBronzeSword(), new ItemSteelSword(), new ItemUnobtaniumSword()};
    public static final ItemSciCraftPickaxe[] PICKAXES = {new ItemCopperPickaxe(), new ItemTinPickaxe(), new ItemSilverPickaxe(), new ItemLeadPickaxe(), new ItemBronzePickaxe(), new ItemSteelPickaxe(), new ItemUnobtaniumPickaxe()};
    public static final ItemSciCraftShovel[] SHOVELS = {new ItemCopperShovel(), new ItemTinShovel(), new ItemSilverShovel(), new ItemLeadShovel(), new ItemBronzeShovel(), new ItemSteelShovel(), new ItemUnobtaniumShovel()};
    public static final ItemSciCraftAxe[] AXES = {new ItemCopperAxe(), new ItemTinAxe(), new ItemSilverAxe(), new ItemLeadAxe(), new ItemBronzeAxe(), new ItemSteelAxe(), new ItemUnobtaniumAxe()};
    public static final ItemSciCraftHoe[] HOES = {new ItemCopperHoe(), new ItemTinHoe(), new ItemSilverHoe(), new ItemLeadHoe(), new ItemBronzeHoe(), new ItemSteelHoe(), new ItemUnobtaniumHoe()};

    public static final ItemSciCraftArmor[] COPPER_ARMOR = {new ItemCopperHelmet(), new ItemCopperChestplate(), new ItemCopperLeggings(), new ItemCopperBoots()};
    public static final ItemSciCraftArmor[] TIN_ARMOR = {new ItemTinHelmet(), new ItemTinChestplate(), new ItemTinLeggings(), new ItemTinBoots()};
    public static final ItemSciCraftArmor[] SILVER_ARMOR = {new ItemSilverHelmet(), new ItemSilverChestplate(), new ItemSilverLeggings(), new ItemSilverBoots()};
    public static final ItemSciCraftArmor[] LEAD_ARMOR = {new ItemLeadHelmet(), new ItemLeadChestplate(), new ItemLeadLeggings(), new ItemLeadBoots()};
    public static final ItemSciCraftArmor[] BRONZE_ARMOR = {new ItemBronzeHelmet(), new ItemBronzeChestplate(), new ItemBronzeLeggings(), new ItemBronzeBoots()};
    public static final ItemSciCraftArmor[] STEEL_ARMOR = {new ItemSteelHelmet(), new ItemSteelChestplate(), new ItemSteelLeggings(), new ItemSteelBoots()};
    public static final ItemSciCraftArmor[] UNOBTANIUM_ARMOR = {new ItemUnobtaniumHelmet(), new ItemUnobtaniumChestplate(), new ItemUnobtaniumLeggings(), new ItemUnobtaniumBoots()};
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

        GameRegistry.registerItem(WRENCH, Names.Items.WRENCH);
        GameRegistry.registerItem(MULTIMETER, Names.Items.MULTIMETER);

        GameRegistry.registerItem(BATTERY, Names.Items.BATTERY);
        GameRegistry.registerItem(MEDIUM_BATTERY, Names.Items.MEDIUM_BATTERY);

        GameRegistry.registerItem(OIL_BUCKET, Names.Items.OIL_BUCKET);
        GameRegistry.registerItem(FUEL_BUCKET, Names.Items.FUEL_BUCKET);

        for (int i = 0; i < SWORDS.length; i++) {
            GameRegistry.registerItem(SWORDS[i], Names.Items.SWORDS[i]);
            GameRegistry.registerItem(PICKAXES[i], Names.Items.PICKAXES[i]);
            GameRegistry.registerItem(SHOVELS[i], Names.Items.SHOVELS[i]);
            GameRegistry.registerItem(AXES[i], Names.Items.AXES[i]);
            GameRegistry.registerItem(HOES[i], Names.Items.HOES[i]);
        }


        for (int i = 0; i < COPPER_ARMOR.length; i++)
            GameRegistry.registerItem(COPPER_ARMOR[i], Names.Items.COPPER_ARMOR[i]);
        for (int i = 0; i < TIN_ARMOR.length; i++)
            GameRegistry.registerItem(TIN_ARMOR[i], Names.Items.TIN_ARMOR[i]);
        for (int i = 0; i < SILVER_ARMOR.length; i++)
            GameRegistry.registerItem(SILVER_ARMOR[i], Names.Items.SILVER_ARMOR[i]);
        for (int i = 0; i < LEAD_ARMOR.length; i++)
            GameRegistry.registerItem(LEAD_ARMOR[i], Names.Items.LEAD_ARMOR[i]);
        for (int i = 0; i < BRONZE_ARMOR.length; i++)
            GameRegistry.registerItem(BRONZE_ARMOR[i], Names.Items.BRONZE_ARMOR[i]);
        for (int i = 0; i < STEEL_ARMOR.length; i++)
            GameRegistry.registerItem(STEEL_ARMOR[i], Names.Items.STEEL_ARMOR[i]);
        for (int i = 0; i < UNOBTANIUM_ARMOR.length; i++)
            GameRegistry.registerItem(UNOBTANIUM_ARMOR[i], Names.Items.UNOBTANIUM_ARMOR[i]);
        for (int i = 0; i < SPACE_SUIT.length; i++)
            GameRegistry.registerItem(SPACE_SUIT[i], Names.Items.SPACE_SUIT[i]);
        for (int i = 0; i < THOUGH_SPACE_SUIT.length; i++)
            GameRegistry.registerItem(THOUGH_SPACE_SUIT[i], Names.Items.THOUGH_SPACE_SUIT[i]);

	}
}
