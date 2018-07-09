package net.minecraft.src;

public class XCBlockRuneAltar extends Block
{
    int tex1;
    int tex2;
    int tex3;
    int tex4;
    int metaData;

    protected XCBlockRuneAltar(int var1, int var2, int var3, int var4, int var5)
    {
        super(var1, Material.cloth);
        this.tex1 = var2;
        this.tex2 = var3;
        this.tex3 = var4;
        this.tex4 = var5;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int var1, int var2)
    {
        this.metaData = var2;

        switch (var2)
        {
            case 0:
                return this.tex1;

            case 1:
                return this.tex2;

            case 2:
                return this.tex3;

            case 3:
                return this.tex4;

            default:
                return this.tex1;
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return par1;
    }
    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9)
    {
        Item var10 = mod_XaedCraft.runeBlank;

        if (var5.getCurrentEquippedItem() != null && var5.getCurrentEquippedItem().itemID == var10.itemID)
        {
            int var11 = var5.getCurrentEquippedItem().stackSize;
            int var12;

            if (this.metaData == 0)
            {
                for (var12 = 0; var12 < var11; ++var12)
                {
                    if (var5.inventory.addItemStackToInventory(new ItemStack(mod_XaedCraft.runeWind, 1)))
                    {
                        ;
                    }
                }

                var5.destroyCurrentEquippedItem();
            }
            else if (this.metaData == 1)
            {
                for (var12 = 0; var12 < var11; ++var12)
                {
                    if (var5.inventory.addItemStackToInventory(new ItemStack(mod_XaedCraft.runeWater, 1)))
                    {
                        ;
                    }
                }

                var5.destroyCurrentEquippedItem();
            }
            else if (this.metaData == 2)
            {
                for (var12 = 0; var12 < var11; ++var12)
                {
                    if (var5.inventory.addItemStackToInventory(new ItemStack(mod_XaedCraft.runeNature, 1)))
                    {
                        ;
                    }
                }

                var5.destroyCurrentEquippedItem();
            }

            if (this.metaData == 3)
            {
                for (var12 = 0; var12 < var11; ++var12)
                {
                    if (var5.inventory.addItemStackToInventory(new ItemStack(mod_XaedCraft.runeFire, 1)))
                    {
                        ;
                    }
                }

                var5.destroyCurrentEquippedItem();
            }
        }

        return true;
    }
}
