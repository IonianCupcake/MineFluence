package ioniancupcake.common.multiblockstructures;

import ioniancupcake.common.tileentitys.MultiBlockTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Multiblockstructure 
{
	int[] blocksInMbs;
	int x, y, z, countx, county, countz;
	MultiBlockTileEntity[] cardSlots = new MultiBlockTileEntity[1000];
	MultiBlockTileEntity[] displays = new MultiBlockTileEntity[1000];
	MultiBlockTileEntity[] bacteriaContainers = new MultiBlockTileEntity[1000];
	TileEntity cardSlot, display, bacteriaContainer;
	int intBuildingBlockCount = 0, intMachineBlockCount = 0, intCardSlotCount = 0, intDisplayCount = 0, intBacteriaContainerCount = 0;
	
	public Multiblockstructure(int[] var1, int var2, int var3, int var4, World var5World, MultiBlockTileEntity[] var6, MultiBlockTileEntity[] var7, MultiBlockTileEntity[] var8, int[] var9, int var10, int var11)
	{
		blocksInMbs = var1;
		
		cardSlots = var6;
		displays = var7;
		bacteriaContainers = var8;
		
		countx = var9[3];
		county = var9[4];
		countz = var9[5];
		
		x = var2;
		y = var3;
		z = var4;
		intBuildingBlockCount = var10;
		intMachineBlockCount = var11;
		
		checkForStructure(var5World);
	}
	
	public void checkForStructure(World par1World)
	{
		intCardSlotCount = getTileEntitysInArray(cardSlots);
		intDisplayCount = getTileEntitysInArray(displays);
		intBacteriaContainerCount = getTileEntitysInArray(bacteriaContainers);
		
		
		if(intBuildingBlockCount >= 22 && intMachineBlockCount >= 1 && intCardSlotCount == 1 && intDisplayCount == 1 && intBacteriaContainerCount == 1)
		{
			activateStructure(x, y, z, countx, county, countz, par1World);
			MultiBlockTileEntity entity = (MultiBlockTileEntity) par1World.getBlockTileEntity(x, y, z);
			entity.masterBlock = true;
			MultiblockstructureBiosphere MbsB = new MultiblockstructureBiosphere(cardSlots[0], displays[0], bacteriaContainers[0], par1World, x, y, z, countx, county, countz);
			MbsB.initialize(MbsB);
		}
	}
	
	public int getTileEntitysInArray(TileEntity[] te){
		int count = 0;
		boolean test = true;
		for(int j = 0; j<te.length && test; j++)
		{
			if(te[j] != null)
			{
				count++;
			}
		}
		return count;
	}
	
	public void activateBlock(int par1x, int par2y, int par3z, World world)
	{
		int metadata = world.getBlockMetadata(par1x, par2y, par3z);
		if((metadata%2) == 0)
		{
			if(world.getBlockTileEntity(par1x, par2y, par3z) instanceof MultiBlockTileEntity)
			{
			MultiBlockTileEntity entity = (MultiBlockTileEntity) world.getBlockTileEntity(par1x, par2y, par3z);
			entity.masterCoords = new int[]{x, y, z};
			world.setBlockMetadataWithNotify(par1x, par2y, par3z, metadata + 1, 0);
			world.setBlockMetadataWithNotify(par1x, par2y, par3z, metadata + 1, 0);
			}
		}
	}
	
	public void activateStructure(int x, int y , int z, int countx, int county, int countz, World world)
	{
		for(int i = 0; i<=countx; i++)
		{
			for(int j = 0; j<=county; j++)
			{
				for(int k = 0; k<=countz; k++)
				{
					activateBlock(x + i, y + j, z + k, world);
				}
			}
		}
	}
}
