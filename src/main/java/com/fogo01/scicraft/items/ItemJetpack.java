package com.fogo01.scicraft.items;

import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

public class ItemJetpack extends ItemSciCraftArmor {
    public ItemJetpack() {
        super(Materials.Armor.ARMOR_UTILITY, 1, 1);
        this.setUnlocalizedName(Names.Items.JETPACK);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if(Keyboard.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindJump.getKeyCode())) {
            if (player.isSneaking())
                player.addVelocity(0, player.motionY < -0.15F ? 0.15F : -player.motionY, 0);
            else if (player.motionY < 0.5F)
                player.addVelocity(0F, 0.15F, 0F);
            player.fallDistance = 0;

            for (int i = 0; i < 10; i++) {
                world.spawnParticle("smoke", player.posX + (-MathHelper.sin(-player.renderYawOffset * ((float)Math.PI / 180)) * 0.2), player.posY - 0.5, player.posZ + (-MathHelper.cos(-player.renderYawOffset * ((float)Math.PI / 180)) * 0.2), (-MathHelper.sin(-player.renderYawOffset * ((float)Math.PI / 180))) / 5 + (Math.random() - 0.5) / 7.5, -1, (-MathHelper.cos(-player.renderYawOffset * ((float)Math.PI / 180))) / 5 + (Math.random() - 0.5) / 7.5);
                world.spawnParticle("flame", player.posX + (-MathHelper.sin(-player.renderYawOffset * ((float)Math.PI / 180)) * 0.2) + (-MathHelper.sin((-player.renderYawOffset - 90) * ((float)Math.PI / 180)) * 0.2), player.posY - 0.5, player.posZ + (-MathHelper.cos(-player.renderYawOffset * ((float)Math.PI / 180)) * 0.2) + (-MathHelper.cos((-player.renderYawOffset - 90) * ((float)Math.PI / 180)) * 0.2), (-MathHelper.sin(-player.renderYawOffset * ((float)Math.PI / 180))) / 5 + (Math.random() - 0.5) / 10, -1, (-MathHelper.cos(-player.renderYawOffset * ((float)Math.PI / 180))) / 5 + (Math.random() - 0.5) / 10);
                world.spawnParticle("flame", player.posX + (-MathHelper.sin(-player.renderYawOffset * ((float)Math.PI / 180)) * 0.2) + (-MathHelper.sin((-player.renderYawOffset + 90) * ((float)Math.PI / 180)) * 0.2), player.posY - 0.5, player.posZ + (-MathHelper.cos(-player.renderYawOffset * ((float)Math.PI / 180)) * 0.2) + (-MathHelper.cos((-player.renderYawOffset + 90) * ((float)Math.PI / 180)) * 0.2), (-MathHelper.sin(-player.renderYawOffset * ((float)Math.PI / 180))) / 5 + (Math.random() - 0.5) / 10, -1, (-MathHelper.cos(-player.renderYawOffset * ((float)Math.PI / 180))) / 5 + (Math.random() - 0.5) / 10);
            }
        }
    }
}
