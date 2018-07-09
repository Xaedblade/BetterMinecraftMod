package net.minecraft.src;

public class XCEntityAIArcherDefendVillage extends EntityAITarget
{
    XCEntityVillageArcher irongolem;
    EntityLiving villageAgressorTarget;

    public XCEntityAIArcherDefendVillage(XCEntityVillageArcher var1)
    {
        super(var1, 16.0F, false, true);
        this.irongolem = var1;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        Village var1 = this.irongolem.getVillage();

        if (var1 == null)
        {
            return false;
        }
        else
        {
            this.villageAgressorTarget = var1.findNearestVillageAggressor(this.irongolem);
            return this.isSuitableTarget(this.villageAgressorTarget, false);
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.irongolem.setAttackTarget(this.villageAgressorTarget);
        super.startExecuting();
    }
}
