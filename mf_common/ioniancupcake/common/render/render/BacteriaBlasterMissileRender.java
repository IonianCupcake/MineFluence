package ioniancupcake.common.render.render;

import ioniancupcake.common.helper.LogHelper;
import ioniancupcake.common.lib.Sprites;
import ioniancupcake.common.render.models.BacteriaBlasterAmmoModel;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;


public class BacteriaBlasterMissileRender extends Render
{
    private ModelRenderer box;
    
    public BacteriaBlasterMissileRender() {
        box = new ModelRenderer(new BacteriaBlasterAmmoModel(), 0, 0);
        LogHelper.debugLog(box);
        box.addBox(-4F, -4F, -4F, 8, 8, 8);
        box.rotationPointX = 0;
        box.rotationPointY = 0;
        box.rotationPointZ = 0;
    }
    
    @Override
    public void doRender(Entity entity, double x, double y, double z,
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glDisable(2896 /* GL_LIGHTING */);
        GL11.glTranslated(x, y, z);
        LogHelper.debugLog("Rendering...");

        loadTexture(Sprites.MODEL_PATH + "/BacteriaBlasterAmmoModel.png");

        float factor = (float) (1.0 / 16.0);

        box.render(factor);

        GL11.glEnable(2896 /* GL_LIGHTING */);
        GL11.glPopMatrix();
    }

}
