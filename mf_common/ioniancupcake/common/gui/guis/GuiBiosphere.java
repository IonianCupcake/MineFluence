
package ioniancupcake.common.gui.guis;

import ioniancupcake.common.containers.ContainerBiosphere;
import ioniancupcake.common.lib.Gui;
import ioniancupcake.common.lib.Sprites;
import ioniancupcake.common.tileentitys.MultiBlockTileEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;


public class GuiBiosphere extends GuiContainer
{
	
		
		MultiBlockTileEntity entity;
		int ID, x, y, z;
		World world;
	
        public GuiBiosphere (InventoryPlayer inventoryPlayer, MultiBlockTileEntity tileEntity, int id, int _x, int _y, int _z, World _world) 
        {
                super(new ContainerBiosphere(inventoryPlayer, tileEntity, id));               
            	
                entity = tileEntity;
                ID = id;
                x = _x;
                y = _y;
                z = _z;
                world = _world;
        }

        @Override
        protected void drawGuiContainerForegroundLayer(int i, int j) 
        {
                fontRenderer.drawString("Biosphere", 70, 6, 4210752);
                fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 95 + 2, 4210752);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
        {
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                this.mc.renderEngine.bindTexture(Sprites.GUI_BIOSPHERE);
                int x = (width - xSize) / 2;
                int y = (height - ySize) / 2;
                this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
                System.out.println(entity.combineTime);
                this.drawTexturedModalRect(x + 49, y + 34, 176, 0, Gui.getCookTimeRemainingScaled(54, entity.combineTime) + 1, 18);
        }

}

