package multiblockstructures;

import main.MineFluence;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tileentitys.BacteriaContainerTileEntity;
import tileentitys.CardSlotTileEntity;
import tileentitys.TileEntityBiosphere;

public class Multiblockstructure 
{
	int[] blocksInMbs;
	int x, y, z;
	CardSlotTileEntity[] cardSlots = new CardSlotTileEntity[1000];
	TileEntityBiosphere[] displays = new TileEntityBiosphere[1000];
	BacteriaContainerTileEntity[] bacteriaContainers = new BacteriaContainerTileEntity[1000];
	TileEntity cardSlot, display, bacteriaContainer;
	int intBuildingBlockCount = 0, intMachineBlockCount = 0, intCardSlotCount = 0, intDisplayCount = 0, intBacteriaContainerCount = 0;
	
	public Multiblockstructure(int[] var1, int var2, int var3, int var4, World var5World, CardSlotTileEntity[] var6, TileEntityBiosphere[] var7, BacteriaContainerTileEntity[] var8)
	{
		blocksInMbs = var1;
		
		cardSlots = var6;
		displays = var7;
		bacteriaContainers = var8;
		
		x = var2;
		y = var3;
		z = var4;
		
		checkForStructure(var5World);
	}
	
	public void checkForStructure(World par1World)
	{
		for(int i = 0; i<blocksInMbs.length; i++)
		{
			
			if(blocksInMbs[i] == MineFluence.buildingBlock.blockID)
			{
				intBuildingBlockCount++;
			}
			
			if(blocksInMbs[i] == MineFluence.machineBlock.blockID)
			{
				intMachineBlockCount++;
			}
		}
		System.out.println(cardSlots[0]);
		System.out.println(displays[0]);
		System.out.println(bacteriaContainers[0]);
		
		intCardSlotCount = getTileEntitysInArray(cardSlots);
		intDisplayCount = getTileEntitysInArray(displays);
		intBacteriaContainerCount = getTileEntitysInArray(bacteriaContainers);
		System.out.println("CS: " + intCardSlotCount);
		System.out.println("DP: " + intDisplayCount);
		System.out.println("BC: " + intBacteriaContainerCount);
		System.out.println("BB: " + intBuildingBlockCount);
		System.out.println("MB: " + intMachineBlockCount);
		
		if(intBuildingBlockCount >= 10 && intMachineBlockCount == 1 && intCardSlotCount == 1 && intDisplayCount == 1 && intBacteriaContainerCount == 1)
		{
			MultiblockstructureBiosphere MbsB = new MultiblockstructureBiosphere(cardSlots[0], displays[0], bacteriaContainers[0], par1World);
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
}
