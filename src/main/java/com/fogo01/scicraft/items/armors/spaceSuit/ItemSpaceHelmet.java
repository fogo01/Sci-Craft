package com.fogo01.scicraft.items.armors.spaceSuit;

import com.fogo01.scicraft.items.ItemSciCraftArmor;
import com.fogo01.scicraft.models.ModelSpaceSuitHelmet;
import com.fogo01.scicraft.reference.Materials;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;

public class ItemSpaceHelmet extends ItemSciCraftArmor {
    public ItemSpaceHelmet() {
        super(Materials.Armor.ARMOR_SPACESUIT, 1, 0);
        this.setUnlocalizedName(Names.Items.SPACE_SUIT[armorType]);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {

        ModelBiped armorModel = new ModelSpaceSuitHelmet();

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
        return Reference.MOD_ID + ":textures/models/armor/SpaceSuit_layer_helmet.png";
    }
}
