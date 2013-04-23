package ioniancupcake.common.entity.throwable;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BacteriaBlasterMissile extends EntityThrowable
{
    private int explosionRadius = 2;

    public BacteriaBlasterMissile(World par1World)
    {
        super(par1World);
    }
    public BacteriaBlasterMissile(World par1World, EntityLiving par2EntityLiving)
    {
        super(par1World, par2EntityLiving);
    }
    public BacteriaBlasterMissile(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void onImpact(MovingObjectPosition movingobjectposition)
    {
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, true);
        this.setDead();
    }

}
