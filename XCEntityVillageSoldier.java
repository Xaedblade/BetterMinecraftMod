package net.minecraft.src;

public class XCEntityVillageSoldier extends EntityGolem
{
    private int field_48119_b = 0;
    Village villageObj = null;
    private int field_48120_c;
    private int field_48118_d;
    private static final ItemStack defaultHeldItem = new ItemStack(Item.swordSteel, 1);

    public XCEntityVillageSoldier(World var1)
    {
        super(var1);
        this.texture = "/Better_Mod/mob/final.png";
        this.moveSpeed = 0.5F;
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 0.3F, true));
        this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.35F, 32.0F));
        this.tasks.addTask(3, new EntityAIMoveThroughVillage(this, 0.22F, true));
        this.tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, 0.22F));
        this.tasks.addTask(5, new EntityAIBetterLookAtVillager(this));
        this.tasks.addTask(6, new EntityAIWander(this, 0.22F));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(9, new EntityAIOpenDoor(this, true));
        this.targetTasks.addTask(1, new EntityAIGuardVillage(this));
        this.targetTasks.addTask(2, new EntityAIBetterHurtByTarget(this, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityZombie.class, 16.0F, 0, false, true));
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    /**
     * main AI tick function, replaces updateEntityActionState
     */
    protected void updateAITick()
    {
        if (--this.field_48119_b <= 0)
        {
            this.field_48119_b = 70 + this.rand.nextInt(50);
            this.villageObj = this.worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ), 32);

            if (this.villageObj == null)
            {
                this.detachHome();
            }
            else
            {
                ChunkCoordinates var1 = this.villageObj.getCenter();
                this.setHomeArea(var1.posX, var1.posY, var1.posZ, this.villageObj.getVillageRadius());
            }
        }

        super.updateAITick();
    }

    public int getMaxHealth()
    {
        return 20;
    }

    /**
     * Decrements the entity's air supply when underwater
     */
    protected int decreaseAirSupply(int var1)
    {
        return var1;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (this.field_48120_c > 0)
        {
            --this.field_48120_c;
        }

        if (this.field_48118_d > 0)
        {
            --this.field_48118_d;
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
        var1.setBoolean("PlayerCreated", this.func_48112_E_());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);
        this.func_48115_b(var1.getBoolean("PlayerCreated"));
    }

    public boolean attackEntityAsMob(Entity var1)
    {
        this.field_48120_c = 10;
        this.worldObj.setEntityState(this, (byte)4);
        boolean var2 = var1.attackEntityFrom(DamageSource.causeMobDamage(this), 7 + this.rand.nextInt(7));

        if (var2)
        {
            var1.motionY += 0.01000000596046448D;
        }

        return var2;
    }

    public void handleHealthUpdate(byte var1)
    {
        if (var1 == 4)
        {
            this.field_48120_c = 10;
        }
        else if (var1 == 11)
        {
            this.field_48118_d = 400;
        }
        else
        {
            super.handleHealthUpdate(var1);
        }
    }

    public Village getVillage()
    {
        return this.villageObj;
    }

    public int func_48114_ab()
    {
        return this.field_48120_c;
    }

    public void func_48116_a(boolean var1)
    {
        this.field_48118_d = var1 ? 400 : 0;
        this.worldObj.setEntityState(this, (byte)11);
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return null;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.villager.defaulthurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.villager.defaultdeath";
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return mod_BetterWeapons.daggerIron.shiftedIndex;
    }

    /**
     * Returns the item that this EntityLiving is holding, if any.
     */
    public ItemStack getHeldItem()
    {
        return defaultHeldItem;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean var1, int var2)
    {
        int var3 = this.rand.nextInt(3);

        if (var3 == 2)
        {
            this.dropItem(Item.goldNugget.shiftedIndex, 1);
        }

        int var4 = this.rand.nextInt(20);

        if (var4 == 6)
        {
            this.dropItem(Item.plateSteel.shiftedIndex, 1);
        }
        else if (var4 == 3)
        {
            this.dropItem(Item.swordSteel.shiftedIndex, 1);
        }
    }

    public int func_48117_D_()
    {
        return this.field_48118_d;
    }

    public boolean func_48112_E_()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void func_48115_b(boolean var1)
    {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);

        if (var1)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 | 1)));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & -2)));
        }
    }
}
