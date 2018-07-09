package net.minecraft.src;

public class BMMItemBlockThatch extends ItemBlock
{
    public String[] blockNames = new String[] {"Thatch", "Tied Thatch"};

    public BMMItemBlockThatch(int var1)
    {
        super(var1);
        this.setHasSubtypes(true);
    }

    public String getItemNameIS(ItemStack var1)
    {
        return super.getItemName() + "." + this.blockNames[var1.getItemDamage()];
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int var1)
    {
        return var1;
    }
}
