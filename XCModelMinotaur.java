package net.minecraft.src;

public class XCModelMinotaur extends ModelBase
{
    ModelRenderer Neck;
    ModelRenderer leftBaseHorn;
    ModelRenderer leftHornTip;
    ModelRenderer rightHornTip;
    ModelRenderer rightBaseHorn;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer mouth;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer lefthoof;
    ModelRenderer righthoof;
    public int heldItemLeft;
    public int heldItemRight;

    public XCModelMinotaur()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.heldItemLeft = 0;
        this.heldItemRight = 0;
        this.Neck = new ModelRenderer(this, 0, 37);
        this.Neck.addBox(-5.0F, -7.0F, -4.0F, 8, 7, 8);
        this.Neck.setRotationPoint(1.0F, 5.0F, -2.0F);
        this.Neck.setTextureSize(64, 64);
        this.Neck.mirror = true;
        this.leftBaseHorn = new ModelRenderer(this, 38, 0);
        this.leftBaseHorn.addBox(0.0F, -4.0F, 2.5F, 3, 2, 3);
        this.leftBaseHorn.setRotationPoint(4.0F, -4.0F, -4.5F);
        this.leftBaseHorn.setTextureSize(64, 64);
        this.leftBaseHorn.mirror = true;
        this.leftHornTip = new ModelRenderer(this, 33, 0);
        this.leftHornTip.addBox(-5.0F, -3.0F, 8.0F, 1, 3, 1);
        this.leftHornTip.setRotationPoint(7.0F, -4.0F, -3.5F);
        this.leftHornTip.setTextureSize(64, 64);
        this.leftHornTip.mirror = true;
        this.rightHornTip = new ModelRenderer(this, 33, 0);
        this.rightHornTip.addBox(4.0F, -3.0F, 7.5F, 1, 3, 1);
        this.rightHornTip.setRotationPoint(-7.0F, -4.0F, -3.5F);
        this.rightHornTip.setTextureSize(64, 64);
        this.rightHornTip.mirror = true;
        this.rightBaseHorn = new ModelRenderer(this, 38, 0);
        this.rightBaseHorn.addBox(-3.0F, -4.0F, 2.0F, 3, 2, 3);
        this.rightBaseHorn.setRotationPoint(-4.0F, -4.0F, -4.0F);
        this.rightBaseHorn.setTextureSize(64, 64);
        this.rightBaseHorn.mirror = true;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
        this.head.setRotationPoint(0.0F, 3.0F, -4.0F);
        this.head.setTextureSize(64, 64);
        this.head.mirror = true;
        this.rightBaseHorn.addChild(this.rightHornTip);
        this.leftBaseHorn.addChild(this.leftHornTip);
        this.head.addChild(this.rightBaseHorn);
        this.head.addChild(this.leftBaseHorn);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 7);
        this.body.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.body.setTextureSize(64, 64);
        this.body.mirror = true;
        this.rightarm = new ModelRenderer(this, 40, 41);
        this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4);
        this.rightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.rightarm.setTextureSize(64, 64);
        this.rightarm.mirror = true;
        this.mouth = new ModelRenderer(this, 41, 6);
        this.mouth.addBox(-3.0F, -5.0F, 1.0F, 5, 4, 3);
        this.mouth.setRotationPoint(0.5F, 1.0F, -8.0F);
        this.mouth.setTextureSize(64, 64);
        this.mouth.mirror = true;
        this.head.addChild(this.mouth);
        this.leftarm = new ModelRenderer(this, 40, 41);
        this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4);
        this.leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.leftarm.setTextureSize(64, 64);
        this.leftarm.mirror = true;
        this.rightleg = new ModelRenderer(this, 0, 16);
        this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 9, 4);
        this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.rightleg.setTextureSize(64, 64);
        this.rightleg.mirror = true;
        this.leftleg = new ModelRenderer(this, 0, 16);
        this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 9, 4);
        this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.leftleg.setTextureSize(64, 64);
        this.leftleg.mirror = true;
        this.lefthoof = new ModelRenderer(this, 0, 53);
        this.lefthoof.addBox(-4.0F, -12.0F, -3.0F, 5, 4, 6);
        this.lefthoof.setRotationPoint(2.0F, 20.0F, 0.0F);
        this.lefthoof.setTextureSize(64, 64);
        this.lefthoof.mirror = true;
        this.righthoof = new ModelRenderer(this, 0, 53);
        this.righthoof.addBox(-1.0F, -12.0F, -3.0F, 5, 4, 6);
        this.righthoof.setRotationPoint(-2.0F, 20.0F, 0.0F);
        this.righthoof.setTextureSize(64, 64);
        this.righthoof.mirror = true;
        this.leftleg.addChild(this.lefthoof);
        this.rightleg.addChild(this.righthoof);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        this.setRotationAngles(var2, var3, var4, var5, var6, var7);
        this.Neck.render(var7);
        this.head.render(var7);
        this.body.render(var7);
        this.rightarm.render(var7);
        this.leftarm.render(var7);
        this.rightleg.render(var7);
        this.leftleg.render(var7);
    }

    /**
     * Sets the models various rotation angles.
     */
    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        this.head.rotateAngleY = var4 / (180F / (float)Math.PI);
        this.head.rotateAngleX = var5 / (180F / (float)Math.PI);
        this.rightarm.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;
        this.leftarm.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.rightarm.rotateAngleZ = 0.0F;
        this.leftarm.rotateAngleZ = 0.0F;
        this.rightleg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.leftleg.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
        this.rightleg.rotateAngleY = 0.0F;
        this.leftleg.rotateAngleY = 0.0F;

        if (this.heldItemLeft != 0)
        {
            this.leftarm.rotateAngleX = this.leftarm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)this.heldItemLeft;
        }

        if (this.heldItemRight != 0)
        {
            this.rightarm.rotateAngleX = this.rightarm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)this.heldItemRight;
        }

        this.rightarm.rotateAngleY = 0.0F;
        this.leftarm.rotateAngleY = 0.0F;
        this.rightarm.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.leftarm.rotateAngleZ -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.rightarm.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.leftarm.rotateAngleX -= MathHelper.sin(var3 * 0.067F) * 0.05F;
    }
}
