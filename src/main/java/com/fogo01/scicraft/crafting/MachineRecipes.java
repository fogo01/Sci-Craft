package com.fogo01.scicraft.crafting;

import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MachineRecipes {

    public static class CrusherRecipes {
        private static final CrusherRecipes crushingBase = new CrusherRecipes();
        private Map crushingList = new HashMap();

        private CrusherRecipes() {

        }
        
        public static CrusherRecipes crushing() {
            return crushingBase;
        }

        public void addRecipe(ItemStack input, ItemStack output) {
            this.crushingList.put(input, output);
        }

        public ItemStack getCrushingResult(ItemStack itemStack) {
            Iterator iterator = this.crushingList.entrySet().iterator();
            Map.Entry entry;

            do {
                if (!iterator.hasNext()) {
                    return null;
                }

                entry = (Map.Entry)iterator.next();
            }
            while (!this.func_151397_a(itemStack, (ItemStack)entry.getKey()));

            return (ItemStack)entry.getValue();
        }

        private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_) {
            return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
        }
    }

    public static class AlloySmelterRecipes {
        private static final AlloySmelterRecipes smeltingBase = new AlloySmelterRecipes();
        private Map smeltingList = new HashMap();

        private AlloySmelterRecipes() {

        }

        public static AlloySmelterRecipes smelting() {
            return smeltingBase;
        }

        public void addRecipe(ItemStack input, ItemStack output) {
            this.smeltingList.put(input, output);
        }

        public ItemStack getSmeltingResult(ItemStack itemStack) {
            Iterator iterator = this.smeltingList.entrySet().iterator();
            Map.Entry entry;

            do {
                if (!iterator.hasNext()) {
                    return null;
                }

                entry = (Map.Entry)iterator.next();
            }
            while (!this.func_151397_a(itemStack, (ItemStack)entry.getKey()));

            return (ItemStack)entry.getValue();
        }

        private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_) {
            return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
        }
    }
}
