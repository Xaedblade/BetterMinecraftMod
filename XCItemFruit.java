package net.minecraft.src;

public class XCItemFruit extends Item
{
    public XCItemFruit(int var1)
    {
        super(var1);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

 /**   public boolean tryPlaceIntoWorld(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10)
    {
        if (!var2.canPlayerEdit(var4, var5, var6))
        {
            return false;
        }
        else
        {
            if (var1.itemID == mod_XaedCraft.seedApple.shiftedIndex)
            {
                int var11 = var3.getBlockId(var4, var5, var6);
                int var12 = var3.getBlockMetadata(var4, var5, var6);

                if (var11 == Block.wood.blockID && BlockLog.limitToValidMetadata(var12) == 0)
                {
                    if (var7 == 0)
                    {
                        return false;
                    }

                    if (var7 == 1)
                    {
                        return false;
                    }

                    if (var7 == 2)
                    {
                        --var6;
                    }

                    if (var7 == 3)
                    {
                        ++var6;
                    }

                    if (var7 == 4)
                    {
                        --var4;
                    }

                    if (var7 == 5)
                    {
                        ++var4;
                    }

                    if (var3.isAirBlock(var4, var5, var6))
                    {
                        var3.setBlockWithNotify(var4, var5, var6, mod_BetterBlocks.blockApple.blockID);

                        if (var3.getBlockId(var4, var5, var6) == mod_BetterBlocks.blockApple.blockID)
                        {
                            Block.blocksList[mod_BetterBlocks.blockApple.blockID].updateBlockMetadata(var3, var4, var5, var6, var7, var8, var9, var10);
                        }

                        if (!var2.capabilities.isCreativeMode)
                        {
                            --var1.stackSize;
                        }
                    }

                    return true;
                }
            }

            return false;
        }
    }
    **/
}
