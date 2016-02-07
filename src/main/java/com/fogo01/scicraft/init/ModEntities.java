package com.fogo01.scicraft.init;

import com.fogo01.scicraft.entities.monsters.EntityAlien;
import com.fogo01.scicraft.reference.Names;
import com.fogo01.scicraft.reference.Reference;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;

public class ModEntities {
    public static void init() {
        CreateEntity(EntityAlien.class, Reference.MOD_ID.toLowerCase() + ":" + Names.Entities.ENTITY_ALIEN, 0x808080, 0x00660E);
    }

    public static void CreateEntity(Class entityClass, String entityName, int solidColor, int spotColor) {
        int randomID = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomID);
        EntityRegistry.registerModEntity(entityClass, entityName, randomID, Reference.MOD_ID, 64, 1, true);
        EntityRegistry.addSpawn(entityClass, 2, 1, 3, EnumCreatureType.monster, BiomeRegistry.biomeMoon);

        CreateEgg(randomID, solidColor, spotColor);
    }

    private static void CreateEgg(int randomID, int solidColor, int spotColor) {
        EntityList.entityEggs.put(randomID, new EntityList.EntityEggInfo(randomID, solidColor, spotColor));
    }
}
