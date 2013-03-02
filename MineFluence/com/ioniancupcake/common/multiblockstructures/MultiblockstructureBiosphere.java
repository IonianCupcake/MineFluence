package multiblockstructures;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tileentitys.BacteriaContainerTileEntity;
import tileentitys.CardSlotTileEntity;
import tileentitys.TileEntityBiosphere;

public class MultiblockstructureBiosphere extends MultiblockstructureBase
{
	MultiblockstructureBiosphere mbsB; 
	TileEntityBiosphere tbe;

	public MultiblockstructureBiosphere(CardSlotTileEntity cardSlot, TileEntityBiosphere display, BacteriaContainerTileEntity bacteriaContainer, World par6World) 
	{
		super(cardSlot, display, bacteriaContainer, par6World);
		System.out.println("Biosphere created!");
		
		if(display != null)
		{
			tbe = display;
		}
		if(cardSlot != null)
		{
			cste = cardSlot;
		}
		if(bacteriaContainer != null)
		{
			bcte = bacteriaContainer;
		}
		
	}
	
	public void initialize(MultiblockstructureBiosphere mbs)
	{
		if(tbe != null)
		{
			tbe.setMultiblockstructure(mbs);
		}
		tbe.guiId = 0;
	}
	
	public ItemStack getCards()
	{
		
		return cste.inv[0];
	}
	
	public ItemStack getBacterias()
	{
		return bcte.inv[0];
	}

}
