package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class XCEntityMinotaurKing extends EntityMob
{
    Minecraft minecraft;
    int tick = 0;
    public XCEntityMinotaur min;
    protected int maxHealth;
    private static final ItemStack defaultHeldItem = new ItemStack(mod_XaedCraft.battleAxeMithril, 1);

    public XCEntityMinotaurKing(World var1)
    {
        super(var1);
        this.texture = "/XaedCraft/mob/Minotaur.png";
        this.attackStrength = 25;
        this.experienceValue = 1000;
        this.moveSpeed = 0.3F;
        this.maxHealth = 200;
        this.setSize(2.0F, 4.0F);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
        this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, this.moveSpeed, false));
        this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return false;
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
        return 200;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Integer.valueOf(0));
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.cow";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.cowhurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.cowhurt";
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean var1, int var2)
    {
        int var3 = this.rand.nextInt(3 + var2);

        for (int var4 = 0; var4 < var3; ++var4)
        {
            this.dropItem(Item.beefCooked.shiftedIndex, 1);
            this.dropItem(Item.leather.shiftedIndex, 1);
        }

        this.dropItem(mod_XaedCraft.tomeWind.shiftedIndex, 1);
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {
        return super.interact(var1);
    }

    protected void dropRareDrop(int var1)
    {
        switch (this.rand.nextInt(6))
        {
            case 0:
                this.dropItem(mod_XaedCraft.battleAxeBronze.shiftedIndex, 1);
                break;

            case 1:
                this.dropItem(mod_XaedCraft.battleAxeMithril.shiftedIndex, 1);
                break;

            case 2:
                this.dropItem(mod_XaedCraft.daggerDiamond.shiftedIndex, 2);
        }
    }

    public EntityAnimal spawnBabyAnimal(EntityAnimal var1)
    {
        return new EntityCow(this.worldObj);
    }

    /**
     * Returns the item that this EntityLiving is holding, if any.
     */
    public ItemStack getHeldItem()
    {
        return defaultHeldItem;
    }
}
