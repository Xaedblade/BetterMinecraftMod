package net.minecraft.src;

import java.util.Random;

public class XCWorldGenBossFortress extends WorldGenerator
{
    public int j1 = 0;
    public int Difference = 0;
    public XCEntityMinotaurKing minking;
    public XCEntityMinotaur min;

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        this.minking = new XCEntityMinotaurKing(var1);
        this.min = new XCEntityMinotaur(var1);
        int var6;
        int var7;
        int var8;
        int var9;

        for (var6 = 0; var6 < 4; ++var6)
        {
            for (var7 = 0; var7 < 4; ++var7)
            {
                var8 = var3 + var6;
                var9 = var5 + var7;
                int var10 = var1.getHeightValue(var8, var9);

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

        if (var1.getBiomeGenForCoords(var3, var5) == BiomeGenBase.forest || var1.getBiomeGenForCoords(var3, var5) == BiomeGenBase.forestHills || var1.getBiomeGenForCoords(var3, var5) == BiomeGenBase.taiga || var1.getBiomeGenForCoords(var3, var5) == BiomeGenBase.taigaHills)
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

            for (var6 = 1; var6 <= 6; ++var6)
            {
                for (var7 = 1; var7 <= 7; ++var7)
                {
                    for (var8 = 1; var8 <= 7; ++var8)
                    {
                        var1.setBlockWithNotify(var3 + var7 - 1, this.j1 + var6 - 1, var5 + var8 - 1, 0);
                    }
                }
            }

            for (var6 = 0; var6 < 3; ++var6)
            {
                var7 = var2.nextInt(10) + 1;

                if (var7 >= 9)
                {
                    this.min = new XCEntityMinotaur(var1);

                    if (!var1.isRemote)
                    {
                        this.min.setLocationAndAngles((double)(var3 + 6), (double)(this.j1 + 1), (double)(var5 + 6), 0.0F, 0.0F);
                        var1.spawnEntityInWorld(this.min);
                    }
                }
            }

            for (var6 = 1; var6 <= 6; ++var6)
            {
                for (var7 = 0; var7 <= 6; ++var7)
                {
                    for (var8 = 1; var8 <= 7; ++var8)
                    {
                        if (var8 == 1)
                        {
                            if (var6 == 1 && var7 == 5 && var6 == 1 && var7 == 1)
                            {
                                var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8 - 1, var5 + var7 - 1, 0);
                            }

                            if (var6 >= 2 && var6 <= 6 && var7 == 1 || var6 == 6 && var7 >= 2 && var7 <= 4 || var6 >= 2 && var6 <= 6 && var7 == 5 || var6 == 1 && (var7 == 2 || var7 == 4) || (var7 == 2 || var7 == 4) && var6 == 2)
                            {
                                var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8 - 1, var5 + var7 - 1, 98);
                            }
                        }

                        if (var8 == 2)
                        {
                            if (var6 == 1 && var7 == 5 && var6 == 1 && var7 == 1)
                            {
                                var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8 - 1, var5 + var7 - 1, 0);
                            }

                            if (var6 >= 2 && var6 <= 6 && var7 >= 1 && var7 <= 5 || var6 == 1 && var7 > 1 && var7 < 5)
                            {
                                var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8 - 1, var5 + var7 - 1, 98);
                            }

                            if (var6 == 3 && (var7 == 2 || var7 == 4))
                            {
                                var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8 - 1, var5 + var7 - 1, 87);
                            }
                        }

                        if (var8 == 3)
                        {
                            if (var6 == 1 && var7 == 5 && var6 == 1 && var7 == 1)
                            {
                                var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8 - 1, var5 + var7 - 1, 0);
                            }

