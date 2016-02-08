package com.fogo01.scicraft.init;

import com.fogo01.scicraft.items.*;
import com.fogo01.scicraft.items.ItemSciCraft;
import com.fogo01.scicraft.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {
    public static final ItemSciCraft ALUMINUM_INGOT = new ItemAluminumIngot();
    public static final ItemSciCraft COPPER_INGOT = new ItemCopperIngot();
    public static final ItemSciCraft TIN_INGOT = new ItemTinIngot();
    public static final ItemSciCraft STEEL_INGOT = new ItemSteelIngot();

    public static final ItemSciCraftArmor SPACE_HELMET = new ItemSpaceHelmet();
    public static final ItemSciCraftArmor SPACE_CHESTPLATE = new ItemSpaceChestplate();
    public static final ItemSciCraftArmor SPACE_LEGGINGS = new ItemSpaceLeggings();
    public static final ItemSciCraftArmor SPACE_BOOTS = new ItemSpaceBoots();

    public static final ItemSciCraftArmor THOUGH_SPACE_HELMET = new ItemThoughSpaceHelmet();
    public static final ItemSciCraftArmor THOUGH_SPACE_CHESTPLATE = new ItemThoughSpaceChestplate();
    public static final ItemSciCraftArmor THOUGH_SPACE_LEGGINGS = new ItemThoughSpaceLeggings();
    public static final ItemSciCraftArmor THOUGH_SPACE_BOOTS = new ItemThoughSpaceBoots();

    public static void init(){
        GameRegistry.registerItem(ALUMINUM_INGOT, Names.Items.ALUMINUM_INGOT);
        GameRegistry.registerItem(COPPER_INGOT, Names.Items.COPPER_INGOT);
        GameRegistry.registerItem(TIN_INGOT, Names.Items.TIN_INGOT);
        GameRegistry.registerItem(STEEL_INGOT, Names.Items.STEEL_INGOT);

        GameRegistry.registerItem(SPACE_HELMET, Names.Items.SPACE_SUIT[0]);
        GameRegistry.registerItem(SPACE_CHESTPLATE, Names.Items.SPACE_SUIT[1]);
        GameRegistry.registerItem(SPACE_LEGGINGS, Names.Items.SPACE_SUIT[2]);
        GameRegistry.registerItem(SPACE_BOOTS, Names.Items.SPACE_SUIT[3]);

        GameRegistry.registerItem(THOUGH_SPACE_HELMET, Names.Items.THOUGH_SPACE_SUIT[0]);
        GameRegistry.registerItem(THOUGH_SPACE_CHESTPLATE, Names.Items.THOUGH_SPACE_SUIT[1]);
        GameRegistry.registerItem(THOUGH_SPACE_LEGGINGS, Names.Items.THOUGH_SPACE_SUIT[2]);
        GameRegistry.registerItem(THOUGH_SPACE_BOOTS, Names.Items.THOUGH_SPACE_SUIT[3]);
	}
}
