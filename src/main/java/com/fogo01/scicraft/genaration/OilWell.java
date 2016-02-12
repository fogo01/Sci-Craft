package com.fogo01.scicraft.genaration;

import com.fogo01.scicraft.init.ModBlocks;
import com.fogo01.scicraft.utility.LogHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class OilWell extends WorldGenerator {
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        LogHelper.info("Generated");
        int radius = 8 + random.nextInt(4);
        for (int x1 = -radius; x1 <= radius; x1++)
            for (int y1 = -radius; y1 <= radius; y1++)
                for (int z1 = -radius; z1 <= radius; z1++)
                    if (x1 * x1 + y1 * y1 + z1 * z1 <= radius * radius)
                        world.setBlock(x + x1, y + y1, z + z1, ModBlocks.OIL_BLOCK);

        int airBlocks = 0;
        while (airBlocks < 20) {
            if (!world.isAirBlock(x, y, z)) {
                airBlocks = 0;
            } else {
                airBlocks++;
            }
            world.setBlock(x, y, z, ModBlocks.OIL_BLOCK);
            y++;
        }
        return true;
    }
}
