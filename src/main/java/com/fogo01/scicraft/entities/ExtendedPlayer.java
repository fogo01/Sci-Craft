package com.fogo01.scicraft.entities;

import com.fogo01.scicraft.utility.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtendedPlayer implements IExtendedEntityProperties {
    public static final String EXTENDED_PLAYER_NAME = "SciCraftExtendedPlayer";
    private final EntityPlayer player;

    private List<int[]> teleporterPositions = new ArrayList<int[]>();

    public ExtendedPlayer(EntityPlayer player) {
        this.player = player;
    }

    public static final void register(EntityPlayer player) {
        player.registerExtendedProperties(EXTENDED_PLAYER_NAME, new ExtendedPlayer(player));
    }

    public static ExtendedPlayer get(EntityPlayer player) {
        return (ExtendedPlayer)player.getExtendedProperties(EXTENDED_PLAYER_NAME);
    }

    @Override
    public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound properties = new NBTTagCompound();

        int[] dimension = new int[teleporterPositions.size()],  x = new int[teleporterPositions.size()], y = new int[teleporterPositions.size()], z = new int[teleporterPositions.size()];
        for (int i = 0; i < teleporterPositions.size(); i++) {
            dimension[i] = teleporterPositions.get(i)[0];
            x[i] = teleporterPositions.get(i)[1];
            y[i] = teleporterPositions.get(i)[2];
            z[i] = teleporterPositions.get(i)[3];
        }
        properties.setIntArray("dimensions", dimension);
        properties.setIntArray("xPositions", x);
        properties.setIntArray("yPositions", y);
        properties.setIntArray("zPositions", z);

        compound.setTag(EXTENDED_PLAYER_NAME, properties);
    }

    @Override
    public void loadNBTData(NBTTagCompound compound) {
        NBTTagCompound properties = (NBTTagCompound)compound.getTag(EXTENDED_PLAYER_NAME);

        int[] dimension = properties.getIntArray("dimensions");
        int[] x = properties.getIntArray("xPositions");
        int[] y = properties.getIntArray("yPositions");
        int[] z = properties.getIntArray("zPositions");

        teleporterPositions.clear();
        for (int i = 0; i < x.length; i++) {
            teleporterPositions.add(new int[]{dimension[i], x[i], y[i], z[i]});
        }
    }

    @Override
    public void init(Entity entity, World world) {

    }

    public void addTeleporterPosition(int dimension, int xCord, int yCord, int zCord) {
        teleporterPositions.add(new int[]{dimension, xCord, yCord, zCord});
        LogHelper.info("Added a new teleporter at: " + dimension + ", " + xCord + ", " + yCord + ", " + zCord);
    }

    public int[][] getTeleporterPositions() {
        if (teleporterPositions == null)
            return new int[][]{};

        int[] dimension = new int[teleporterPositions.size()],  x = new int[teleporterPositions.size()], y = new int[teleporterPositions.size()], z = new int[teleporterPositions.size()];
        for (int i = 0; i < teleporterPositions.size(); i++) {
            dimension[i] = teleporterPositions.get(i)[0];
            x[i] = teleporterPositions.get(i)[1];
            y[i] = teleporterPositions.get(i)[2];
            z[i] = teleporterPositions.get(i)[3];
        }

        return new int[][]{dimension, x, y, z};
    }

    public void removeTeleporterPosition(int dimension, int xCord, int yCord, int zCord) {
        for (int i = 0; i < teleporterPositions.size(); i++) {
            if (Arrays.equals(teleporterPositions.get(i), new int[] {dimension, xCord, yCord, zCord})) {
                teleporterPositions.remove(i);
                LogHelper.info("Removed teleporter at: " + dimension + ", " + xCord + ", " + yCord + ", " + zCord);
                return;
            }
        }
        LogHelper.info("No teleporter at: " + dimension + ", " + xCord + ", " + yCord + ", " + zCord);
    }
}
