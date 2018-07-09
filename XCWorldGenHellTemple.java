package net.minecraft.src;

import java.util.Random;

public class XCWorldGenHellTemple extends WorldGenerator
{
    public int j = 0;
    public int Difference = 0;

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        if (var1.getBlockId(var3, var4 + 1, var5) == 0)
        {
            int var6;
            int var7;

            for (var6 = 0; var6 < 9; ++var6)
            {
                for (var7 = 0; var7 < 9; ++var7)
                {
                    if (var1.getBlockId(var3 + var6, var4 + 1, var5 + var7) != 0 && var1.getBlockId(var3 + var6, var4 - 1, var5 + var7) != Block.netherrack.blockID)
                    {
                        return false;
                    }
                }
            }

            for (var6 = 0; var6 < 11; ++var6)
            {
                for (var7 = 0; var7 < 11; ++var7)
                {
                    var1.setBlockWithNotify(var3 + var6 - 2, var4 - 1, var5 + var7 - 2, Block.netherBrick.blockID);
                    var1.setBlockWithNotify(var3 + var6 - 2, var4, var5 + var7 - 2, Block.netherBrick.blockID);
                }
            }

            for (var6 = 0; var6 < 9; ++var6)
            {
                for (var7 = 0; var7 < 9; ++var7)
                {
                    var1.setBlockWithNotify(var3 + var6 - 11, var4, var5 + var7 - 1, Block.lavaStill.blockID);
                }
            }

            for (var6 = 0; var6 < 5; ++var6)
            {
                for (var7 = 0; var7 < 7; ++var7)
                {
                    for (int var8 = 0; var8 < 7; ++var8)
                    {
                        if (var6 == 0)
                        {
                            var1.setBlockWithNotify(var3 + var7, var4 + var6, var5 + var8, Block.slowSand.blockID);
                        }

                        if (var6 == 0 && var7 <= 5 && var8 <= 5 && var7 != 0 && var8 != 0)
                        {
                            var1.setBlockWithNotify(var3 + var7, var4 + var6, var5 + var8, Block.slowSand.blockID);
                        }

                        if (var6 == 2 && var7 == 3 && var8 == 3)
                        {
                            var1.setBlockAndMetadataWithNotify(var3 + var7, var4 + var6, var5 + var8, mod_XaedCraft.blockAltar.blockID, 3);
                        }

                        if (var6 == 1 && (var7 == 3 && var8 == 2 || var7 == 2 && var8 == 3 || var7 == 4 && var8 == 3 || var7 == 3 && var8 == 4))
                        {
                            var1.setBlockWithNotify(var3 + var7, var4 + var6, var5 + var8, Block.netherBrick.blockID);
                        }

                        if (var7 == 1 && var8 == 1 || var7 == 5 && var8 == 1 || var7 == 1 && var8 == 5 || var7 == 5 && var8 == 5)
                        {
                            var1.setBlockWithNotify(var3 + var7, var4 + var6, var5 + var8, Block.netherBrick.blockID);
                        }

                        if (var6 == 4 && (var7 == 1 && var8 == 1 || var7 == 5 && var8 == 1 || var7 == 1 && var8 == 5 || var7 == 5 && var8 == 5))
                        {
                            var1.setBlockWithNotify(var3 + var7, var4 + var6 + 1 - 1, var5 + var8, Block.netherrack.blockID);
                            var1.setBlockWithNotify(var3 + var7, var4 + var6 + 1, var5 + var8, Block.fire.blockID);
                        }
                    }
                }
            }
        }

        return true;
    }
}
