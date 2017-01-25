package com.fogo01.scicraft.items;

import com.fogo01.scicraft.models.ModelJetpack;
import com.fogo01.scicraft.models.ModelSpaceSuitHelmet;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

public class ItemJetpack extends ItemSciCraftArmor {
    public ItemJetpack() {
        super(Materials.Armor.ARMOR_UTILITY, 1, 1);
        this.setUnlocalizedName(Names.Items.JETPACK);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {

        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/models/armor/Jetpack.png"));
        ModelBiped armorModel = new ModelJetpack();


        if(armorModel != null) {
            armorModel.bipedHead.showModel = armorSlot == 0;
            armorModel.bipedHeadwear.showModel = false;
            armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
            armorModel.bipedRightArm.showModel = armorSlot == 1;
            armorModel.bipedLeftArm.showModel = armorSlot == 1;
            armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
            armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;

            armorModel.isSneak = entityLiving.isSneaking();
            armorModel.isRiding = entityLiving.isRiding();
            armorModel.isChild = entityLiving.isChild();

            armorModel.heldItemRight = 0;
            armorModel.aimedBow = false;

            EntityPlayer player = (EntityPlayer)entityLiving;

            ItemStack held_item = player.getEquipmentInSlot(0);

            if (held_item != null) {
                armorModel.heldItemRight = 1;

                if (player.getItemInUseCount() > 0) {

                    EnumAction enumaction = held_item.getItemUseAction();

                    if (enumaction == EnumAction.bow) {
                        armorModel.aimedBow = true;
                    } else if (enumaction == EnumAction.block) {
                        armorModel.heldItemRight = 3;
                    }


                }

            }
        }

        return armorModel;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return Reference.MOD_ID + ":textures/models/armor/Utility_layer_1.png";
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if(Keyboard.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindJump.getKeyCode())) {
            if (player.isSneaking())
                player.addVelocity(0, player.motionY < -0.15F ? 0.15F : -player.motionY, 0);
            else if (player.motionY < 0.5F)
                player.addVelocity(0F, 0.15F, 0F);
            player.fallDistance = 0;

            if (!player.isSneaking()) {
                for (int i = 0; i < 10; i++) {
                    world.spawnParticle("smoke", player.posX + (-MathHelper.sin(-player.renderYawOffset * ((float) Math.PI / 180)) * 0.2), player.posY - 0.5, player.posZ + (-MathHelper.cos(-player.renderYawOffset * ((float) Math.PI / 180)) * 0.2), (-MathHelper.sin(-player.renderYawOffset * ((float) Math.PI / 180))) / 5 + (Math.random() - 0.5) / 7.5, -1, (-MathHelper.cos(-player.renderYawOffset * ((float) Math.PI / 180))) / 5 + (Math.random() - 0.5) / 7.5);
                    world.spawnParticle("flame", player.posX + (-MathHelper.sin(-player.renderYawOffset * ((float) Math.PI / 180)) * 0.2) + (-MathHelper.sin((-player.renderYawOffset - 90) * ((float) Math.PI / 180)) * 0.2), player.posY - 0.5, player.posZ + (-MathHelper.cos(-player.renderYawOffset * ((float) Math.PI / 180)) * 0.2) + (-MathHelper.cos((-player.renderYawOffset - 90) * ((float) Math.PI / 180)) * 0.2), (-MathHelper.sin(-player.renderYawOffset * ((float) Math.PI / 180))) / 5 + (Math.random() - 0.5) / 10, -1, (-MathHelper.cos(-player.renderYawOffset * ((float) Math.PI / 180))) / 5 + (Math.random() - 0.5) / 10);
                    world.spawnParticle("flame", player.posX + (-MathHelper.sin(-player.renderYawOffset * ((float) Math.PI / 180)) * 0.2) + (-MathHelper.sin((-player.renderYawOffset + 90) * ((float) Math.PI / 180)) * 0.2), player.posY - 0.5, player.posZ + (-MathHelper.cos(-player.renderYawOffset * ((float) Math.PI / 180)) * 0.2) + (-MathHelper.cos((-player.renderYawOffset + 90) * ((float) Math.PI / 180)) * 0.2), (-MathHelper.sin(-player.renderYawOffset * ((float) Math.PI / 180))) / 5 + (Math.random() - 0.5) / 10, -1, (-MathHelper.cos(-player.renderYawOffset * ((float) Math.PI / 180))) / 5 + (Math.random() - 0.5) / 10);
                }
            } else {
                world.spawnParticle("smoke", player.posX + (-MathHelper.sin(-player.renderYawOffset * ((float) Math.PI / 180)) * 0.2), player.posY - 0.5, player.posZ + (-MathHelper.cos(-player.renderYawOffset * ((float) Math.PI / 180)) * 0.2), (-MathHelper.sin(-player.renderYawOffset * ((float) Math.PI / 180))) / 2 + (Math.random() - 0.5) / 7.3, -0.25, (-MathHelper.cos(-player.renderYawOffset * ((float) Math.PI / 180))) / 3 + (Math.random() - 0.5) / 7.5);
                world.spawnParticle("flame", player.posX + (-MathHelper.sin(-player.renderYawOffset * ((float) Math.PI / 180)) * 0.2) + (-MathHelper.sin((-player.renderYawOffset - 90) * ((float) Math.PI / 180)) * 0.2), player.posY - 0.5, player.posZ + (-MathHelper.cos(-player.renderYawOffset * ((float) Math.PI / 180)) * 0.2) + (-MathHelper.cos((-player.renderYawOffset - 90) * ((float) Math.PI / 180)) * 0.2), (-MathHelper.sin(-player.renderYawOffset * ((float) Math.PI / 180))) / 3 + (Math.random() - 0.5) / 10, -0.25, (-MathHelper.cos(-player.renderYawOffset * ((float) Math.PI / 180))) / 3 + (Math.random() - 0.5) / 10);
                world.spawnParticle("flame", player.posX + (-MathHelper.sin(-player.renderYawOffset * ((float) Math.PI / 180)) * 0.2) + (-MathHelper.sin((-player.renderYawOffset + 90) * ((float) Math.PI / 180)) * 0.2), player.posY - 0.5, player.posZ + (-MathHelper.cos(-player.renderYawOffset * ((float) Math.PI / 180)) * 0.2) + (-MathHelper.cos((-player.renderYawOffset + 90) * ((float) Math.PI / 180)) * 0.2), (-MathHelper.sin(-player.renderYawOffset * ((float) Math.PI / 180))) / 3 + (Math.random() - 0.5) / 10, -0.25, (-MathHelper.cos(-player.renderYawOffset * ((float) Math.PI / 180))) / 3 + (Math.random() - 0.5) / 10);
            }
        }
    }
}
