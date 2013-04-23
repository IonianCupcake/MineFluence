package ioniancupcake.common.gui.guis;

import ioniancupcake.common.containers.ContainerModifyTool;
import ioniancupcake.common.gui.recipes.ModifyToolRecipes;
import ioniancupcake.common.lib.ItemIds;
import ioniancupcake.common.lib.Sprites;
import ioniancupcake.common.tileentitys.MultiBlockTileEntity;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;


public class GuiModifyTool  extends GuiContainer
{
	MultiBlockTileEntity entity;
	World world;
	int x, y, z, check = 0;
	boolean guiActive = true;
	GuiButton modify;
	InventoryPlayer inventoryPlayer;

	public GuiModifyTool (InventoryPlayer inventoryPlayer, MultiBlockTileEntity tileEntity, int _x, int _y, int _z, World _world) {
        super(new ContainerModifyTool(inventoryPlayer, tileEntity));
        entity = tileEntity;
        world = _world;
        x = _x;
        y = _y;
        z = _z;
        this.inventoryPlayer = inventoryPlayer;
	}
	
	
	@SuppressWarnings("unchecked")
    @Override
    public void initGui() 
	{
		super.initGui();
		modify = new GuiButton(0, 179, 100, 98, 20, "Modify");
        buttonList.add(modify);
	}

	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		if(guiActive)
		{
        	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.renderEngine.bindTexture(Sprites.GUI_MODIFYING_TOOL);
        	int x = (width - xSize) / 2;
        	int	y = (height - ySize) / 2;
        	this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) 
	{
		if(guiActive)
		{
			fontRenderer.drawString("Modifying Tool", 50, 6, 4210752);
			check = check(entity, world, x, y, z);
			if(check > 0)
			{	
				modify.enabled = true;
			}	
			else
			{
				modify.enabled = false;
			}
		}
	}
	
	public static int check(MultiBlockTileEntity entity, World world, int x, int y, int z)
	{
		if(entity.inv[6] != null)
	    {
	        if(entity.inv[6].itemID == ItemIds.MACHINE_CIRCUIT);
	        {
	        	if(entity.inv[8] == null && entity.inv[7] != null)
	        	{
	        		int metadata = ModifyToolRecipes.recipes().getResult(entity.inv[7].itemID);
	        		if(metadata != -1)
	        		{
	        			return metadata;
	        		}
	        	}
	        
	        	if(entity.inv[8] != null && entity.inv[7] != null)
	        	{
	        		int metadata = ModifyToolRecipes.recipes().getResult(entity.inv[7].itemID, entity.inv[8].itemID);
	        		
	        		if(metadata != -1)
	        		{
	        			return metadata;
	        		}
	        	}
	        }
	    }
		return -1;
		
	}
	
	public static boolean changeMetadata(MultiBlockTileEntity entity, World world, int x, int y, int z)
	{
		if(entity.inv[6] != null)
        {
        	if(entity.inv[6].itemID == ItemIds.MACHINE_CIRCUIT);
        	{
        		if(entity.inv[8] == null && entity.inv[7] != null)
        		{
        			int metadata = ModifyToolRecipes.recipes().getResult(entity.inv[7].itemID);
        			if(metadata != -1)
        			{
        				world.setBlockMetadataWithNotify(x, y, z, metadata, 0);
        				return true;
        			}
        		}
        	
        		if(entity.inv[8] != null && entity.inv[7] != null)
        		{
        			int metadata = ModifyToolRecipes.recipes().getResult(entity.inv[7].itemID, entity.inv[8].itemID);
        			
        			if(metadata != -1)
        			{
        				world.setBlockMetadataWithNotify(x, y, z, metadata, 0);
        				return true;
        			}
        		}
        	}
        }
		return false;
	}
	
	protected void actionPerformed(GuiButton par1GuiButton)
    {
        switch (par1GuiButton.id)
        {
            case 0:
                if(changeMetadata(entity, world, x, y, z))
                {
                	this.mc.displayGuiScreen((GuiScreen)null);
                    this.mc.setIngameFocus();
                    this.mc.sndManager.resumeAllSounds();
                }
                break;
                
            default:
                break;        
        }
    }

}