                            if (var6 >= 2 && var6 <= 6 && var7 >= 1 && var7 <= 5)
                            {
                                var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8 - 1, var5 + var7 - 1, 98);
                            }

                            if (var6 == 3 && (var7 == 2 || var7 == 4))
                            {
                                var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8 - 1, var5 + var7 - 1, 51);
                            }

                            if (var6 == 2 && (var7 == 2 || var7 == 4))
                            {
                                var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8 - 1, var5 + var7 - 1, 0);
                            }
                        }

                        if (var8 == 4)
                        {
                            if (var6 > 1 && var6 < 7 && var7 > 1 && var7 < 5)
                            {
                                var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8 - 1, var5 + var7 - 1, 98);
                            }

                            if ((var6 == 2 || var6 == 6) && (var7 == 1 || var7 == 5))
                            {
                                var1.setBlockAndMetadataWithNotify(var3 + var6 - 1, this.j1 + var8 - 1, var5 + var7 - 1, 44, 5);
                            }

                            if (var6 > 2 && var6 < 6 && (var7 == 1 || var7 == 5) || var6 == 4 && (var7 == 0 || var7 == 6))
                            {
                                var1.setBlockAndMetadataWithNotify(var3 + var6 - 1, this.j1 + var8 - 1, var5 + var7 - 1, 24, 2);
                            }
                        }

                        if (var8 == 5)
                        {
                            if (var6 > 2 && var6 < 6 && (var7 == 0 || var7 == 1 || var7 == 5 || var7 == 6) || var6 == 4 && (var7 == 2 || var7 == 4))
                            {
                                var1.setBlockAndMetadataWithNotify(var3 + var6 - 1, this.j1 + var8 - 1, var5 + var7 - 1, 24, 2);
                            }

                            var1.setBlockAndMetadataWithNotify(var3 + 4 - 1, this.j1 + var8 - 1, var5 + -1 - 1, 24, 2);
                            var1.setBlockAndMetadataWithNotify(var3 + 4 - 1, this.j1 + var8 - 1, var5 + 7 - 1, 24, 2);
                        }

                        if (var8 >= 5)
                        {
                            var1.setBlockAndMetadataWithNotify(var3 + 4 - 1, this.j1 + var8 - 1, var5 + -1 - 1, 24, 2);
                            var1.setBlockAndMetadataWithNotify(var3 + 4 - 1, this.j1 + var8 - 1, var5 + 7 - 1, 24, 2);
                        }
                    }
                }
            }

            for (var6 = 0; var6 <= 6; ++var6)
            {
                for (var7 = 0; var7 <= 6; ++var7)
                {
                    for (var8 = 0; var8 >= -18; --var8)
                    {
                        if (var6 >= 2 && var6 <= 5 && var7 >= 2 && var7 <= 4)
                        {
                            var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8, var5 + var7 - 1, 0);
                        }

                        if (var8 == 0 && var6 != 0 && var6 <= 2 && (var7 == 2 || var7 == 4))
                        {
                            var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8, var5 + var7 - 1, 98);
                        }

                        if (var8 < 0)
                        {
                            if (var8 <= -2 && (var6 >= 2 && var6 <= 6 && var7 == 1 || var6 == 6 && var7 >= 2 && var7 <= 4 || var6 >= 2 && var6 <= 6 && var7 == 5 || var6 == 2 && var7 >= 2 && var7 <= 4))
                            {
                                var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8, var5 + var7 - 1, 98);
                            }

                            if (var8 == -1)
                            {
                                if (var6 >= 2 && var6 <= 6 && var7 == 1 || var6 == 6 && var7 >= 2 && var7 <= 4 || var6 >= 2 && var6 <= 6 && var7 == 5 || var6 != 0 && var6 <= 2 && (var7 == 2 || var7 == 4))
                                {
                                    var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8, var5 + var7 - 1, 98);
                                }

                                if (var6 != 0 && var6 <= 2 && var7 == 3)
                                {
                                    var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8, var5 + var7 - 1, 0);
                                    var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8 - 1, var5 + var7 - 1, 98);
                                }
                            }

                            if (var8 == -18 && var6 >= 2 && var6 <= 5 && var7 >= 2 && var7 <= 4)
                            {
                                var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8, var5 + var7 - 1, 98);
                            }

                            if (var6 > 2 && var6 <= 5 && var7 >= 2 && var7 <= 4)
                            {
                                for (var9 = 0; var9 >= -18; var9 -= 8)
                                {
                                    if ((var8 == -2 + var9 && var6 == 3 && var7 == 3 || var8 == -3 + var9 && var6 == 3 && var7 == 2 || var8 == -4 + var9 && var6 == 4 && var7 == 2 || var8 == -5 + var9 && var6 == 5 && var7 == 2 || var8 == -6 + var9 && var6 == 5 && var7 == 3 || var8 == -7 + var9 && var6 == 5 && var7 == 4 || var8 == -8 + var9 && var6 == 4 && var7 == 4 || var8 == -9 + var9 && var6 == 3 && var7 == 4) && var8 > -18)
                                    {
                                        var1.setBlockAndMetadataWithNotify(var3 + var6 - 1, this.j1 + var8, var5 + var7 - 1, 44, 5);
                                    }
                                }
                            }

                            if ((var8 == -17 || var8 == -16) && var6 == 6 && var7 == 3)
                            {
                                var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8, var5 + var7 - 1, 0);
                            }
                        }
                    }
                }
            }

            for (var6 = 7; var6 < 32; ++var6)
            {
                for (var7 = -14; var7 < 21; ++var7)
                {
                    for (var8 = -18; var8 < -14; ++var8)
                    {
                        var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8, var5 + var7 - 1, 0);

                        if (var6 >= 16 && var6 <= 22 && var7 >= -1 && var7 <= 5)
                        {
                            for (var9 = 0; var9 <= 3; ++var9)
                            {
                                var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8 + var9, var5 + var7 - 1, 0);
                            }
                        }
                    }
                }
            }

            for (var6 = 7; var6 < 32; ++var6)
            {
                for (var7 = -14; var7 < 21; ++var7)
                {
                    for (var8 = -18; var8 < -14; ++var8)
                    {
                        if (var8 == -18 || var8 == -14)
                        {
                            var1.setBlockAndMetadataWithNotify(var3 + var6 - 1, this.j1 + var8, var5 + var7 - 1, 97, 2);
                        }

                        if (var6 >= 7 && var6 < 32 && (var7 == -14 || var7 == 20) || (var6 == 7 || var6 == 31) && var7 >= -14 && var7 <= 21)
                        {
                            var1.setBlockAndMetadataWithNotify(var3 + var6 - 1, this.j1 + var8, var5 + var7 - 1, 97, 2);
                        }

                        if (var8 > -18 && var8 < -15 && var6 == 7 && var7 == 3)
                        {
                            var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8, var5 + var7 - 1, 0);
                        }

                        if (var6 == 9 && var7 >= -12 && var7 <= 19 || var6 == 11 && (var7 >= 1 && var7 <= 18 || var7 >= -10 && var7 <= -3 || var7 == -12 || var7 == -1) || var6 == 13 && (var7 >= 12 && var7 <= 16 || var7 >= 3 && var7 <= 8) || var6 == 15 && var7 >= 1 && var7 <= 6 || var6 == 18 && var7 == -11 || var6 == 20 && var7 <= -12 || var6 == 21 && var7 >= 18 || var6 == 22 && var7 == -11 || var6 == 23 && (var7 == 17 || var7 >= -2 && var7 <= 5) || var6 == 25 && (var7 >= 10 && var7 <= 14 || var7 >= 4 && var7 <= 8 || var7 >= -8 && var7 <= 0) || var6 == 27 && (var7 >= 8 && var7 <= 16 || var7 >= 0 && var7 <= 4 || var7 >= -10 && var7 <= -4) || var6 == 29 && (var7 >= -12 && var7 <= -6 || var7 >= -2 && var7 <= 1 || var7 >= 3 && var7 <= 6 || var7 >= 10 && var7 <= 18))
                        {
                            var1.setBlockAndMetadataWithNotify(var3 + var6 - 1, this.j1 + var8, var5 + var7 - 1, 97, 2);
                        }

                        if (var7 == -12 && (var6 >= 9 && var6 <= 18 || var6 >= 22 && var6 <= 29) || var7 == -10 && (var6 >= 11 && var6 <= 16 || var6 >= 18 && var6 <= 22 || var6 >= 24 && var6 <= 27) || var7 == -8 && var6 >= 13 && var6 <= 25 || var7 == -6 && var6 >= 11 && var6 <= 23 || var7 == -4 && (var6 >= 13 && var6 <= 25 || var6 >= 27) || var7 == -3 && var6 >= 11 && var6 <= 13 || var7 == -2 && (var6 >= 15 && var6 <= 23 || var6 >= 25 && var6 <= 29) || var7 == -1 && var6 >= 9 && var6 <= 15 || var7 == 1 && (var6 >= 11 && var6 <= 15 || var6 >= 29) || var7 == 2 && var6 >= 23 && var6 <= 27 || var7 == 6 && (var6 >= 15 && var6 <= 23 || var6 >= 25 && var6 <= 29) || var7 == 8 && (var6 >= 13 && var6 <= 25 || var6 >= 27) || var7 == 10 && var6 >= 13 && var6 <= 25 || var7 == 12 && var6 >= 12 && var6 <= 25 || var7 == 14 && var6 >= 15 && var6 <= 25 || var7 == 16 && (var6 >= 13 && var6 <= 23 || var6 >= 25 && var6 <= 27) || var7 == 18 && (var6 >= 11 && var6 <= 19 || var6 >= 23 && var6 <= 29))
                        {
                            var1.setBlockAndMetadataWithNotify(var3 + var6 - 1, this.j1 + var8, var5 + var7 - 1, 97, 2);
                        }

                        if (var8 == -15 && var6 >= 7 && var6 <= 31 && var7 >= -14 && var7 <= 20)
                        {
                            var1.setBlockAndMetadataWithNotify(var3 + var6 - 1, this.j1 + var8, var5 + var7 - 1, 97, 2);
                        }

                        if (var8 == -15)
                        {
                            if (var6 >= 16 && var6 <= 22 && var7 >= -1 && var7 <= 5)
                            {
                                for (var9 = 0; var9 <= 3; ++var9)
                                {
                                    var1.setBlockWithNotify(var3 + var6 - 1, this.j1 + var8 + var9, var5 + var7 - 1, 0);
                                }
                            }

                            if (var6 >= 15 && var6 <= 23 && (var7 == -2 || var7 == 6) || var7 >= -2 && var7 <= 6 && (var6 == 15 || var6 == 23))
                            {
                                for (var9 = 0; var9 <= 2; ++var9)
                                {
                                    var1.setBlockAndMetadataWithNotify(var3 + var6 - 1, this.j1 + var8 + var9, var5 + var7 - 1, 97, 2);
                                }
                            }

                            if (var6 >= 16 && var6 <= 22 && var7 >= -1 && var7 <= 5)
                            {
                                var1.setBlockAndMetadataWithNotify(var3 + var6 - 1, this.j1 + var8 + 3, var5 + var7 - 1, 97, 2);
                            }
                        }

                        if (var8 == -17 && var6 == 19 && var7 == 2)
                        {
                            if (!var1.isRemote)
                            {
                                this.minking.setLocationAndAngles((double)(var3 + var6 - 1), (double)(this.j1 + var8), (double)(var5 + var7 - 1), 0.0F, 0.0F);
                                var1.spawnEntityInWorld(this.minking);
                            }

                            for (var9 = 0; var9 < 5; ++var9)
                            {
                                if (!var1.isRemote)
                                {
                                    this.min = new XCEntityMinotaur(var1);
                                    this.min.setLocationAndAngles((double)(var3 + var6 - 1), (double)(this.j1 + var8), (double)(var5 + var7 - 1), 0.0F, 0.0F);
                                    var1.spawnEntityInWorld(this.min);
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
