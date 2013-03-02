package MineFluence.com.ioniancupcake.common.blocks.multiblockstructures;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import MineFluence.MineFluence;
import MineFluence.com.ioniancupcake.common.blocks.Multiblockstructureblock;
import MineFluence.com.ioniancupcake.common.tileentitys.BacteriaContainerTileEntity;
import MineFluence.com.ioniancupcake.common.tileentitys.CardSlotTileEntity;

public class BacteriaContainer extends Multiblockstructureblock
{

	public BacteriaContainer(int par1) {
		super(par1, 5, 0);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		if(par1World.isRemote)
		{
			return true;
		}
		if(par5EntityPlayer.isSneaking())
		{
			return false;
		}
		
		ItemStack stack = par5EntityPlayer.getHeldItem();
		BacteriaContainerTileEntity te = (BacteriaContainerTileEntity) par1World.getBlockTileEntity(par2, par3, par4);
			
		if(stack != null && te.inv[0] == null)
		{
			if(stack.itemID == MineFluence.yellowBacteria.itemID || stack.itemID == MineFluence.redBacteria.itemID || stack.itemID == MineFluence.greenBacteria.itemID || stack.itemID == MineFluence.MinefluenceEssence.itemID)
			{
				te.inv[0] = stack.copy();
				stack.stackSize = 0;
				return true;
			}
		}
		else if(te.inv[0] != null)
		{
			par5EntityPlayer.dropItem(te.inv[0].itemID, te.inv[0].stackSize);
			te.inv[0] = null;
		}
		return true;
    }
	
	@Override
	public TileEntity createNewTileEntity(World par1World)
	{
		return new BacteriaContainerTileEntity();
	}

}
