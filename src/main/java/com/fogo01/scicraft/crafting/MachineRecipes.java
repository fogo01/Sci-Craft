package com.fogo01.scicraft.crafting;

import net.minecraft.item.ItemStack;

import java.util.*;

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
        private List<ItemStack[]> recipes = new ArrayList<ItemStack[]>();

        public static AlloySmelterRecipes smelting() {
            return smeltingBase;
        }

        public void addRecipe(ItemStack input1, ItemStack input2, ItemStack output) {
            recipes.add(new ItemStack[]{input1, input2, output});
        }

        public ItemStack getSmeltingResult(ItemStack itemStack1, ItemStack itemStack2){
            return getOutput(itemStack1, itemStack2);
        }

        public int[] getDecreaseAmount(ItemStack itemStack1, ItemStack itemStack2) {
            ItemStack[][] recipe = new ItemStack[recipes.size()][3];
            recipes.toArray(recipe);

            for (int i = 0; i < recipe.length; i++) {
                if (itemStack1.isItemEqual(recipe[i][0]) && itemStack2.isItemEqual(recipe[i][1])) {
                    return new int[]{recipe[i][0].stackSize, recipe[i][1].stackSize};
                }
                if (itemStack1.isItemEqual(recipe[i][1]) && itemStack2.isItemEqual(recipe[i][0])) {
                    return new int[]{recipe[i][1].stackSize, recipe[i][0].stackSize};
                }
            }
            return new int[]{1, 1};
        }
        
        private ItemStack getOutput(ItemStack itemStack1, ItemStack itemStack2) {
            ItemStack[][] recipe = new ItemStack[recipes.size()][3];
            recipes.toArray(recipe);

            for (int i = 0; i < recipe.length; i++) {
                if (itemStack1.isItemEqual(recipe[i][0]) && itemStack2.isItemEqual(recipe[i][1])) {
                    if (itemStack1.stackSize >= recipe[i][0].stackSize && itemStack2.stackSize >= recipe[i][1].stackSize)
                        return recipe[i][2];
                }
                if (itemStack1.isItemEqual(recipe[i][1]) && itemStack2.isItemEqual(recipe[i][0])) {
                    if (itemStack1.stackSize >= recipe[i][1].stackSize && itemStack2.stackSize >= recipe[i][0].stackSize)
                        return recipe[i][2];
                }
            }
            return null;
        }
    }

    public static class CentrifugeRecipes {
        private static final CentrifugeRecipes centrifugingBase = new CentrifugeRecipes();
        private List<ItemStack[]> recipes = new ArrayList<ItemStack[]>();
        private List<Float> chances = new ArrayList<Float>();

        public static CentrifugeRecipes centrifuging() {
            return centrifugingBase;
        }

        public void addRecipe(ItemStack input, ItemStack mainOutput, ItemStack rareOutput, float chance) {
            recipes.add(new ItemStack[]{input, mainOutput, rareOutput});
            chances.add(chance);
        }

        public ItemStack[] getCentrifugingResult(ItemStack input){
            return getOutput(input);
        }

        public float getChance (ItemStack input) {
            ItemStack[][] recipe = new ItemStack[recipes.size()][3];
            recipes.toArray(recipe);

            for (int i = 0; i < recipe.length; i++) {
                if (input.isItemEqual(recipe[i][0])) {
                       return chances.get(i);
                }
            }
            return 0F;
        }

        private ItemStack[] getOutput(ItemStack input) {
            ItemStack[][] recipe = new ItemStack[recipes.size()][3];
            recipes.toArray(recipe);

            for (int i = 0; i < recipe.length; i++) {
                if (input.isItemEqual(recipe[i][0])) {
                    if (input.stackSize >= recipe[i][0].stackSize)
                        return new ItemStack[]{recipe[i][1], recipe[i][2]};
                }
            }
            return null;
        }
    }
}
