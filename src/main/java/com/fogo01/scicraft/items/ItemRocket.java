package com.fogo01.scicraft.items;

import com.fogo01.scicraft.entities.rockets.EntityRocket;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;

public class ItemRocket extends ItemSciCraft {
    @SideOnly(Side.CLIENT)
    private IIcon[] icons = new IIcon[243];


    public ItemRocket(){
        super();
        this.setUnlocalizedName(Names.Items.ROCKET);
        this.setMaxStackSize(1);
    }

    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        itemStack.stackTagCompound = new NBTTagCompound();
        itemStack.stackTagCompound.setIntArray("rocketParts", new int[5]);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        MovingObjectPosition movingObjectPosition = player.rayTrace(8D, 1.0f);

        EntityRocket entityRocket = new EntityRocket(world, movingObjectPosition.blockX, movingObjectPosition.blockY, movingObjectPosition.blockZ);

        int[] rocketParts = itemStack.stackTagCompound.getIntArray("rocketParts");
        entityRocket.setParts(rocketParts[0], rocketParts[1], rocketParts[2], rocketParts[3], rocketParts[4]);

        if (!world.isRemote)
            world.spawnEntityInWorld(entityRocket);

        return itemStack;
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        if (GuiScreen.isShiftKeyDown()) {
            if (itemStack.stackTagCompound == null)
                return;

            int[] rocketParts = itemStack.stackTagCompound.getIntArray("rocketParts");

            list.add("Nose Cone " + (rocketParts[0] == 3 ? EnumChatFormatting.GREEN : rocketParts[0] == 2 ? EnumChatFormatting.AQUA : EnumChatFormatting.GOLD) + "T" + rocketParts[0]);
            list.add("Fuselage " + (rocketParts[1] == 3 ? EnumChatFormatting.GREEN : rocketParts[1] == 2 ? EnumChatFormatting.AQUA : EnumChatFormatting.GOLD) + "T" + rocketParts[1]);
            list.add("Engine " + (rocketParts[2] == 3 ? EnumChatFormatting.GREEN : rocketParts[2] == 2 ? EnumChatFormatting.AQUA : EnumChatFormatting.GOLD) + "T" + rocketParts[2]);
            list.add("Fins " + (rocketParts[3] == 3 ? EnumChatFormatting.GREEN : rocketParts[3] == 2 ? EnumChatFormatting.AQUA : EnumChatFormatting.GOLD) + "T" + rocketParts[3]);
            list.add("Booster " + (rocketParts[4] == 3 ? EnumChatFormatting.GREEN : rocketParts[4] == 2 ? EnumChatFormatting.AQUA : EnumChatFormatting.GOLD) + "T" + rocketParts[4]);
        } else {
            list.add("<Press SHIFT>");
        }
    }

    public void setRocketParts(ItemStack itemStack, int noseCone, int fuselage, int engine, int fin, int booster) {
        if (itemStack.stackTagCompound == null)
            itemStack.stackTagCompound = new NBTTagCompound();
        itemStack.stackTagCompound.setIntArray("rocketParts", new int[] {noseCone, fuselage, engine, fin, booster});
    }

    @Override
    public IIcon getIcon(ItemStack itemStack, int pass) {
        if (itemStack.stackTagCompound == null)
            return icons[0];
        int[] rocketParts = itemStack.stackTagCompound.getIntArray("rocketParts");
        return icons[(rocketParts[0] - 1) * 81 + (rocketParts[1] - 1) * 27 + (rocketParts[2] - 1) * 9 + (rocketParts[3] - 1) * 3 + (rocketParts[4] - 1)];
    }

    @Override
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        for (int noseCone = 1; noseCone <= 3; noseCone++)
            for (int fuselage = 1; fuselage <= 3; fuselage++)
                for (int engine = 1; engine <= 3; engine++)
                    for (int fin = 1; fin <= 3; fin++)
                        for (int booster = 1; booster <= 3; booster++)
                            icons[(noseCone - 1) * 81 + (fuselage - 1) * 27 + (engine - 1) * 9 + (fin - 1) * 3 + (booster - 1)] = iconRegister.registerIcon(String.format("%s%s%s%s%s%s", Reference.MOD_ID.toLowerCase() + ":rockets/Rocket", "" + noseCone, "" + fuselage, "" + engine, "" + fin, "" + booster));
    }
}
