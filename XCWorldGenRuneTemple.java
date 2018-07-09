package net.minecraft.src;

import java.util.Random;

public class XCWorldGenRuneTemple extends WorldGenerator
{
    public int j1 = 0;
    public int Difference = 0;

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        int var6;
        int var7;
        int var8;
        int var9;
        int var10;

        for (var6 = 0; var6 < 4; ++var6)
        {
            for (var7 = 0; var7 < 4; ++var7)
            {
                var8 = var3 + var6;
                var9 = var5 + var7;
                var10 = var1.getHeightValue(var8, var9);

                if (this.j1 < var10)
                {
                    this.j1 = var10;
                }
            }

            this.Difference = this.j1 - var4;

            for (var7 = 0; var7 < 6; ++var7)
            {
                for (var8 = 0; var8 < 4; ++var8)
                {
                    for (var9 = 0; var9 < 4; ++var9)
                    {
                        if (var1.getBlockId(var3 + var8, this.j1 + var7, var5 + var9) != 0)
                        {
                            return false;
                        }
                    }
                }
            }
        }

        for (var6 = 0; var6 < 4; ++var6)
        {
            for (var7 = 0; var7 < 4; ++var7)
            {
                if (var1.getBlockId(var3 + var6, this.j1 - 8, var5 + var7) == 0)
                {
                    return false;
                }
            }
        }

        if (this.j1 > 80 && (var1.getBiomeGenForCoords(var3, var5) == BiomeGenBase.extremeHills || var1.getBiomeGenForCoords(var3, var5) == BiomeGenBase.extremeHillsEdge))
        {
            for (var6 = 0; var6 < 4; ++var6)
            {
                for (var7 = 0; var7 < 4; ++var7)
                {
                    if (var1.getBlockId(var3 + var6, this.j1 - 2, var5 + var7) != Block.grass.blockID && var1.getBlockId(var3 + var6, this.j1 - 2, var5 + var7) != Block.dirt.blockID && var1.getBlockId(var3 + var6, this.j1 - 2, var5 + var7) != Block.stone.blockID)
                    {
                        return false;
                    }
                }
            }

            for (var6 = 0; var6 <= 6; ++var6)
            {
                for (var7 = 0; var7 <= 7; ++var7)
                {
                    for (var8 = 0; var8 <= 7; ++var8)
                    {
                        var1.setBlockWithNotify(var3 + var7, this.j1 + var6, var5 + var8, 0);
                    }
                }
            }

            for (var6 = 0; var6 < 7; ++var6)
            {
                for (var7 = 0; var7 < 7; ++var7)
                {
                    for (var8 = 0; var8 > -5; --var8)
                    {
                        var1.setBlockWithNotify(var3 + var6, this.j1 + var8 - 1, var5 + var7, Block.dirt.blockID);
                    }
                }
            }

            for (var6 = 0; var6 < 5; ++var6)
            {
                for (var7 = 0; var7 < 7; ++var7)
                {
                    for (var8 = 0; var8 < 7; ++var8)
                    {
                        if (var6 == 0)
                        {
                            var1.setBlockAndMetadataWithNotify(var3 + var7, this.j1 + var6 - 1, var5 + var8, Block.stoneSingleSlab.blockID, 1);
                        }

                        if (var6 == 0 && var7 <= 5 && var8 <= 5 && var7 != 0 && var8 != 0)
                        {
                            var1.setBlockWithNotify(var3 + var7, this.j1 + var6 - 1, var5 + var8, Block.sandStone.blockID);
                        }

                        if (var6 == 2 && var7 == 3 && var8 == 3)
                        {
                            var1.setBlockAndMetadataWithNotify(var3 + var7, this.j1 + var6 - 1, var5 + var8, mod_XaedCraft.blockAltar.blockID, 0);
                        }

                        if (var6 == 1 && (var7 == 3 && var8 == 2 || var7 == 2 && var8 == 3 || var7 == 4 && var8 == 3 || var7 == 3 && var8 == 4))
                        {
                            var1.setBlockAndMetadataWithNotify(var3 + var7, this.j1 + var6 - 1, var5 + var8, Block.stoneSingleSlab.blockID, 1);
                        }

                        if (var7 == 1 && var8 == 1 || var7 == 5 && var8 == 1 || var7 == 1 && var8 == 5 || var7 == 5 && var8 == 5)
                        {
                            var1.setBlockAndMetadataWithNotify(var3 + var7, this.j1 + var6 - 1, var5 + var8, Block.stoneSingleSlab.blockID, 1);
                        }
                    }
                }
            }
        }

