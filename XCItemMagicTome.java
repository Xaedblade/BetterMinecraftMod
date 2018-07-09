package net.minecraft.src;

import java.util.Random;

public class XCItemMagicTome extends Item
{
    public Random rand;
    public int tomeType;

    public XCItemMagicTome(int var1, int var2)
    {
        super(var1);
        this.maxStackSize = 16;
        this.setMaxDamage(10);
        this.tomeType = var2;
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
    {
        if (!var2.isRemote)
        {
            var2.spawnEntityInWorld(new XCEntityThrowableMagic(var2, var3, this.tomeType));
            var2.playSoundAtEntity(var3, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!var3.capabilities.isCreativeMode)
            {
                --var1.stackSize;
            }
        }

        return var1;
    }
}
