package com.fogo01.scicraft.dimensions;

import com.fogo01.scicraft.init.ModBlocks;
import com.fogo01.scicraft.utility.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TeleporterSciCraft extends Teleporter {
    private final WorldServer worldServerInstance;
    private final Random random;
    private final LongHashMap destinationCoordinateCache = new LongHashMap();
    private final List destinationCoordinateKeys = new ArrayList();

    public TeleporterSciCraft(WorldServer worldServer) {
        super(worldServer);
        this.worldServerInstance = worldServer;
        this.random = new Random(worldServer.getSeed());
    }

    @Override
    public void placeInPortal(Entity entity, double x, double y, double z, float float0) {
        if (this.worldServerInstance.provider.dimensionId != -1) {
            if (this.placeInExistingPortal(entity, x, y, z, float0)) {
                this.makePortal(entity);
                this.placeInExistingPortal(entity, x, y, z, float0);
            }
        } else {
            int x1 = MathHelper.floor_double(entity.posX);
            int y1 = MathHelper.floor_double(entity.posY) - 2;
            int z1 = MathHelper.floor_double(entity.posZ);

            worldServerInstance.setBlock(x1, y1, z1, ModBlocks.PORTAL_BLOCK);

            entity.setLocationAndAngles(x1, y1, z1, entity.rotationYaw, 0.0f);
            entity.motionX = entity.motionY = entity.motionZ = 0.0;
        }
    }

    @Override
    public boolean placeInExistingPortal(Entity entity, double x, double y, double z, float float0) {
        return false;
/**
        short short0 = 128;
        double d0 = -1.0;
        int i = 0, j = 0, k = 0;
        int x1 = MathHelper.floor_double(entity.posX);
        int z1 = MathHelper.floor_double(entity.posZ);
        long l0 = ChunkCoordIntPair.chunkXZ2Int(x1, z1);
        boolean flag = true;
        double d1;
        int i1;

        if (this.destinationCoordinateCache.containsItem(l0)) {
            TeleporterSciCraft.PortalPosition portalPosition = (Teleporter.PortalPosition) this.destinationCoordinateCache.getValueByKey(l0);
            d1 = 0.0;
            i = portalPosition.posX;
            j = portalPosition.posY;
            k = portalPosition.posZ;
            portalPosition.lastUpdateTime = this.worldServerInstance.getWorldTime();
            flag = false;
        } else {
            for (i1 = x1 - short0; i1 <= 1 + short0; i1++) {
                double d2 = i1 + 0.5D - entity.posX;
                for (int i2 = z1 - short0; z1 <= 1 + short0; i2++) {
                    double d3 = i2 + 0.5D - entity.posZ;
                    for (int i3 = this.worldServerInstance.getActualHeight() - 1; i3 >= 0; i3--) {
                        if (this.worldServerInstance.getBlock(i1, i3, i2) == ModBlocks.PORTAL_BLOCK) {
                            while (this.worldServerInstance.getBlock(i2, i3 - 1, i2) == ModBlocks.PORTAL_BLOCK) {
                                i3++;
                            }
                            d1 = i3 + 0.5D - entity.posY;
                            double d4 = d2 * d2 + d1 * d1 + d3 * d3;

                            if (d0 < 0.0D || d4 < d0) {
                                d0 = d4;
                                i = i1;
                                j = i3;
                                k = i2;
                            }
                        }
                    }
                }
            }
        }

        if (d0 >= 0.0D) {
            if (flag) {
                this.destinationCoordinateCache.add(l0, new TeleporterSciCraft.PortalPosition(i, j, k, this.worldServerInstance.getWorldTime()));
                this.destinationCoordinateKeys.add(Long.valueOf(l0));
                LogHelper.info("Location: " + l0);
            }

            double d2 = i + 0.5D;
            double d3 = j + 0.5D;
            double d4 = k + 0.5D;
            int i2 = -1;

            if (this.worldServerInstance.getBlock(i - 1, j, k) == ModBlocks.PORTAL_BLOCK) {
                i2 = 2;
            }
            if (this.worldServerInstance.getBlock(i + 1, j, k) == ModBlocks.PORTAL_BLOCK) {
                i2 = 0;
            }
            if (this.worldServerInstance.getBlock(i, j, k - 1) == ModBlocks.PORTAL_BLOCK) {
                i2 = 3;
            }
            if (this.worldServerInstance.getBlock(i, j, k + 1) == ModBlocks.PORTAL_BLOCK) {
                i2 = 1;
            }

            int i3 = entity.getTeleportDirection();

            if (i2 > -1) {
                int i4 = Direction.rotateLeft[i2];
                int i5 = Direction.offsetX[i2];
                int i6 = Direction.offsetZ[i2];
                int j5 = Direction.offsetX[i4];
                int j6 = Direction.offsetZ[i4];
                boolean flag1 = !this.worldServerInstance.isAirBlock(i + i5 + j5, j, k + i6 + j6) || !this.worldServerInstance.isAirBlock(i + i5 + j5, j + 1, k + i6 + j6);
                boolean flag2 = !this.worldServerInstance.isAirBlock(i + i5 + j5, j, k + i6) || !this.worldServerInstance.isAirBlock(i + i5 + j5, j + 1, k + i6);

                if (flag1 && flag2) {
                    i2 = Direction.rotateOpposite[i2];
                    i4 = Direction.rotateOpposite[i4];
                    i5 = Direction.offsetX[i2];
                    i6 = Direction.offsetZ[i2];
                    j5 = Direction.offsetX[i4];
                    j6 = Direction.offsetZ[i4];
                    i1 = i - j5;
                    d2 -= j5;
                    int k1 = k - j6;
                    d4 -= (double) j6;
                    flag1 = !this.worldServerInstance.isAirBlock(i + i5 + j5, j, k + i6 + j6) || !this.worldServerInstance.isAirBlock(i + i5 + j5, j + 1, k + i6 + j6);
                    flag2 = !this.worldServerInstance.isAirBlock(i + i5 + j5, j, k + i6) || !this.worldServerInstance.isAirBlock(i + i5 + j5, j + 1, k + i6);
                }
                float f1 = 0.5f;
                float f2 = 0.5f;

                if (!flag1 && flag2) {
                    f1 = 1.0f;
                } else if (flag1 && !flag2) {
                    f1 = 0.0f;
                } else if (flag1 && flag2) {
                    f2 = 0.0f;
                }
                d2 += (double)((float)j5 * f1 + f2 * i5);
                d4 += (double)((float)j6 * f1 + f2 * i6);
                float f3 = 0.0f;
                float f4 = 0.0f;
                float f5 = 0.0f;
                float f6 = 0.0f;

                if (i2 == i3) {
                    f3 = 1.0f;
                    f4 = 1.0f;
                } else if (i2 == Direction.rotateOpposite[i3]) {
                    f3 = -1.0f;
                    f4 = -1.0f;
                } else if (i2 == Direction.rotateRight[i3]) {
                    f5 = 1.0f;
                    f6 = -1.0f;
                } else {
                    f5 = -1.0f;
                    f6 = 1.0f;
                }

                double d5 = entity.motionX;
                double d6 = entity.motionZ;
                entity.motionX = d5 * f3 + d6 * f6;
                entity.motionZ = d5 * f5 + d6 * f4;
                entity.rotationYaw = float0 - i3 * 90.0f + i2 * 90.0f;
            } else {
               entity.motionX = entity.motionY = entity.motionZ = 0.0D;
            }

            entity.setLocationAndAngles(d2, d3, d4, entity.rotationYaw, entity.rotationPitch);
            return true;
        } else {
            return false;
        }
 */
    }

    @Override
    public boolean makePortal(Entity entity) {
        int x = MathHelper.floor_double(entity.posX);
        int y = MathHelper.floor_double(entity.posY) - 2;
        int z = MathHelper.floor_double(entity.posZ);
        worldServerInstance.setBlock(x, y, z, ModBlocks.PORTAL_BLOCK);
        return true;
    }
}
