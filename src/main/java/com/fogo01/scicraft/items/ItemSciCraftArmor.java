package com.fogo01.scicraft.items;

import com.fogo01.scicraft.crativetab.CreativeTabSciCraft;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemSciCraftArmor extends ItemArmor {
    public ItemSciCraftArmor(ArmorMaterial armorMaterial, int renderIndex, int armorType) {
        super(armorMaterial, renderIndex, armorType);
        this.setCreativeTab(CreativeTabSciCraft.SciCraft_TAB);
    }

    @Override
    public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type) {
        for (int i = 0; i < Names.Items.ARMOR_TYPES.length; i++) {
            if (itemStack.getUnlocalizedName().contains(Names.Items.ARMOR_TYPES[i]))
                return Reference.MOD_ID + ":textures/models/armor/" + Names.Items.ARMOR_TYPES[i] + "_layer_" + (itemStack.getUnlocalizedName().contains("Leggings") ? "2" : "1") + ".png";
        }
        return null;
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
