package net.minecraft.src;

public class BMMItemClayMolds extends Item
{
    public BMMItemClayMolds(int var1)
    {
        super(var1);
        this.maxStackSize = 16;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
    {
        return var1;
    }
}
