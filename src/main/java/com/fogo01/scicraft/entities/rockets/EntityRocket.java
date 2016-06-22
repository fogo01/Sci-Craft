package com.fogo01.scicraft.entities.rockets;

import com.fogo01.scicraft.utility.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityRocket extends Entity {
    private boolean isRocketEmpty;
    public int noseCone, fuselage, engine, fin, booster;

    public EntityRocket(World world) {
        super(world);
        this.isRocketEmpty = true;
        this.preventEntitySpawning = true;
        this.setSize(1.6F, 5F);
        this.yOffset = this.height / 2.0F;
    }

    public EntityRocket(World world, double x, double y, double z) {
        this(world);
        this.setPosition(x, y + (double)this.yOffset, z);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }

    public void setParts(int noseCone, int fuselage, int engine, int fin, int booster) {
        this.noseCone = noseCone;
        this.fuselage = fuselage;
        this.engine = engine;
        this.fin = fin;
        this.booster = booster;

        this.dataWatcher.updateObject(20, noseCone);
        this.dataWatcher.updateObject(21, fuselage);
        this.dataWatcher.updateObject(22, engine);
        this.dataWatcher.updateObject(23, fin);
        this.dataWatcher.updateObject(24, booster);
    }

    public int getPart(int part) {
        switch (part) {
            case 0:
                return this.dataWatcher.getWatchableObjectInt(20);
            case 1:
                return this.dataWatcher.getWatchableObjectInt(21);
            case 2:
                return this.dataWatcher.getWatchableObjectInt(22);
            case 3:
                return this.dataWatcher.getWatchableObjectInt(23);
            case 4:
                return this.dataWatcher.getWatchableObjectInt(24);
            default:
                return 0;
        }
    }

    @Override
    protected void entityInit() {
        this.dataWatcher.addObject(20, new Integer(0));
        this.dataWatcher.addObject(21, new Integer(0));
        this.dataWatcher.addObject(22, new Integer(0));
        this.dataWatcher.addObject(23, new Integer(0));
        this.dataWatcher.addObject(24, new Integer(0));
    }

    @Override
    public AxisAlignedBB getCollisionBox(Entity entity) {
        return entity.boundingBox;
    }

    @Override
    public AxisAlignedBB getBoundingBox() {
        return this.boundingBox;
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public boolean canBePushed() {
        return true;
    }

    @Override
    public double getMountedYOffset() {
        return (double)this.height * 0D - 0.30000001192092896D;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float damage) {
        if (this.isEntityInvulnerable())
            return false;

        this.setDead();

        return true;
    }

    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }

    @Override
    public boolean interactFirst(EntityPlayer player) {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != player) {
            return true;
        } else {
            if (!this.worldObj.isRemote) {
                player.mountEntity(this);
            }
            return true;
        }
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tagCompound) {
        int[] parts = tagCompound.getIntArray("parts");

        noseCone = parts[0];
        fuselage = parts[1];
        engine = parts[2];
        fin = parts[3];
        booster = parts[4];

        this.dataWatcher.updateObject(20, noseCone);
        this.dataWatcher.updateObject(21, fuselage);
        this.dataWatcher.updateObject(22, engine);
        this.dataWatcher.updateObject(23, fin);
        this.dataWatcher.updateObject(24, booster);
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound) {
        tagCompound.setIntArray("parts", new int[]{noseCone, fuselage, engine, fin, booster});
    }

    @Override
    public void onUpdate() {
        worldObj.spawnParticle("flame", posX + 0.4F, posY - 1F, posZ + 0.4F, 0F + (Math.random() - 0.5F) / 10, -0.1F, 0F + (Math.random() - 0.5F) / 10);
        worldObj.spawnParticle("flame", posX + 0.4F, posY - 1F, posZ - 0.4F, 0F + (Math.random() - 0.5F) / 10, -0.1F, 0F + (Math.random() - 0.5F) / 10);
        worldObj.spawnParticle("flame", posX - 0.4F, posY - 1F, posZ + 0.4F, 0F + (Math.random() - 0.5F) / 10, -0.1F, 0F + (Math.random() - 0.5F) / 10);
        worldObj.spawnParticle("flame", posX - 0.4F, posY - 1F, posZ - 0.4F, 0F + (Math.random() - 0.5F) / 10, -0.1F, 0F + (Math.random() - 0.5F) / 10);

        worldObj.spawnParticle("smoke", posX + 0.4F, posY - 1F, posZ + 0.4F, 0F + (Math.random() - 0.5F) / 10, -0.1F, 0F + (Math.random() - 0.5F) / 10);
        worldObj.spawnParticle("smoke", posX + 0.4F, posY - 1F, posZ - 0.4F, 0F + (Math.random() - 0.5F) / 10, -0.1F, 0F + (Math.random() - 0.5F) / 10);
        worldObj.spawnParticle("smoke", posX - 0.4F, posY - 1F, posZ + 0.4F, 0F + (Math.random() - 0.5F) / 10, -0.1F, 0F + (Math.random() - 0.5F) / 10);
        worldObj.spawnParticle("smoke", posX - 0.4F, posY - 1F, posZ - 0.4F, 0F + (Math.random() - 0.5F) / 10, -0.1F, 0F + (Math.random() - 0.5F) / 10);

        worldObj.spawnParticle("flame", posX, posY - 1F, posZ - 1F, (Math.random() - 0.5F) / 10, -0.4F, (Math.random() - 0.5F) / 20);
        worldObj.spawnParticle("flame", posX, posY - 1F, posZ + 1F, (Math.random() - 0.5F) / 10, -0.4F, (Math.random() - 0.5F) / 20);
        worldObj.spawnParticle("flame", posX - 1F, posY - 1F, posZ, (Math.random() - 0.5F) / 10, -0.4F, (Math.random() - 0.5F) / 20);
        worldObj.spawnParticle("flame", posX + 1F, posY - 1F, posZ, (Math.random() - 0.5F) / 10, -0.4F, (Math.random() - 0.5F) / 20);

        worldObj.spawnParticle("smoke", posX, posY - 1F, posZ - 1F, (Math.random() - 0.5F) / 10, -0.4F, (Math.random() - 0.5F) / 20);
        worldObj.spawnParticle("smoke", posX, posY - 1F, posZ + 1F, (Math.random() - 0.5F) / 10, -0.4F, (Math.random() - 0.5F) / 20);
        worldObj.spawnParticle("smoke", posX - 1F, posY - 1F, posZ, (Math.random() - 0.5F) / 10, -0.4F, (Math.random() - 0.5F) / 20);
        worldObj.spawnParticle("smoke", posX + 1F, posY - 1F, posZ, (Math.random() - 0.5F) / 10, -0.4F, (Math.random() - 0.5F) / 20);
    }
}
