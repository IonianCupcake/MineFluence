package MineFluence.com.ioniancupcake.common.multiblockstructures;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import MineFluence.com.ioniancupcake.common.helper.Coordinate;
import MineFluence.com.ioniancupcake.common.tileentitys.BacteriaContainerTileEntity;
import MineFluence.com.ioniancupcake.common.tileentitys.CardSlotTileEntity;
import MineFluence.com.ioniancupcake.common.tileentitys.TileEntityBiosphere;

public class MultiblockstructureBase 
{
	public World world;
	public CardSlotTileEntity cste;
	public BacteriaContainerTileEntity bcte;
	public TileEntityBiosphere teb;
	
	public MultiblockstructureBase(TileEntity cardSlot, TileEntity display, TileEntity bacteriaContainer, World par6World)
	{
		
	}
}
