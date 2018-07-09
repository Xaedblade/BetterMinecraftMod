package net.minecraft.src;

import java.util.Random;

public class XCBlockApple extends XCBlockFruit
{
    public XCBlockApple(int var1)//, int var2)
    {
        super(var1);//, var2);
        this.setTickRandomly(true);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World var1, int var2, int var3, int var4, Random var5)
    {
        if (!this.canBlockStay(var1, var2, var3, var4))
        {
            this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4), 0);
            var1.setBlock(var2, var3, var4, 0);
        }
        else if (var1.rand.nextInt(5) == 0)
        {
            int var6 = var1.getBlockMetadata(var2, var3, var4);
            int var7 = func_72219_c(var6);

            if (var7 < 2)
            {
                ++var7;
                var1.setBlockMetadataWithNotify(var2, var3, var4, var7 << 2 | getDirection(var6), 2);
            }
        }
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World var1, int var2, int var3, int var4)
    {
        int var5 = getDirection(var1.getBlockMetadata(var2, var3, var4));
        var2 += Direction.offsetX[var5];
        var4 += Direction.offsetZ[var5];
        int var6 = var1.getBlockId(var2, var3, var4);
        return var6 == Block.wood.blockID && BlockLog.limitToValidMetadata(var1.getBlockMetadata(var2, var3, var4)) == 0;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 28;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5)
    {
        if (!this.canBlockStay(var1, var2, var3, var4))
        {
            this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4), 0);
            var1.setBlock(var2, var3, var4, 0);
        }
    }

    public static int func_72219_c(int var0)
    {
        return (var0 & 12) >> 2;
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World var1, int var2, int var3, int var4, int var5, float var6, int var7)
    {
        Random var8 = new Random();
        int var10 = func_72219_c(var5);
        byte var11 = 1;

        if (var10 >= 2)
        {
            var11 = 3;
        }

        for (int var12 = 0; var12 < var11; ++var12)
        {
            int var9 = var8.nextInt(3);

            if (var9 == 1)
            {
                this.dropBlockAsItem_do(var1, var2, var3, var4, new ItemStack(Item.appleRed, 1));
               // this.dropBlockAsItem_do(var1, var2, var3, var4, new ItemStack(mod_XaedCraft.seedApple, var9));
            }
        }
    }

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     *
    public int idPicked(World var1, int var2, int var3, int var4)
    {
        return mod_XaedCraft.seedApple.itemID;
    }
    */
}
