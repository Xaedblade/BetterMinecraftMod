package net.minecraft.src;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class XCRenderThrowableMagic extends Render
{
    private float field_77002_a;

    public XCRenderThrowableMagic(float var1)
    {
        this.field_77002_a = var1;
    }

    public void doRenderFireball(XCEntityThrowableMagic var1, double var2, double var4, double var6, float var8, float var9)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2, (float)var4, (float)var6);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        float var10 = this.field_77002_a;
        GL11.glScalef(var10 / 1.0F, var10 / 1.0F, var10 / 1.0F);
        byte var11 = 46;
        this.loadTexture("/gui/items.png");
        Tessellator var12 = Tessellator.instance;
        float var13 = (float)(var11 % 16 * 16 + 0) / 256.0F;
        float var14 = (float)(var11 % 16 * 16 + 16) / 256.0F;
        float var15 = (float)(var11 / 16 * 16 + 0) / 256.0F;
        float var16 = (float)(var11 / 16 * 16 + 16) / 256.0F;
        float var17 = 1.0F;
        float var18 = 0.5F;
        float var19 = 0.25F;
        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        var12.startDrawingQuads();
        var12.setNormal(0.0F, 1.0F, 0.0F);
        var12.addVertexWithUV((double)(0.0F - var18), (double)(0.0F - var19), 0.0D, (double)var13, (double)var16);
        var12.addVertexWithUV((double)(var17 - var18), (double)(0.0F - var19), 0.0D, (double)var14, (double)var16);
        var12.addVertexWithUV((double)(var17 - var18), (double)(1.0F - var19), 0.0D, (double)var14, (double)var15);
        var12.addVertexWithUV((double)(0.0F - var18), (double)(1.0F - var19), 0.0D, (double)var13, (double)var15);
        var12.draw();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9)
    {
        this.doRenderFireball((XCEntityThrowableMagic)var1, var2, var4, var6, var8, var9);
    }
}
