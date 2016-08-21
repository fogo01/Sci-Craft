package com.fogo01.scicraft.entities.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;

public class EntityLaserBeam extends EntityThrowable {
    private float speed = 0.5F;
    EntityPlayer player;

    public EntityLaserBeam(World world) {
        super(world);
        this.motionX*=speed;
        this.motionY*=speed;
        this.motionZ*=speed;
    }

    public EntityLaserBeam(World world, EntityPlayer player) {
        super(world, player);
        this.player = player;
        this.motionX*=speed;
        this.motionY*=speed;
        this.motionZ*=speed;
    }

    public EntityLaserBeam(World world, double X, double Y, double Z) {
        super(world, X, Y, Z);
        this.motionX*=speed;
        this.motionY*=speed;
        this.motionZ*=speed;
    }

    @Override
    protected float getGravityVelocity() {
        return 0.0F;
    }

    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition) {
        Entity entity = movingObjectPosition.entityHit;
        if (entity != null && entity != player) {
            entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 1);
            entity.setVelocity(this.motionX, this.motionY, this.motionZ);
        }
        this.setDead();
    }

    private int life = 0;
    @Override
    public void onUpdate() {
        super.onUpdate();

        if (life < 10) {
            AxisAlignedBB AABB = AxisAlignedBB.getBoundingBox(posX - 8, posY - 8, posZ - 8, posX + 8, posY + 8, posZ + 8);
            List entities = worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AABB);

            float dist = 0;
            int index = -1;
            for (int i = 0; i < entities.size(); i++) {
                if (entities.get(i) != player && ((EntityLivingBase) entities.get(i)).getDistanceToEntity(this) > dist) {
                    dist = ((EntityLivingBase) entities.get(i)).getDistanceToEntity(this);
                    index = i;
                }
            }

            if (index != -1) {
                EntityLivingBase target = (EntityLivingBase) entities.get(index);

                double X = target.posX - this.posX;
                double Y = (target.posY + target.height / 2) - this.posY;
                double Z = target.posZ - this.posZ;
                float f = 0.2f;
                this.setVelocity(X * f, Y * f, Z * f);
            }
        }

        life++;
        if(life >= 80) {
            this.setDead();
            //this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 1, true);
        }
    }
}
