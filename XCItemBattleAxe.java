package net.minecraft.src;

import java.util.Random;

import com.google.common.collect.Multimap;

public class XCItemBattleAxe extends Item
{
    private int weaponDamage;
    private final XCEnumToolMaterial toolMaterial;
    public Random random;

    public XCItemBattleAxe(int var1, XCEnumToolMaterial var2)
    {
        super(var1);
        this.toolMaterial = var2;
        this.maxStackSize = 1;
        this.setMaxDamage(var2.getMaxUses());

        if (this.toolMaterial == XCEnumToolMaterial.FORSAKEN)
        {
            this.weaponDamage = 14 + var2.getDamageVsEntity();
        }
        else
        {
            this.weaponDamage = 5 + var2.getDamageVsEntity();
        }
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack var1, Block var2)
    {
        return var2.blockID != Block.wood.blockID ? 1.5F : 15.0F;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack var1, EntityLiving var2, EntityLiving var3)
    {
        if (var1.itemID == mod_XaedCraft.battleAxeForsaken.itemID)
        {
            var2.setFire(20);
        }

        this.random = new Random();
        int var4 = this.random.nextInt(10);

        if (var4 >= 5)
        {
            int var5 = var4 / 3;
            var2.addVelocity((double)(-MathHelper.sin(var3.rotationYaw * (float)Math.PI / 180.0F) * (float)var5 * 0.5F), 0.1D, (double)(MathHelper.cos(var3.rotationYaw * (float)Math.PI / 180.0F) * (float)var5 * 0.5F));
        }

        var1.damageItem(1, var3);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack var1, int var2, int var3, int var4, int var5, EntityLiving var6)
    {
        var1.damageItem(2, var6);
        return true;
    }

    /**
     * Returns the damage against a given entity.
     */
    public int getDamageVsEntity(Entity var1)
    {
        return this.weaponDamage;
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack var1)
    {
        return EnumAction.block;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack var1)
    {
        return 72000;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
    {
        var3.setItemInUse(var1, this.getMaxItemUseDuration(var1));
        return var1;
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block var1)
    {
        return var1.blockID == Block.wood.blockID;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.toolMaterial.getEnchantability();
    }
    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return this.toolMaterial.getToolCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }

    public Multimap func_111205_h()
    {
        Multimap var1 = super.func_111205_h();
        var1.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.weaponDamage, 0));
        return var1;
    }
}
