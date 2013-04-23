package ioniancupcake.common.handler;

import ioniancupcake.common.containers.ContainerBiosphere;
import ioniancupcake.common.containers.ContainerModifyTool;
import ioniancupcake.common.gui.guis.GuiBiosphere;
import ioniancupcake.common.gui.guis.GuiModifyTool;
import ioniancupcake.common.tileentitys.MultiBlockTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandlerMineFluence implements IGuiHandler 
{
	private MultiBlockTileEntity tileEntity;

	@Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) 
	{
		tileEntity = (MultiBlockTileEntity) world.getBlockTileEntity(x, y, z); 
        if(id == 0)
        {
            return new ContainerBiosphere(player.inventory, tileEntity, id);
        }
        
        if(id == 1)
        {
        	return new ContainerModifyTool(player.inventory, tileEntity);
        }
        return null;
    }
	
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) 
    {
        tileEntity = (MultiBlockTileEntity) world.getBlockTileEntity(x, y, z); 
        if(id == 0)
        {
            return new GuiBiosphere(player.inventory, tileEntity, id, x, y, z, world);
        }
        
        if(id == 1)
        {
        	return new GuiModifyTool(player.inventory, tileEntity, x, y, z, world);
        }
        return null;

}
}