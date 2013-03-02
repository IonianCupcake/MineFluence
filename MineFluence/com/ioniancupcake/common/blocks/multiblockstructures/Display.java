package blocks.multiblockstructures;

import main.MineFluence;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tileentitys.TileEntityBiosphere;
import blocks.Multiblockstructureblock;

public class Display extends Multiblockstructureblock
{

	public Display(int par1, int par2, int par3) 
	{
		super(par1, par2, par3);
	}
	
	public TileEntity createNewTileEntity(World par1World)
	{
		return new TileEntityBiosphere();
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
		par5EntityPlayer.openGui(MineFluence.instance, 0, par1World, par2, par3, par4);
		return true;
	}
}
