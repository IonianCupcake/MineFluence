package guis;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import tileentitys.TileEntityBiosphere;
import containers.ContainerBiosphere;


public class GuiBiosphere extends GuiContainer
{
	
		
		TileEntityBiosphere entity;
	
        public GuiBiosphere (InventoryPlayer inventoryPlayer, TileEntityBiosphere tileEntity) {
                super(new ContainerBiosphere(inventoryPlayer, tileEntity));
                entity = tileEntity;
        }

        @Override
        protected void drawGuiContainerForegroundLayer(int i, int j) 
        {
                fontRenderer.drawString("Biosphere", 70, 6, 4210752);
                fontRenderer.drawString("Output:", 5, 20, 4210752);
                fontRenderer.drawString("Bacteria:", 5, 40, 4210752);
                fontRenderer.drawString("Card:", 5, 60, 4210752);
                
                System.out.println(entity.inv[1]);
                System.out.println(entity.inv[2]);
                fontRenderer.drawString(entity.inv1 , 53, 40, 4210752);
                fontRenderer.drawString(entity.inv2 , 35, 60, 4210752);
                
                fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 95 + 2, 4210752);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float par1, int par2,
                        int par3) {
                int texture = mc.renderEngine.getTexture("/MineFluence/com/ioniancupcake/src/textures/guis/Biosphere.png");
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                this.mc.renderEngine.bindTexture(texture);
                int x = (width - xSize) / 2;
                int y = (height - ySize) / 2;
                this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        }

}

