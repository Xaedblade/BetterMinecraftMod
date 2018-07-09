package net.minecraft.src;

import java.util.Random;

public class XCBlockStrongerOre extends Block
{
    public XCBlockStrongerOre(int var1)
    {
        super(var1, Material.iron);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
        return this.blockID;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random var1)
    {
        return 1;
    }
}
