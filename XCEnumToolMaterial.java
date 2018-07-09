package net.minecraft.src;

public enum XCEnumToolMaterial
{
    BONE(0, 25, 1.0F, 1, 40),
    BRONZE(2, 200, 5.0F, 1, 18),
    FORSAKEN(7, 50, 30.0F, 8, 40),
    MITHRIL(5, 2000, 18.0F, 7, 25);
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiencyOnProperMaterial;
    private final int damageVsEntity;
    private final int enchantability;

    private XCEnumToolMaterial(int var3, int var4, float var5, int var6, int var7)
    {
        this.harvestLevel = var3;
        this.maxUses = var4;
        this.efficiencyOnProperMaterial = var5;
        this.damageVsEntity = var6;
        this.enchantability = var7;
    }

    public int getMaxUses()
    {
        return this.maxUses;
    }

    public float getEfficiencyOnProperMaterial()
    {
        return this.efficiencyOnProperMaterial;
    }

    public int getDamageVsEntity()
    {
        return this.damageVsEntity;
    }

    public int getHarvestLevel()
    {
        return this.harvestLevel;
    }

    public int getEnchantability()
    {
        return this.enchantability;
    }
    /**
     * Return the crafting material for this tool material, used to determine the item that can be used to repair a tool
     * with an anvil
     */
    public int getToolCraftingMaterial()
    {
        return this == BONE ? Item.bone.itemID : (this == BRONZE ? mod_XaedCraft.ingotBronze.itemID : (this == FORSAKEN ? mod_XaedCraft.ingotForsaken.itemID : (this == MITHRIL ? mod_XaedCraft.ingotMithril.itemID : 0)));
    }
}
