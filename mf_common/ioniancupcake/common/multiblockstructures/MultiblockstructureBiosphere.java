package ioniancupcake.common.multiblockstructures;

import ioniancupcake.common.lib.GuiIds;
import ioniancupcake.common.tileentitys.MultiBlockTileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MultiblockstructureBiosphere extends MultiblockstructureBase
{
	MultiblockstructureBiosphere mbsB; 
	MultiBlockTileEntity tbe;

	public MultiblockstructureBiosphere(MultiBlockTileEntity cardSlot, MultiBlockTileEntity display, MultiBlockTileEntity bacteriaContainer, World par6World, int x, int y, int z, int countx, int county, int countz) 
	{
		super(cardSlot, display, bacteriaContainer, par6World, x, y, z, countx, county, countz);
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
		tbe.guiId = GuiIds.BIOSPHERE_GUI_ID;
	}
	
	public ItemStack getCards()
	{
		return cste.inv[0];
	}
	
	public ItemStack getBacterias()
	{
		return bcte.inv[0];
	}
	
	public void decreaseBacterias()
	{
		bcte.inv[0].stackSize--;
	}

}
