package com.fogo01.scicraft.blocks;

import com.fogo01.scicraft.dimensions.TeleporterSciCraft;
import com.fogo01.scicraft.reference.Dimensions;
import com.fogo01.scicraft.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class BlockPortalBlock extends BlockSciCraft {
    public BlockPortalBlock() {
        super();
        this.setBlockName(Names.Blocks.PORTAL_BLOCK);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (player.getHeldItem() != null)
            if (player.getHeldItem().isItemEqual(new ItemStack(Items.stick))) {
                if (player instanceof EntityPlayerMP) {
                    EntityPlayerMP playerMP = (EntityPlayerMP)player;
                    if (playerMP.dimension != Dimensions.IDs.DIMENSION_ID_MOON)
                        playerMP.mcServer.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) player, Dimensions.IDs.DIMENSION_ID_MOON, new TeleporterSciCraft(MinecraftServer.getServer().worldServerForDimension(Dimensions.IDs.DIMENSION_ID_MOON)));
                    else
                        playerMP.mcServer.getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) player, 0, new TeleporterSciCraft(MinecraftServer.getServer().worldServerForDimension(0)));
                }
            }
        return true;
    }
}
