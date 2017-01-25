package com.fogo01.scicraft.Potions;

import net.minecraft.potion.Potion;

public class PotionSciCraft extends Potion {
    protected PotionSciCraft(int id, boolean isNegative, int color) {
        super(id, isNegative, color);
    }

    @Override
    public Potion setPotionName(String name) {
        return super.setPotionName("potion." + name);
    }
}
