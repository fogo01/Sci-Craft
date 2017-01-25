package com.fogo01.scicraft.Potions;

import com.fogo01.scicraft.reference.Names;

public class PotionRadiation extends PotionSciCraft {
    public PotionRadiation() {
        super(31, true, 0x00ff00);
        this.setPotionName(Names.Potions.RADIATION);
        this.setIconIndex(6, 0);
    }
}
