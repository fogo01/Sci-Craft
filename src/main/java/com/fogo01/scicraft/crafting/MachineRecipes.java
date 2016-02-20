package com.fogo01.scicraft.crafting;

import com.fogo01.scicraft.init.ModItems;
import net.minecraft.init.Items;
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
        private static ItemStack[][] recipes = new ItemStack[][]{
                {new ItemStack(ModItems.COPPER_INGOT, 3), new ItemStack(ModItems.TIN_INGOT, 1), new ItemStack(ModItems.BRONZE_INGOT, 4)},
                {new ItemStack(Items.iron_ingot, 1), new ItemStack(Items.coal, 4), new ItemStack(ModItems.STEEL_INGOT, 1)}
        };

        public static ItemStack getSmeltingResult(ItemStack itemStack1, ItemStack itemStack2){
            return getOutput(itemStack1, itemStack2);
        }

        public static int[] getDecreaseAmount(ItemStack itemStack1, ItemStack itemStack2) {
            for (int i = 0; i < recipes.length; i++) {
                if (itemStack1.isItemEqual(recipes[i][0]) && itemStack2.isItemEqual(recipes[i][1])) {
                    return new int[]{recipes[i][0].stackSize, recipes[i][1].stackSize};
                }
                if (itemStack1.isItemEqual(recipes[i][1]) && itemStack2.isItemEqual(recipes[i][0])) {
                    return new int[]{recipes[i][1].stackSize, recipes[i][0].stackSize};
                }
            }
            return new int[]{1, 1};
        }
        
        private static ItemStack getOutput(ItemStack itemStack1, ItemStack itemStack2) {
            for (int i = 0; i < recipes.length; i++) {
                if (itemStack1.isItemEqual(recipes[i][0]) && itemStack2.isItemEqual(recipes[i][1])) {
                    if (itemStack1.stackSize >= recipes[i][0].stackSize && itemStack2.stackSize >= recipes[i][1].stackSize)
                        return recipes[i][2];
                }
                if (itemStack1.isItemEqual(recipes[i][1]) && itemStack2.isItemEqual(recipes[i][0])) {
                    if (itemStack1.stackSize >= recipes[i][1].stackSize && itemStack2.stackSize >= recipes[i][0].stackSize)
                        return recipes[i][2];
                }
            }
            return null;
        }
    }
}
