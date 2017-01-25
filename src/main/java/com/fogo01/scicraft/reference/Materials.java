package com.fogo01.scicraft.reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class Materials {
    public static final class Tools {
        public static final Item.ToolMaterial TOOL_COPPER = EnumHelper.addToolMaterial("Copper", 2, 225, 5.0F, 1.0F, 8);
        public static final Item.ToolMaterial TOOL_TIN = EnumHelper.addToolMaterial("Tin", 2, 225, 5.0F, 1.0F, 8);
        public static final Item.ToolMaterial TOOL_SILVER = EnumHelper.addToolMaterial("Silver", 2, 250, 7.0F, 2.0F, 10);
        public static final Item.ToolMaterial TOOL_LEAD = EnumHelper.addToolMaterial("Lead", 2, 250, 7.0F, 2.0F, 10);
        public static final Item.ToolMaterial TOOL_BRONZE = EnumHelper.addToolMaterial("Bronze", 2, 250, 7.0F, 2.0F, 10);
        public static final Item.ToolMaterial TOOL_STEEL = EnumHelper.addToolMaterial("Steel", 3, 500, 7.5F, 2.0F, 14);
        public static final Item.ToolMaterial TOOL_UNOBTANIUM = EnumHelper.addToolMaterial("Unobtanium", 4, 1000, 10.0F, 3.0F, 15);
    }

    public static final class Armor {
        public static final ItemArmor.ArmorMaterial ARMOR_COPPER = EnumHelper.addArmorMaterial("Copper", 10, new int[]{2, 6, 5, 2}, 7);
        public static final ItemArmor.ArmorMaterial ARMOR_TIN = EnumHelper.addArmorMaterial("Tin", 10, new int[]{2, 6, 5, 2}, 7);
        public static final ItemArmor.ArmorMaterial ARMOR_SILVER = EnumHelper.addArmorMaterial("Silver", 15, new int[]{2, 6, 6, 3}, 7);
        public static final ItemArmor.ArmorMaterial ARMOR_LEAD = EnumHelper.addArmorMaterial("Lead", 15, new int[]{2, 6, 6, 3}, 7);
        public static final ItemArmor.ArmorMaterial ARMOR_BRONZE = EnumHelper.addArmorMaterial("Bronze", 15, new int[]{2, 6, 6, 2}, 7);
        public static final ItemArmor.ArmorMaterial ARMOR_STEEL = EnumHelper.addArmorMaterial("Steel", 18, new int[]{2, 6, 6, 3}, 9);
        public static final ItemArmor.ArmorMaterial ARMOR_UNOBTANIUM = EnumHelper.addArmorMaterial("Unobtanium", 20, new int[]{3, 7, 6, 3}, 10);
        public static final ItemArmor.ArmorMaterial ARMOR_SPACESUIT = EnumHelper.addArmorMaterial("SpaceSuit", 5, new int[]{1, 3, 2, 1}, 0);
        public static final ItemArmor.ArmorMaterial ARMOR_THOUGH_SPACESUIT = EnumHelper.addArmorMaterial("ThoughSpaceSuit", 15, new int[]{2, 6, 5, 2}, 0);
        public static final ItemArmor.ArmorMaterial ARMOR_UTILITY = EnumHelper.addArmorMaterial("Utility", 0, new int[]{0, 0, 0, 0}, 0);
    }
}
