package com.fogo01.scicraft.reference;

import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class Materials {
    public static ItemArmor.ArmorMaterial ARMOR_COPPER = EnumHelper.addArmorMaterial("SpaceSuit", 10, new int[] {2, 6, 5, 2}, 7);
    public static ItemArmor.ArmorMaterial ARMOR_TIN = EnumHelper.addArmorMaterial("SpaceSuit", 10, new int[] {2, 6, 5, 2}, 7);
    public static ItemArmor.ArmorMaterial ARMOR_STEEL = EnumHelper.addArmorMaterial("SpaceSuit", 18, new int[] {2, 6, 6, 3}, 9);
    public static ItemArmor.ArmorMaterial ARMOR_BRONZE = EnumHelper.addArmorMaterial("SpaceSuit", 15, new int[] {2, 6, 6, 2}, 7);
    public static ItemArmor.ArmorMaterial ARMOR_SPACESUIT = EnumHelper.addArmorMaterial("SpaceSuit", 5, new int[] {1, 3, 2, 1}, 0);
    public static ItemArmor.ArmorMaterial ARMOR_THOUGH_SPACESUIT = EnumHelper.addArmorMaterial("ThoughSpaceSuit", 15, new int[] {2, 6, 5, 2}, 0);
}
