package net.minecraft.src;

public class XCItemPickaxe extends XCItemTool
{
    private static Block[] blocksEffectiveAgainst = new Block[] {Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered};

    protected XCItemPickaxe(int var1, XCEnumToolMaterial var2)
    {
        super(var1, 2, var2, blocksEffectiveAgainst);
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block var1)
    {
        return var1 == Block.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (var1 != Block.blockDiamond && var1 != Block.oreDiamond ? (var1 == Block.oreEmerald ? this.toolMaterial.getHarvestLevel() >= 2 : (var1 != Block.blockGold && var1 != Block.oreGold ? (var1 != Block.blockIron && var1 != Block.oreIron ? (var1 != Block.blockLapis && var1 != Block.oreLapis ? (var1 != Block.oreRedstone && var1 != Block.oreRedstoneGlowing ? (var1.blockMaterial == Material.rock ? true : var1.blockMaterial == Material.iron) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2)) : this.toolMaterial.getHarvestLevel() >= 2);
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack var1, Block var2)
    {
        return var2 != null && (var2.blockMaterial == Material.iron || var2.blockMaterial == Material.rock) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(var1, var2);
    }
}
