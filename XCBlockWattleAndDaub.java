package net.minecraft.src;

public class BMMBlockWattleAndDaub extends Block
{
    int tex1;
    int tex2;
    int metaData;

    protected BMMBlockWattleAndDaub(int var1, int var2, int var3)
    {
        super(var1, Material.clay);
        this.tex1 = var2;
        this.tex2 = var3;
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

            default:
                return this.tex1;
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    protected int damageDropped(int var1)
    {
        return var1;
    }
}
