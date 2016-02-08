package com.fogo01.scicraft.reference;

import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class Materials {
    public static ItemArmor.ArmorMaterial ARMOR_SPACESUIT = EnumHelper.addArmorMaterial("SpaceSuit", 5, new int[] {1, 3, 2, 1}, 0);
    public static ItemArmor.ArmorMaterial ARMOR_THOUGH_SPACESUIT = EnumHelper.addArmorMaterial("ThoughSpaceSuit", 15, new int[] {2, 6, 5, 2}, 0);
}
