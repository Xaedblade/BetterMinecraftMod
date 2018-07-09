package net.minecraft.src;

public class XCEntityVillageArcher extends EntityGolem
{
    private int field_48119_b;
    Village villageObj;
    private int field_48120_c;
    private int field_48118_d;
    private static final ItemStack defaultHeldItem = new ItemStack(Item.bow, 1);

    public XCEntityVillageArcher(World var1)
    {
        super(var1);
        this.texture = "/Better_Mod/mob/final.png";
        this.moveSpeed = 0.25F;
        this.villageObj = null;
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(1, new EntityAIMoveThroughVillage(this, 0.22F, true));
        this.tasks.addTask(2, new XCEntityAIArcherArrowAttack(this, this.moveSpeed, 1, 60));
        this.tasks.addTask(3, new EntityAIMoveTwardsRestriction(this, 0.22F));
        this.tasks.addTask(4, new XCEntityAIArcherLookAtVillager(this));
        this.tasks.addTask(5, new EntityAIWander(this, 0.22F));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.tasks.addTask(8, new EntityAIOpenDoor(this, true));
        this.targetTasks.addTask(1, new XCEntityAIArcherDefendVillage(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityZombie.class, 16.0F, 0, false));
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

    public Village getVillage()
    {
        return this.villageObj;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    public int getMaxHealth()
    {
        return 20;
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
        return "mob.villager.default";
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
     * Returns the item that this EntityLiving is holding, if any.
     */
    public ItemStack getHeldItem()
    {
        return defaultHeldItem;
    }

    public boolean attackEntityAsMob(Entity var1)
    {
        this.field_48120_c = 10;
        this.worldObj.setEntityState(this, (byte)4);
        boolean var2 = var1.attackEntityFrom(DamageSource.causeMobDamage(this), 7 + this.rand.nextInt(7));

        if (var2)
        {
            var1.motionY += 0.4000000059604645D;
        }

        return var2;
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

        if (var4 == 7)
        {
            this.dropItem(Item.plateSteel.shiftedIndex, 1);
        }
        else if (var4 <= 3)
        {
            this.dropItem(Item.bow.shiftedIndex, 1);
        }

        if (var4 == 10)
        {
            ItemStack var5 = new ItemStack(Item.bow);
            EnchantmentHelper.addRandomEnchantment(this.rand, var5, 5);
            this.entityDropItem(var5, 0.0F);
        }
    }

    public int func_48117_D_()
    {
        return this.field_48118_d;
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
