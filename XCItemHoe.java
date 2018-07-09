package net.minecraft.src;

import java.util.Random;

public class XCItemHoe extends Item
{
    private final EnumToolMaterial toolMaterial;

    public XCItemHoe(int var1, EnumToolMaterial var2)
    {
        super(var1);
        this.maxStackSize = 1;
        this.setMaxDamage(var2.getMaxUses());
        this.toolMaterial = var2;
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
            //if (var8 == Block.grass.blockID && var1.itemID == mod_XaedCraft.hoeMithril.shiftedIndex())
            //{
            //    ItemStack var11 = new ItemStack(Item.dyePowder, 4);
            //    int var10 = var11.itemID;
            //    Random var12 = new Random();
            //    int var13 = var12.nextInt(25) + 1;
        	//
            //    if (var13 == 10)
            //    {
            //        var3.spawnEntityInWorld(new EntityItem(var3, (double)var4, (double)(var5 + 1), (double)var6, new ItemStack(Item.dyePowder, 1, 3)));
            //    }
        {
            int var11 = par3World.getBlockId(par4, par5, par6);
            int var12 = par3World.getBlockId(par4, par5 + 1, par6);

            if (par7 != 0 && var12 == 0 && (var11 == Block.grass.blockID || var11 == Block.dirt.blockID))
            {
                Block var13 = Block.tilledField;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), var13.stepSound.getStepSound(), (var13.stepSound.getVolume() + 1.0F) / 2.0F, var13.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return true;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, var13.blockID);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
    }


    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }
}
