package net.minecraft.src;

public class XCItemPie extends ItemFood
{
    public XCItemPie(int var1, int var2)
    {
        super(var1, var2, false);
        this.setMaxStackSize(1);
    }

    public boolean hasEffect(ItemStack var1)
    {
        return var1.itemID == mod_XaedCraft.pieGoldenApple.itemID;
    }

    public ItemStack onEaten(ItemStack var1, World var2, EntityPlayer var3)
    {
        super.onFoodEaten(var1, var2, var3);
        return new ItemStack(mod_XaedCraft.pieDish);
    }
    
    protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par2World.isRemote && (par1ItemStack.itemID == mod_XaedCraft.pieGoldenApple.itemID))
        {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 7500, 0));
        }

        else
        {
            super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
        }
    }
}
