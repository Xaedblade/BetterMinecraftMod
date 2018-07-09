package net.minecraft.src;

public class XCItemSpade extends XCItemTool
{
    private static Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium};

    public XCItemSpade(int var1, XCEnumToolMaterial var2)
    {
        super(var1, 1, var2, blocksEffectiveAgainst);
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block var1)
    {
        return var1 == Block.snow ? true : var1 == Block.blockSnow;
    }
}
