package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class XCRenderMinotaur extends RenderLiving
{
    protected XCModelMinotaur modelBipedMain;
    private float scale = 1.0F;

    public XCRenderMinotaur(XCModelMinotaur var1, float var2)
    {
        super(var1, var2);
        this.modelBipedMain = var1;
    }

    protected void preRenderScale(XCEntityMinotaur var1, float var2)
    {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving var1, float var2)
    {
        this.preRenderScale((XCEntityMinotaur)var1, var2);
    }

    public void XCrenderMinotaur(XCEntityMinotaur var1, double var2, double var4, double var6, float var8, float var9)
    {
        super.doRenderLiving(var1, var2, var4, var6, var8, var9);
    }

    public void doRenderLiving(EntityLiving var1, double var2, double var4, double var6, float var8, float var9)
    {
        this.XCrenderMinotaur((XCEntityMinotaur)var1, var2, var4, var6, var8, var9);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9)
    {
        this.XCrenderMinotaur((XCEntityMinotaur)var1, var2, var4, var6, var8, var9);
    }

    protected void renderEquippedItems(EntityLiving var1, float var2)
    {
        super.renderEquippedItems(var1, var2);
        ItemStack var3 = var1.getHeldItem();

        if (var3 != null)
        {
            GL11.glPushMatrix();
            this.modelBipedMain.rightarm.postRender(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
            float var4;

            if (var3.itemID < 256 && RenderBlocks.renderItemIn3d(Block.blocksList[var3.itemID].getRenderType()))
            {
                var4 = 0.5F;
                GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
                var4 *= 0.75F;
                GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(var4, -var4, var4);
            }
            else if (Item.itemsList[var3.itemID].isFull3D())
            {
                var4 = 0.625F;
                GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
                GL11.glScalef(var4, -var4, var4);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            }
            else
            {
                var4 = 0.375F;
                GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
                GL11.glScalef(var4, var4, var4);
                GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
            }

            this.renderManager.itemRenderer.renderItem(var1, var3, 0);

            if (var3.getItem().requiresMultipleRenderPasses())
            {
                this.renderManager.itemRenderer.renderItem(var1, var3, 1);
            }

            GL11.glPopMatrix();
        }
    }
}
