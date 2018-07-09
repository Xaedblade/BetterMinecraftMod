package net.minecraft.src;

import java.util.Random;

public class XCBlockOre extends Block
{
    public XCBlockOre(int var1)
    {
        super(var1, Material.rock);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
        return this.blockID == mod_XaedCraft.oreCopper.blockID ? mod_XaedCraft.copperdust.itemID : (this.blockID == mod_XaedCraft.oreTin.blockID ? mod_XaedCraft.tindust.itemID : (this.blockID == mod_XaedCraft.oreRune.blockID ? mod_XaedCraft.runeBlank.itemID : (this.blockID == mod_XaedCraft.oreBrimstone.blockID ? Item.gunpowder.itemID : this.blockID)));
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random var1)
    {
        return this.blockID != mod_XaedCraft.oreCopper.blockID && this.blockID != mod_XaedCraft.oreTin.blockID && this.blockID != mod_XaedCraft.oreBrimstone.blockID ? (this.blockID == mod_XaedCraft.oreRune.blockID ? 3 + var1.nextInt(4) : 1) : 1 + var1.nextInt(4);
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int var1, Random var2)
    {
        if (var1 > 0 && this.blockID != this.idDropped(0, var2, var1))
        {
            int var3 = var2.nextInt(var1 + 2) - 1;

            if (var3 < 0)
            {
                var3 = 0;
            }

            return this.quantityDropped(var2) * (var3 + 1);
        }
        else
        {
            return this.quantityDropped(var2);
        }
    }
}
