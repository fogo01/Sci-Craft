package com.fogo01.scicraft.blocks;

import com.fogo01.scicraft.crativetab.CreativeTabSciCraft;
import com.fogo01.scicraft.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class BlockSciCraft extends Block {
    public BlockSciCraft(Material material){
        super(material);
        this.setCreativeTab(CreativeTabSciCraft.SciCraft_TAB);
    }

    public BlockSciCraft(){
        this(Material.rock);
    }

    public int quantityDropped(Random p_149745_1_) {
        return 1;
    }

    public static IIcon GetIconForConnectedTexture(IBlockAccess world, int x, int y, int z, int side, IIcon[] icons) {
        IIcon icon = icons[0];

        boolean[] canConnect = new boolean[27];
        boolean[] blocking = new boolean[27];
        int count = 0;
        for (int y1 = -1; y1 <= 1; y1++) {
            for (int z1 = -1; z1 <= 1; z1++) {
                for (int x1 = -1; x1 <= 1; x1++) {
                    canConnect[count] = CanConnectTo(world, x + x1, y + y1, z + z1, world.getBlock(x, y, z));
                    blocking[count] = world.getBlock(x, y, z).isBlockSolid(world, x + x1, y + y1, z + z1, side == 0 ? 1 : side == 1 ? 0 : side == 2 ? 3 : side == 3 ? 2 : side == 4 ? 5 : 4);
                    blocking[count] = (world.getBlock(x + x1, y + y1, z + z1) ==  world.getBlock(x, y, z)) || world.getBlock(x + x1, y + y1, z + z1).isOpaqueCube();
                    count++;
                }
            }
        }

        if (side == 0) {
            canConnect[9] = blocking[0] ? false : canConnect[9];
            canConnect[10] = blocking[1] ? false : canConnect[10];
            canConnect[11] = blocking[2] ? false : canConnect[11];
            canConnect[12] = blocking[3] ? false : canConnect[12];
            canConnect[13] = blocking[4] ? false : canConnect[13];
            canConnect[14] = blocking[5] ? false : canConnect[14];
            canConnect[15] = blocking[6] ? false : canConnect[15];
            canConnect[16] = blocking[7] ? false : canConnect[16];
            canConnect[17] = blocking[8] ? false : canConnect[17];

            if (!canConnect[10] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[1];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[2];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[3];
            } else if (!canConnect[10] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[4];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[5];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[6];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[7];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[8];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[9];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[10];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[11];
            } else if (!canConnect[10] && !canConnect[12] && !canConnect[14] && canConnect[16]) {
                icon = icons[12];
            } else if (!canConnect[10] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[13];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[14];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[15];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[16];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[17];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[18];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[19];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[20];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[21];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[22];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[23];
            } else if (canConnect[10]&& !canConnect[12] && !canConnect[14] && canConnect[16]) {
                icon = icons[24];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[25];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[26];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[27];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[28];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[29];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[30];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[31];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[32];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[33];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[34];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[35];
            } else if (canConnect[10] && !canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[36];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[37];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[38];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[39];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[40];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[41];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[42];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[43];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[44];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[45];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[46];
            }
        } else if (side == 1) {
            canConnect[9] = blocking[18] ? false : canConnect[9];
            canConnect[10] = blocking[19] ? false : canConnect[10];
            canConnect[11] = blocking[20] ? false : canConnect[11];
            canConnect[12] = blocking[21] ? false : canConnect[12];
            canConnect[13] = blocking[22] ? false : canConnect[13];
            canConnect[14] = blocking[23] ? false : canConnect[14];
            canConnect[15] = blocking[24] ? false : canConnect[15];
            canConnect[16] = blocking[25] ? false : canConnect[16];
            canConnect[17] = blocking[26] ? false : canConnect[17];

            if (!canConnect[10] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[1];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[2];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[3];
            } else if (!canConnect[10] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[4];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[5];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[6];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[7];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[8];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[9];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[10];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[11];
            } else if (!canConnect[10] && !canConnect[12] && !canConnect[14] && canConnect[16]) {
                icon = icons[12];
            } else if (!canConnect[10] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[13];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[14];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[15];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[16];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[17];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[18];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[19];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[20];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[21];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[22];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[23];
            } else if (canConnect[10]&& !canConnect[12] && !canConnect[14] && canConnect[16]) {
                icon = icons[24];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[25];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[26];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[27];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[28];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[29];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[30];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[31];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[32];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[33];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[34];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[35];
            } else if (canConnect[10] && !canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[36];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[37];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[38];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[39];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[40];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[41];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[42];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[43];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[44];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[45];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[46];
            }
        } else if (side == 2) {
            count = 0;
            for (int z1 = 1; z1 >= -1; z1--) {
                for (int y1 = 1; y1 >= -1; y1--) {
                    for (int x1 = 1; x1 >= -1; x1--) {
                        canConnect[count] = CanConnectTo(world, x + x1, y + y1, z + z1, world.getBlock(x, y, z));
                        blocking[count] = world.getBlock(x, y, z).isBlockSolid(world, x + x1, y + y1, z + z1, side == 0 ? 1 : side == 1 ? 0 : side == 2 ? 3 : side == 3 ? 2 : side == 4 ? 5 : 4);
                        blocking[count] = world.getBlock(x + x1, y + y1, z + z1).isOpaqueCube();
                        count++;
                    }
                }
            }

            canConnect[9] = blocking[18] ? false : canConnect[9];
            canConnect[10] = blocking[19] ? false : canConnect[10];
            canConnect[11] = blocking[20] ? false : canConnect[11];
            canConnect[12] = blocking[21] ? false : canConnect[12];
            canConnect[13] = blocking[22] ? false : canConnect[13];
            canConnect[14] = blocking[23] ? false : canConnect[14];
            canConnect[15] = blocking[24] ? false : canConnect[15];
            canConnect[16] = blocking[25] ? false : canConnect[16];
            canConnect[17] = blocking[26] ? false : canConnect[17];

            if (!canConnect[10] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[1];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[2];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[3];
            } else if (!canConnect[10] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[4];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[5];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[6];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[7];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[8];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[9];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[10];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[11];
            } else if (!canConnect[10] && !canConnect[12] && !canConnect[14] && canConnect[16]) {
                icon = icons[12];
            } else if (!canConnect[10] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[13];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[14];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[15];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[16];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[17];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[18];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[19];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[20];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[21];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[22];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[23];
            } else if (canConnect[10]&& !canConnect[12] && !canConnect[14] && canConnect[16]) {
                icon = icons[24];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[25];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[26];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[27];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[28];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[29];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[30];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[31];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[32];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[33];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[34];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[35];
            } else if (canConnect[10] && !canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[36];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[37];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[38];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[39];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[40];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[41];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[42];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[43];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[44];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[45];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[46];
            }
        } else if (side == 3) {
            count = 0;
            for (int z1 = 1; z1 >= -1; z1--) {
                for (int y1 = 1; y1 >= -1; y1--) {
                    for (int x1 = -1; x1 <= 1; x1++) {
                        canConnect[count] = CanConnectTo(world, x + x1, y + y1, z + z1, world.getBlock(x, y, z));
                        blocking[count] = world.getBlock(x, y, z).isBlockSolid(world, x + x1, y + y1, z + z1, side == 0 ? 1 : side == 1 ? 0 : side == 2 ? 3 : side == 3 ? 2 : side == 4 ? 5 : 4);
                        blocking[count] = world.getBlock(x + x1, y + y1, z + z1).isOpaqueCube();
                        count++;
                    }
                }
            }

            canConnect[9] = blocking[0] ? false : canConnect[9];
            canConnect[10] = blocking[1] ? false : canConnect[10];
            canConnect[11] = blocking[2] ? false : canConnect[11];
            canConnect[12] = blocking[3] ? false : canConnect[12];
            canConnect[13] = blocking[4] ? false : canConnect[13];
            canConnect[14] = blocking[5] ? false : canConnect[14];
            canConnect[15] = blocking[6] ? false : canConnect[15];
            canConnect[16] = blocking[7] ? false : canConnect[16];
            canConnect[17] = blocking[8] ? false : canConnect[17];

            if (!canConnect[10] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[1];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[2];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[3];
            } else if (!canConnect[10] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[4];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[5];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[6];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[7];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[8];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[9];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[10];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[11];
            } else if (!canConnect[10] && !canConnect[12] && !canConnect[14] && canConnect[16]) {
                icon = icons[12];
            } else if (!canConnect[10] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[13];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[14];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[15];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[16];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[17];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[18];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[19];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[20];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[21];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[22];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[23];
            } else if (canConnect[10]&& !canConnect[12] && !canConnect[14] && canConnect[16]) {
                icon = icons[24];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[25];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[26];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[27];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[28];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[29];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[30];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[31];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[32];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[33];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[34];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[35];
            } else if (canConnect[10] && !canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[36];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[37];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[38];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[39];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[40];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[41];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[42];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[43];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[44];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[45];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[46];
            }
        } else if (side == 4) {
            count = 0;
            for (int x1 = -1; x1 <= 1; x1++) {
                for (int y1 = 1; y1 >= -1; y1--) {
                    for (int z1 = -1; z1 <= 1; z1++) {
                        canConnect[count] = CanConnectTo(world, x + x1, y + y1, z + z1, world.getBlock(x, y, z));
                        blocking[count] = world.getBlock(x, y, z).isBlockSolid(world, x + x1, y + y1, z + z1, side == 0 ? 1 : side == 1 ? 0 : side == 2 ? 3 : side == 3 ? 2 : side == 4 ? 5 : 4);
                        blocking[count] = world.getBlock(x + x1, y + y1, z + z1).isOpaqueCube();
                        count++;
                    }
                }
            }

            canConnect[9] = blocking[0] ? false : canConnect[9];
            canConnect[10] = blocking[1] ? false : canConnect[10];
            canConnect[11] = blocking[2] ? false : canConnect[11];
            canConnect[12] = blocking[3] ? false : canConnect[12];
            canConnect[13] = blocking[4] ? false : canConnect[13];
            canConnect[14] = blocking[5] ? false : canConnect[14];
            canConnect[15] = blocking[6] ? false : canConnect[15];
            canConnect[16] = blocking[7] ? false : canConnect[16];
            canConnect[17] = blocking[8] ? false : canConnect[17];

            if (!canConnect[10] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[1];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[2];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[3];
            } else if (!canConnect[10] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[4];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[5];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[6];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[7];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[8];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[9];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[10];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[11];
            } else if (!canConnect[10] && !canConnect[12] && !canConnect[14] && canConnect[16]) {
                icon = icons[12];
            } else if (!canConnect[10] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[13];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[14];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[15];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[16];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[17];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[18];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[19];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[20];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[21];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[22];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[23];
            } else if (canConnect[10]&& !canConnect[12] && !canConnect[14] && canConnect[16]) {
                icon = icons[24];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[25];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[26];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[27];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[28];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[29];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[30];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[31];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[32];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[33];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[34];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[35];
            } else if (canConnect[10] && !canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[36];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[37];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[38];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[39];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[40];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[41];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[42];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[43];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[44];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[45];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[46];
            }
        } else if (side == 5) {
            count = 0;
            for (int x1 = -1; x1 <= 1; x1++) {
                for (int y1 = 1; y1 >= -1; y1--) {
                    for (int z1 = 1; z1 >= -1; z1--) {
                        canConnect[count] = CanConnectTo(world, x + x1, y + y1, z + z1, world.getBlock(x, y, z));
                        blocking[count] = world.getBlock(x, y, z).isBlockSolid(world, x + x1, y + y1, z + z1, side == 0 ? 1 : side == 1 ? 0 : side == 2 ? 3 : side == 3 ? 2 : side == 4 ? 5 : 4);
                        blocking[count] = world.getBlock(x + x1, y + y1, z + z1).isOpaqueCube();
                        count++;
                    }
                }
            }

            canConnect[9] = blocking[18] ? false : canConnect[9];
            canConnect[10] = blocking[19] ? false : canConnect[10];
            canConnect[11] = blocking[20] ? false : canConnect[11];
            canConnect[12] = blocking[21] ? false : canConnect[12];
            canConnect[13] = blocking[22] ? false : canConnect[13];
            canConnect[14] = blocking[23] ? false : canConnect[14];
            canConnect[15] = blocking[24] ? false : canConnect[15];
            canConnect[16] = blocking[25] ? false : canConnect[16];
            canConnect[17] = blocking[26] ? false : canConnect[17];

            if (!canConnect[10] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[1];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[2];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[3];
            } else if (!canConnect[10] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[4];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[5];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[6];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[7];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[8];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[9];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[10];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[11];
            } else if (!canConnect[10] && !canConnect[12] && !canConnect[14] && canConnect[16]) {
                icon = icons[12];
            } else if (!canConnect[10] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[13];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[14];
            } else if (!canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[15];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[16];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[17];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[18];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[19];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[20];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[21];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[22];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[23];
            } else if (canConnect[10]&& !canConnect[12] && !canConnect[14] && canConnect[16]) {
                icon = icons[24];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[25];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[26];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[27];
            } else if (canConnect[10] && !canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && canConnect[17]) {
                icon = icons[28];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[29];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && canConnect[16] && !canConnect[17]) {
                icon = icons[30];
            } else if (!canConnect[10] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[31];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[32];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[33];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[34];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[35];
            } else if (canConnect[10] && !canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[36];
            } else if (canConnect[10] && canConnect[11] && !canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[37];
            } else if (canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[38];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[16]) {
                icon = icons[39];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[40];
            } else if (canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && !canConnect[15] && canConnect[16]) {
                icon = icons[41];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[16]) {
                icon = icons[42];
            } else if (!canConnect[9] && canConnect[10] && canConnect[12] && !canConnect[14] && canConnect[15] && canConnect[16]) {
                icon = icons[43];
            } else if (canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[44];
            } else if (!canConnect[9] && canConnect[10] && canConnect[11] && canConnect[12] && canConnect[14] && canConnect[15] && canConnect[16] && canConnect[17]) {
                icon = icons[45];
            } else if (!canConnect[9] && canConnect[10] && !canConnect[11] && canConnect[12] && canConnect[14] && !canConnect[15] && canConnect[16] && !canConnect[17]) {
                icon = icons[46];
            }
        }

        return icon;
    }

    private static boolean CanConnectTo(IBlockAccess world, int x, int y, int z, Block block) {
        Block b = world.getBlock(x, y, z);
        return b == block;
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
