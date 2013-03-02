package MineFluence.com.ioniancupcake.common.handler;

import MineFluence.com.ioniancupcake.common.containers.ContainerBiosphere;
import MineFluence.com.ioniancupcake.common.tileentitys.TileEntityBiosphere;
import MineFluence.com.ioniancupcake.src.guis.GuiBiosphere;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandlerMineFluence implements IGuiHandler 
{

	@Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(tileEntity instanceof TileEntityBiosphere){
                    return new ContainerBiosphere(player.inventory, (TileEntityBiosphere) tileEntity);
            }
            return null;
    }
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(tileEntity instanceof TileEntityBiosphere){
                    return new GuiBiosphere(player.inventory, (TileEntityBiosphere) tileEntity);
            }
            return null;

}
}