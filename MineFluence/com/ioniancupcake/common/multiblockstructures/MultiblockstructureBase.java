package multiblockstructures;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tileentitys.BacteriaContainerTileEntity;
import tileentitys.CardSlotTileEntity;
import tileentitys.TileEntityBiosphere;

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
