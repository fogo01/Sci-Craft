package com.fogo01.scicraft.crativetab;

import com.fogo01.scicraft.init.ModItems;
import com.fogo01.scicraft.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabSciCraft {
	public static final CreativeTabs SciCraft_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
		@Override
		public Item getTabIconItem() {
			return ModItems.ALUMINUM_INGOT;
		}
	};
}
