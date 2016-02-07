package com.fogo01.scicraft.biomes;

import com.fogo01.scicraft.init.BiomeRegistry;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeManager;

import java.util.ArrayList;
import java.util.List;

public class SciCraftGenLayerBiome extends GenLayer {
    private List<BiomeManager.BiomeEntry>[] biomes = new ArrayList[BiomeManager.BiomeType.values().length];
    private static final String __OBFID = "CL_00000555";

    public SciCraftGenLayerBiome(long p_i2122_1_, GenLayer p_i2122_3_, WorldType p_i2122_4_) {
        super(p_i2122_1_);
        this.parent = p_i2122_3_;
        BiomeManager.BiomeType[] desertIdx = BiomeManager.BiomeType.values();
        int var6 = desertIdx.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            BiomeManager.BiomeType type = desertIdx[var7];
            ImmutableList biomesToAdd = BiomeManager.getBiomes(type);
            int idx = type.ordinal();
            if(this.biomes[idx] == null) {
                this.biomes[idx] = new ArrayList();
            }

            if(biomesToAdd != null) {
                this.biomes[idx].addAll(biomesToAdd);
            }
        }

        int var11 = BiomeManager.BiomeType.DESERT.ordinal();
        if(p_i2122_4_ == WorldType.DEFAULT_1_1) {
            this.biomes[var11].add(new BiomeManager.BiomeEntry(BiomeGenBase.desert, 10));
            this.biomes[var11].add(new BiomeManager.BiomeEntry(BiomeGenBase.forest, 10));
            this.biomes[var11].add(new BiomeManager.BiomeEntry(BiomeGenBase.extremeHills, 10));
            this.biomes[var11].add(new BiomeManager.BiomeEntry(BiomeGenBase.swampland, 10));
            this.biomes[var11].add(new BiomeManager.BiomeEntry(BiomeGenBase.plains, 10));
            this.biomes[var11].add(new BiomeManager.BiomeEntry(BiomeGenBase.taiga, 10));
            this.biomes[var11].add(new BiomeManager.BiomeEntry(BiomeRegistry.biomeMoon, 10));
        } else {
            this.biomes[var11].add(new BiomeManager.BiomeEntry(BiomeGenBase.desert, 30));
            this.biomes[var11].add(new BiomeManager.BiomeEntry(BiomeGenBase.savanna, 20));
            this.biomes[var11].add(new BiomeManager.BiomeEntry(BiomeGenBase.plains, 10));
            this.biomes[var11].add(new BiomeManager.BiomeEntry(BiomeRegistry.biomeMoon, 10));
        }

    }

    public int[] getInts(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
        int[] aint = this.parent.getInts(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
        int[] aint1 = IntCache.getIntCache(p_75904_3_ * p_75904_4_);

        for(int i1 = 0; i1 < p_75904_4_; ++i1) {
            for(int j1 = 0; j1 < p_75904_3_; ++j1) {
                this.initChunkSeed((long)(j1 + p_75904_1_), (long)(i1 + p_75904_2_));
                int k1 = aint[j1 + i1 * p_75904_3_];
                int l1 = (k1 & 3840) >> 8;
                k1 &= -3841;
                if(isBiomeOceanic(k1)) {
                    aint1[j1 + i1 * p_75904_3_] = k1;
                } else if(k1 == BiomeGenBase.mushroomIsland.biomeID) {
                    aint1[j1 + i1 * p_75904_3_] = k1;
                } else if(k1 == 1) {
                    if(l1 > 0) {
                        if(this.nextInt(3) == 0) {
                            aint1[j1 + i1 * p_75904_3_] = BiomeGenBase.mesaPlateau.biomeID;
                        } else {
                            aint1[j1 + i1 * p_75904_3_] = BiomeGenBase.mesaPlateau_F.biomeID;
                        }
                    } else {
                        aint1[j1 + i1 * p_75904_3_] = this.getWeightedBiomeEntry(BiomeManager.BiomeType.DESERT).biome.biomeID;
                    }
                } else if(k1 == 2) {
                    if(l1 > 0) {
                        aint1[j1 + i1 * p_75904_3_] = BiomeGenBase.jungle.biomeID;
                    } else {
                        aint1[j1 + i1 * p_75904_3_] = this.getWeightedBiomeEntry(BiomeManager.BiomeType.WARM).biome.biomeID;
                    }
                } else if(k1 == 3) {
                    if(l1 > 0) {
                        aint1[j1 + i1 * p_75904_3_] = BiomeGenBase.megaTaiga.biomeID;
                    } else {
                        aint1[j1 + i1 * p_75904_3_] = this.getWeightedBiomeEntry(BiomeManager.BiomeType.COOL).biome.biomeID;
                    }
                } else if(k1 == 4) {
                    aint1[j1 + i1 * p_75904_3_] = this.getWeightedBiomeEntry(BiomeManager.BiomeType.ICY).biome.biomeID;
                } else {
                    aint1[j1 + i1 * p_75904_3_] = BiomeGenBase.mushroomIsland.biomeID;
                }
            }
        }

        return aint1;
    }

    protected BiomeManager.BiomeEntry getWeightedBiomeEntry(BiomeManager.BiomeType type) {
        List biomeList = this.biomes[type.ordinal()];
        int totalWeight = WeightedRandom.getTotalWeight(biomeList);
        int weight = BiomeManager.isTypeListModded(type)?this.nextInt(totalWeight):this.nextInt(totalWeight / 10) * 10;
        return (BiomeManager.BiomeEntry)WeightedRandom.getItem(biomeList, weight);
    }
}
