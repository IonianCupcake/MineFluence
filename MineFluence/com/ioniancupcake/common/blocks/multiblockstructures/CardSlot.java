package blocks.multiblockstructures;

import main.MineFluence;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tileentitys.CardSlotTileEntity;
import blocks.Multiblockstructureblock;

public class CardSlot extends Multiblockstructureblock
{

	public CardSlot(int par1) 
	{
		super(par1, 4, 0);
	}
	
	@Override
	public TileEntity createNewTileEntity(World par1World)
	{
		return new CardSlotTileEntity();
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
		CardSlotTileEntity te = (CardSlotTileEntity) par1World.getBlockTileEntity(par2, par3, par4);
			
		if(stack != null && te.inv[0] == null)
		{
			if(stack.itemID == MineFluence.desertEnvironmentCard.itemID || stack.itemID == MineFluence.netherEnvironmentCard.itemID || stack.itemID == MineFluence.forestEnvironmentCard.itemID || stack.itemID == MineFluence.duplicateCard.itemID)
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
	
}