        if (var1.getBiomeGenForCoords(var3, var5) == BiomeGenBase.jungle || var1.getBiomeGenForCoords(var3, var5) == BiomeGenBase.jungleHills)
        {
            for (var6 = 0; var6 < 2; ++var6)
            {
                for (var7 = 0; var7 < 2; ++var7)
                {
                    if (var1.getBlockId(var3 + var6, this.j1 - 1, var5 + var7) != Block.grass.blockID && var1.getBlockId(var3 + var6, this.j1 - 1, var5 + var7) != Block.dirt.blockID && var1.getBlockId(var3 + var6, this.j1 - 1, var5 + var7) != Block.stone.blockID)
                    {
                        return false;
                    }
                }
            }

            for (var6 = 0; var6 < 7; ++var6)
            {
                for (var7 = 0; var7 < 7; ++var7)
                {
                    for (var8 = 0; var8 > -5; --var8)
                    {
                        var1.setBlockWithNotify(var3 + var6, this.j1 + var8 - 1, var5 + var7, Block.dirt.blockID);
                    }
                }
            }

            for (var6 = 0; var6 <= 5; ++var6)
            {
                for (var7 = 0; var7 < 7; ++var7)
                {
                    for (var8 = 0; var8 < 7; ++var8)
                    {
                        if (var6 == 0)
                        {
                            var1.setBlockWithNotify(var3 + var7, this.j1 + var6, var5 + var8, Block.cobblestoneMossy.blockID);
                        }

                        if (var6 == 0 && var7 <= 5 && var8 <= 5 && var7 != 0 && var8 != 0)
                        {
                            var1.setBlockWithNotify(var3 + var7, this.j1 + var6, var5 + var8, Block.cobblestoneMossy.blockID);
                        }

                        if (var6 == 2 && var7 == 3 && var8 == 3)
                        {
                            var1.setBlockAndMetadataWithNotify(var3 + var7, this.j1 + var6, var5 + var8, mod_XaedCraft.blockAltar.blockID, 2);
                        }

                        if (var6 == 1 && (var7 == 3 && var8 == 2 || var7 == 2 && var8 == 3 || var7 == 4 && var8 == 3 || var7 == 3 && var8 == 4))
                        {
                            var1.setBlockWithNotify(var3 + var7, this.j1 + var6, var5 + var8, Block.blockGold.blockID);
                        }

                        if (var6 < 5 && (var7 == 1 && var8 == 1 || var7 == 5 && var8 == 1 || var7 == 1 && var8 == 5 || var7 == 5 && var8 == 5))
                        {
                            var1.setBlockAndMetadataWithNotify(var3 + var7, this.j1 + var6, var5 + var8, Block.wood.blockID, 3);
                        }

                        if (var6 >= 4 && (var7 == 1 && var8 == 1 || var7 == 5 && var8 == 1 || var7 == 1 && var8 == 5 || var7 == 5 && var8 == 5))
                        {
                            for (var9 = 0; var9 < 3; ++var9)
                            {
                                for (var10 = 0; var10 < 3; ++var10)
                                {
                                    var1.setBlockAndMetadataWithNotify(var3 + var7 - 1 + var9, this.j1 + var6, var5 + var8 - 1 + var10, Block.leaves.blockID, 3);
                                }
                            }
                        }
                    }
                }
            }
        }

        if (var1.getBiomeGenForCoords(var3, var5) == BiomeGenBase.frozenOcean || var1.getBiomeGenForCoords(var3, var5) == BiomeGenBase.ocean)
        {
            for (var6 = 0; var6 < 9; ++var6)
            {
                for (var7 = 0; var7 < 9; ++var7)
                {
                    if (var1.getBlockId(var3 + var6, this.j1 - 1, var5 + var7) != Block.grass.blockID || var1.getBlockId(var3 + var6, this.j1 - 1, var5 + var7) != Block.waterStill.blockID || var1.getBlockId(var3 + var6, this.j1 - 1, var5 + var7) != Block.ice.blockID)
                    {
                        return false;
                    }
                }
            }

            for (var6 = 0; var6 < 11; ++var6)
            {
                for (var7 = 0; var7 < 11; ++var7)
                {
                    var1.setBlockWithNotify(var3 + var6 - 2, this.j1 - 1, var5 + var7 - 2, Block.blockLapis.blockID);
                    var1.setBlockWithNotify(var3 + var6 - 2, this.j1, var5 + var7 - 2, Block.blockLapis.blockID);
                }
            }

            for (var6 = 0; var6 < 9; ++var6)
            {
                for (var7 = 0; var7 < 9; ++var7)
                {
                    var1.setBlockWithNotify(var3 + var6 - 1, this.j1, var5 + var7 - 1, Block.waterStill.blockID);
                }
            }

            for (var6 = 0; var6 < 5; ++var6)
            {
                for (var7 = 0; var7 < 7; ++var7)
                {
                    for (var8 = 0; var8 < 7; ++var8)
                    {
                        if (var6 == 0)
                        {
                            var1.setBlockWithNotify(var3 + var7, this.j1 + var6, var5 + var8, Block.blockLapis.blockID);
                        }

                        if (var6 == 0 && var7 <= 5 && var8 <= 5 && var7 != 0 && var8 != 0)
                        {
                            var1.setBlockWithNotify(var3 + var7, this.j1 + var6, var5 + var8, Block.blockLapis.blockID);
                        }

                        if (var6 == 2 && var7 == 3 && var8 == 3)
                        {
                            var1.setBlockAndMetadataWithNotify(var3 + var7, this.j1 + var6, var5 + var8, mod_XaedCraft.blockAltar.blockID, 1);
                        }

                        if (var6 == 1 && (var7 == 3 && var8 == 2 || var7 == 2 && var8 == 3 || var7 == 4 && var8 == 3 || var7 == 3 && var8 == 4))
                        {
                            var1.setBlockWithNotify(var3 + var7, this.j1 + var6, var5 + var8, Block.blockLapis.blockID);
                        }

                        if (var7 == 1 && var8 == 1 || var7 == 5 && var8 == 1 || var7 == 1 && var8 == 5 || var7 == 5 && var8 == 5)
                        {
                            var1.setBlockWithNotify(var3 + var7, this.j1 + var6, var5 + var8, Block.blockLapis.blockID);
                        }

                        if (var6 == 4 && (var7 == 1 && var8 == 1 || var7 == 5 && var8 == 1 || var7 == 1 && var8 == 5 || var7 == 5 && var8 == 5))
                        {
                            var1.setBlockWithNotify(var3 + var7, this.j1 + var6 + 1, var5 + var8, Block.waterMoving.blockID);
                        }
                    }
                }
            }

            return true;
        }
        else
        {
            return true;
        }
    }
}
