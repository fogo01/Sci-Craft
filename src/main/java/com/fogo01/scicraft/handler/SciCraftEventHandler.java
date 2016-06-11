package com.fogo01.scicraft.handler;

import com.fogo01.scicraft.entities.monsters.EntitySciCraftMoon;
import com.fogo01.scicraft.init.ModItems;
import com.fogo01.scicraft.reference.DamageSources;
import com.fogo01.scicraft.reference.Dimensions;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;

public class SciCraftEventHandler {

    @SubscribeEvent
    public void onLivingEvent(LivingEvent.LivingUpdateEvent event) {
        if (event.entity.dimension == Dimensions.IDs.DIMENSION_ID_MOON) {
            if (event.entity.worldObj.getTotalWorldTime() % 20L == 0L) {
                if (!(event.entity instanceof EntitySciCraftMoon)) {
                    if (!(event.entity instanceof EntityPlayer)) {
                        event.entity.attackEntityFrom(DamageSources.VACUUM, 1F);
                    } else {
                        EntityPlayer player = (EntityPlayer)event.entity;
                        if ((player.getCurrentArmor(0) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(3) != null) && (player.getCurrentArmor(0).getItem() == ModItems.SPACE_SUIT[3] || player.getCurrentArmor(0).getItem() == ModItems.THOUGH_SPACE_SUIT[3]) && (player.getCurrentArmor(1).getItem() == ModItems.SPACE_SUIT[2] || player.getCurrentArmor(1).getItem() == ModItems.THOUGH_SPACE_SUIT[2]) && (player.getCurrentArmor(2).getItem() == ModItems.SPACE_SUIT[1] || player.getCurrentArmor(2).getItem() == ModItems.THOUGH_SPACE_SUIT[1]) && (player.getCurrentArmor(3).getItem() == ModItems.SPACE_SUIT[0] || player.getCurrentArmor(3).getItem() == ModItems.THOUGH_SPACE_SUIT[0])) {

                        } else {
                            player.attackEntityFrom(DamageSources.VACUUM, 1F);
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void gravityEvent(LivingEvent.LivingUpdateEvent event) {
        if (event.entity.dimension == Dimensions.IDs.DIMENSION_ID_MOON) {

            if ((event.entity instanceof EntityPlayer) && ((EntityPlayer)event.entity).capabilities.isFlying)
                return;

            if (event.entity.isAirBorne) {
            } else {
                return;
            }

            if (event.entity.motionY <= 0.04) {
                event.entity.motionY *= 0.94D;
                event.entity.fallDistance -= event.entity.motionY / 2;

            } else {
                event.entity.motionY += 0.06D;
            }
        }
    }

    /**
    @SubscribeEvent
    public void usernameEvent(PlayerEvent.NameFormat event) {
        if (event.username.equals("fogo01")) {
            event.displayname = event.username + ", the author of Sci-Craft";
        }
    }
    */
}
