package net.minecraft.src;

public class XCItemAxe extends XCItemTool
{
    private static Block[] blocksEffectiveAgainst = new Block[] {Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern};

    protected XCItemAxe(int var1, XCEnumToolMaterial var2)
    {
        super(var1, 3, var2, blocksEffectiveAgainst);
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack var1, Block var2)
    {
        return var2 != null && var2.blockMaterial == Material.wood ? this.efficiencyOnProperMaterial : super.getStrVsBlock(var1, var2);
    }
}
