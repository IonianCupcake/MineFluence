package ioniancupcake.common.multiblockstructures;

import ioniancupcake.common.tileentitys.MultiBlockTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MultiblockstructureBase 
{
	public World world;
	public MultiBlockTileEntity cste;
	public MultiBlockTileEntity bcte;
	public MultiBlockTileEntity teb;
	public int x, y, z, countx, county, countz;
	
	public MultiblockstructureBase(TileEntity cardSlot, TileEntity display, TileEntity bacteriaContainer, World par6World, int x, int y, int z, int countx, int county, int countz)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.countx = countx;
		this.county = county;
		this.countz = countz;
		world = par6World;
		
		for(int i = 0; i<=countx; i++)
		{
			for(int j = 0; j<=county; j++)
			{
				for(int k = 0; k<=countz; k++)
				{
					if(world.getBlockTileEntity(x+i, y+j, z+k) instanceof MultiBlockTileEntity)
					{
						MultiBlockTileEntity entity = (MultiBlockTileEntity) world.getBlockTileEntity(x+i, y+j, z+k);					
						entity.base = this;
					}
				}
			}
		}
	}
	
	public void destroyMultiBlock()
	{
		for(int i = 0; i<=countx; i++)
		{
			for(int j = 0; j<=county; j++)
			{
				for(int k = 0; k<=countz; k++)
				{
					if(world.getBlockTileEntity(x+i, y+j, z+k) instanceof MultiBlockTileEntity)
					{
						MultiBlockTileEntity entity = (MultiBlockTileEntity) world.getBlockTileEntity(x+i, y+j, z+k);
						entity.base = null;
						entity.guiId = 20;
						int metadata = world.getBlockMetadata(x+i, y+j, z+k);
						world.setBlockMetadataWithNotify(x+i, y+j, z+k, metadata-1, 0);
					}
				}
			}
		}
	}
}
