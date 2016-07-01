package com.fogo01.scicraft.handler;

import com.fogo01.scicraft.entities.ExtendedPlayer;
import com.fogo01.scicraft.entities.monsters.EntitySciCraftMoon;
import com.fogo01.scicraft.init.ModItems;
import com.fogo01.scicraft.models.ModelFlag;
import com.fogo01.scicraft.reference.DamageSources;
import com.fogo01.scicraft.reference.Dimensions;
import com.fogo01.scicraft.reference.Reference;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import org.lwjgl.opengl.GL11;

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

    @SubscribeEvent
    public void bucketEvent (FillBucketEvent event) {
        if (event.entityPlayer.dimension == Dimensions.IDs.DIMENSION_ID_MOON) {
            if (event.current.isItemEqual(new ItemStack(Items.water_bucket))) {
                event.world.setBlock(event.target.sideHit == 4 ? event.target.blockX - 1 : event.target.sideHit == 5 ? event.target.blockX + 1 : event.target.blockX, event.target.sideHit == 0 ? event.target.blockY - 1 : event.target.sideHit == 1 ? event.target.blockY + 1 : event.target.blockY, event.target.sideHit == 2 ? event.target.blockZ - 1 : event.target.sideHit == 3 ? event.target.blockZ + 1 : event.target.blockZ, Blocks.ice);
                event.result = new ItemStack(Items.bucket);
                event.setResult(Event.Result.ALLOW);
            }
        }
    }

    @SubscribeEvent
    public void iceBreakEvent (BlockEvent.BreakEvent event) {
        if (event.getPlayer().dimension == Dimensions.IDs.DIMENSION_ID_MOON) {
            if (event.block == Blocks.ice) {
                event.world.setBlockToAir(event.x, event.y, event.z);
            }
        }
    }

    @SubscribeEvent
    public void entityConstructingEvent(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer)event.entity) == null)
            ExtendedPlayer.register((EntityPlayer)event.entity);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void playerRenderEvent (RenderPlayerEvent.Pre event) {
        if (event.entityPlayer.getDisplayName().equals("fogo01") || event.entityPlayer.getDisplayName().equals(Reference.FOGO_USERNAME)) {
            GL11.glPushMatrix();

            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/models/Flag_Fogo.png"));
            ModelFlag model = new ModelFlag();

            //event.renderer.modelBipedMain.bipedBody.addChild(((ModelRenderer)model.boxList.get(0)));
            //event.renderer.modelBipedMain.bipedBody.addChild(((ModelRenderer)model.boxList.get(1)));

            if (event.entityPlayer != Minecraft.getMinecraft().thePlayer) {
                GL11.glTranslated(event.entityPlayer.posX - Minecraft.getMinecraft().thePlayer.posX, event.entityPlayer.posY - Minecraft.getMinecraft().thePlayer.posY, event.entityPlayer.posZ - Minecraft.getMinecraft().thePlayer.posZ);
                GL11.glTranslated(0F, 1.5F, 0F);
            }

            GL11.glRotatef(180F, 1F, 0F, 0F);
            GL11.glRotatef(event.entityPlayer.renderYawOffset, 0F, 1F, 0F);
            GL11.glTranslatef(0F, 0.2F, 0.2F);

            GL11.glScalef(0.4F, 0.4F, 0.4F);

            model.render(event.entityPlayer, 0F, 0F, 0.1F, 0F, 0F, 0.0625F);

            GL11.glPopMatrix();
        }
    }

    @SubscribeEvent
    public void usernameEvent(PlayerEvent.NameFormat event) {
        if (event.username.equals("fogo01")) {
            event.displayname = Reference.FOGO_USERNAME;
        }
    }
}
