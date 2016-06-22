package com.fogo01.scicraft.items;

import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import java.util.List;

public class ItemRocketPart extends ItemSciCraft {
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public ItemRocketPart() {
        super();
        this.setUnlocalizedName(Names.Items.ROCKET_PART);
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List list) {
        for (int meta = 0; meta < Names.Items.ROCKET_PARTS.length; meta++)
            list.add(new ItemStack(this, 1, meta));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", Names.Items.ROCKET_PARTS[MathHelper.clamp_int(itemStack.getItemDamage(), 0, Names.Items.ROCKET_PARTS.length - 1)]);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return icons[MathHelper.clamp_int(meta, 0, Names.Items.ROCKET_PARTS.length)];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        icons = new IIcon[Names.Items.ROCKET_PARTS.length];
        for (int i = 0; i < icons.length; i++) {
            icons[i] = iconRegister.registerIcon(Reference.MOD_ID + ":" + Names.Items.ROCKET_PARTS[i]);
        }
    }
}
