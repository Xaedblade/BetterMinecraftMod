package net.minecraft.src;


public class XCEntityThrowableMagic extends EntityThrowable
{
    int type = 0;

    public XCEntityThrowableMagic(World var1)
    {
        super(var1);
    }

    public XCEntityThrowableMagic(World var1, EntityLivingBase var2, int var3)
    {
        super(var1, var2);
        this.type = var3;
    }

    public XCEntityThrowableMagic(World var1, double var2, double var4, double var6)
    {
        super(var1, var2, var4, var6);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition var1)
    {
        if (this.type == 0)
        {
            Minecraft.getMinecraft().theWorld.spawnEntityInWorld(new EntityLightningBolt(this.worldObj, this.posX, this.posY, this.posZ));

            if (!this.worldObj.isRemote && var1.entityHit != null && !var1.entityHit.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, this.getThrower()), 5))
            {
                ;
            }

            if (!this.worldObj.isRemote)
            {
                this.setDead();
            }
        }

        int var2;
        int var3;
        int var4;

        if (this.type == 1)
        {
            if (!this.worldObj.isRemote)
            {
                if (var1.entityHit != null && !var1.entityHit.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, this.getThrower()), 5))
                {
                    ;
                }

                for (var2 = -1; var2 < 2; ++var2)
                {
                    for (var3 = -1; var3 < 2; ++var3)
                    {
                        for (var4 = -1; var4 < 2; ++var4)
                        {
                            if (this.worldObj.getBlockId((int)this.posX + var3, (int)this.posY + var2, (int)this.posZ + var4) == 0 && (var3 != 0 || var4 != 0))
                            {
                                this.worldObj.setBlock((int)this.posX + var3, (int)this.posY + var2, (int)this.posZ + var4, Block.thinGlass.blockID);
                                this.setDead();
                            }
                        }
                    }
                }
            }

            if (!this.worldObj.isRemote)
            {
                this.setDead();
            }
        }

        if (this.type == 2)
        {
            if (!this.worldObj.isRemote)
            {
                if (var1.entityHit != null && !var1.entityHit.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, this.getThrower()), 5))
                {
                    ;
                }

                for (var2 = 0; var2 < 3; ++var2)
                {
                    for (var3 = 0; var3 < 3; ++var3)
                    {
                        for (var4 = 0; var4 < 3; ++var4)
                        {
                            if (this.worldObj.getBlockId((int)this.posX + var3, (int)this.posY + var2, (int)this.posZ + var4) == 0)
                            {
                                this.worldObj.setBlock((int)this.posX + var3, (int)this.posY + var2, (int)this.posZ + var4, Block.leaves.blockID);
                                this.setDead();
                            }
                        }
                    }
                }
            }

            if (!this.worldObj.isRemote)
            {
                this.setDead();
            }
        }

        if (this.type == 3)
        {
            if (!this.worldObj.isRemote)
            {
                if (var1.entityHit != null && !var1.entityHit.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, this.getThrower()), 5))
                {
                    ;
                }

                for (var2 = 0; var2 < 4; ++var2)
                {
                    for (var3 = 0; var3 < 4; ++var3)
                    {
                        if (this.worldObj.getBlockId((int)this.posX + var2, (int)this.posY, (int)this.posZ + var3) == 0)
                        {
                            this.worldObj.setBlock((int)this.posX + var2, (int)this.posY, (int)this.posZ + var3, Block.fire.blockID);
                            this.setDead();
                        }
                    }
                }
            }

            if (!this.worldObj.isRemote)
            {
                this.setDead();
            }
        }
    }
}
