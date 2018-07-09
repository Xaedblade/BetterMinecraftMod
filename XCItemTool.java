package net.minecraft.src;

import com.google.common.collect.Multimap;

public class XCItemTool extends Item
{
    private Block[] blocksEffectiveAgainst;
    protected float efficiencyOnProperMaterial = 4.0F;
    private int damageVsEntity;
    protected XCEnumToolMaterial toolMaterial;

    protected XCItemTool(int var1, int var2, XCEnumToolMaterial var3, Block[] var4)
    {
        super(var1);
        this.toolMaterial = var3;
        this.blocksEffectiveAgainst = var4;
        this.maxStackSize = 1;
        this.setMaxDamage(var3.getMaxUses());
        this.efficiencyOnProperMaterial = var3.getEfficiencyOnProperMaterial();
        this.damageVsEntity = var2 + var3.getDamageVsEntity();
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack var1, Block var2)
    {
        Block[] var3 = this.blocksEffectiveAgainst;
        int var4 = var3.length;

        for (int var5 = 0; var5 < var4; ++var5)
        {
            Block var6 = var3[var5];

            if (var6 == var2)
            {
                return this.efficiencyOnProperMaterial;
            }
        }

        return 1.0F;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack var1, EntityLiving var2, EntityLiving var3)
    {
        var1.damageItem(2, var3);
        return true;
    }

    public boolean func_77660_a(ItemStack var1, World var2, int var3, int var4, int var5, int var6, EntityLiving var7)
    {
        if ((double)Block.blocksList[var3].getBlockHardness(var2, var4, var5, var6) != 0.0D)
        {
            var1.damageItem(1, var7);
        }

        return true;
    }

    /**
     * Returns the damage against a given entity.
     */
    public int getDamageVsEntity(Entity var1)
    {
        return this.damageVsEntity;
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.toolMaterial.getEnchantability();
    }

    public String func_77861_e()
    {
        return this.toolMaterial.toString();
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
        var1.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(field_111210_e, "Tool modifier", (double)this.damageVsEntity, 0));
        return var1;
    }
}
