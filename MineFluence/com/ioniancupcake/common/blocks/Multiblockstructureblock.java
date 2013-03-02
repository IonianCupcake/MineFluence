package blocks;

import java.util.List;
import java.util.Random;

import main.MineFluence;
import multiblockstructures.Multiblockstructure;
import multiblockstructures.MultiblockstructureBase;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tileentitys.BacteriaContainerTileEntity;
import tileentitys.CardSlotTileEntity;
import tileentitys.TileEntityBiosphere;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Multiblockstructureblock extends BlockContainer
{
	
	int textureTopBot, textureFront, textureActivatedTopBot, textureActivatedFront, x, y, z, neighborMbsBlocks;
	public MultiblockstructureBase mbs;
	public CardSlotTileEntity[] cardSlots = new CardSlotTileEntity[1000];
	public BacteriaContainerTileEntity[] bacteriaContainers = new BacteriaContainerTileEntity[1000];
	public TileEntityBiosphere[] displays = new TileEntityBiosphere[1000];
	int cardSlotsCount = 0, bacteriaContainersCount = 0, displaysCount = 0, machineBlockCount = 0, buildingBlockCount = 0;
	
	
	
	public Multiblockstructureblock(int par1, int par2, int par3, int par4, int par5)
	{
		super(par1, 0, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		textureTopBot = par3;
		textureFront = par2;
		textureActivatedTopBot = par4;
		textureActivatedFront = par5;
	}
	
	public Multiblockstructureblock(int par1, int par2, int par3)
	{
		super(par1, 0, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		textureTopBot = par3;
		textureFront = par2;
	}
	
	public int damageDropped(int par14)
	{
		return 0;
	}

	
	@Override
	public TileEntity createNewTileEntity(World par1World) 
	{
		return null;
	}
	
	
	protected void dropItems(World world, int x, int y, int z)
	{
        Random rand = new Random();

        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (!(tileEntity instanceof IInventory)) {
                return;
        }
        IInventory inventory = (IInventory) tileEntity;

        for (int i = 0; i < inventory.getSizeInventory(); i++)
        {
                ItemStack item = inventory.getStackInSlot(i);

                if (item != null && item.stackSize > 0) 
                {
                       float rx = rand.nextFloat() * 0.8F + 0.1F;
                       float ry = rand.nextFloat() * 0.8F + 0.1F;
                       float rz = rand.nextFloat() * 0.8F + 0.1F;

                       EntityItem entityItem = new EntityItem(world,x + rx, y + ry, z + rz,new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

                       if (item.hasTagCompound()) 
                       {
                    	   entityItem.func_92014_d().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                       }

                       float factor = 0.05F;
                       entityItem.motionX = rand.nextGaussian() * factor;
                       entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                       entityItem.motionZ = rand.nextGaussian() * factor;
                       world.spawnEntityInWorld(entityItem);
                       item.stackSize = 0;
                }
        }
	}
	
	
	public String getTextureFile(){
		 return "/MineFluence/com/ioniancupcake/src/textures/blocks/Blocks.png";
	 }
    
	
    public boolean renderAsNormalBlock()
		{
    		return false;
		}
	
    
	protected boolean canSilkHarvest()
		{
	        return true;
	    }
	
	
	 public boolean isOpaqueCube()
	    {
	        return false;
	    }
	 
	 
	 public int getRenderBlockPass()
	    {
	        return 0;
	    }
	 
	 public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	 {
		 structure(par1World, par2, par3, par4);
		 return true;
	 }
	 
	 
	 public int getBlockTextureFromSideandMetadata(int par1, int par2)
	 {
		 if(par2 == 0)
		 {
			 switch(par1)
	   	 	{
	   	 		case 0: return textureTopBot;
	   	 		case 1: return textureTopBot;
	   	 		default: return textureFront;
	   	 	}
		 }
		 
		 if(par2 == 1)
		 {
			switch(par1)
		   	{
		   		case 0: return textureActivatedTopBot;
		   		case 1: return textureActivatedTopBot;
		   		default: return textureActivatedFront;
		   	}
		 }
		 
		 return 0;
	 }
	 
	 
	 @Override
     public void breakBlock(World world, int x, int y, int z, int par5, int par6) 
	 {
             this.dropItems(world, x, y, z);
             super.breakBlock(world, x, y, z, par5, par6);
     }
	 
	 
	 public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) 
	 {
		 //structure(par1World);
		 par1World.scheduleBlockUpdate(par2, par3, par4, blockID, 5*20);
	 }
	 
	 
	 public void onBlockAdded(World par1World, int par2, int par3, int par4)
	 {
		x = par2;
		y = par3;
		z = par4;
		par1World.scheduleBlockUpdate(par2, par3, par4, blockID, 3*20);
	 }
	 
	 
	 public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	 {
		 //structure(par1World);
		 
	 }
	 
	 
	 public int[] getBlocksInCoords(int[] par1, World par2World) 
	 {
		 int[] var1 = new int[1000];
		 int var1Count = 0;
		 
		 for(int i = 0; i<=par1[3]+1; i++)
		 {
			 for(int j = 0; j<=par1[4]+1; j++)
			 {
				 for(int k = 0; k<=par1[5]+1; k++)
				 {
					 var1[var1Count] = par2World.getBlockId(par1[0]+k, par1[1]+j, par1[2]+i);
					 
					 if(var1[var1Count] == MineFluence.cardSlot.blockID)
					 {
						 System.out.println("Card Slot");
						 cardSlots[cardSlotsCount] = (CardSlotTileEntity) par2World.getBlockTileEntity(par1[0]+k,  par1[1]+j, par1[2]+i);
						 cardSlotsCount++;
					 }
					 if(var1[var1Count] == MineFluence.bacteriaContainer.blockID)
					 {
						 System.out.println("Bacterias Container");
						 bacteriaContainers[bacteriaContainersCount] = (BacteriaContainerTileEntity) par2World.getBlockTileEntity(par1[0]+k,  par1[1]+j, par1[2]+i);
						 bacteriaContainersCount++;
					 }
					 if(var1[var1Count] == MineFluence.display.blockID)
					 {
						 System.out.println("Display");
						 displays[displaysCount] = (TileEntityBiosphere) par2World.getBlockTileEntity(par1[0]+k,  par1[1]+j, par1[2]+i);
						 displaysCount++;
					 }
					 var1Count++;
				 }
			 }
		 }
		 return var1;
	 }

	 
	public int getNeighborBlockCount(World par1World, int par2, int par3, int par4, int par5)
	 {
		 int count = 0;
		 
		 int var1 = par1World.getBlockId(par2+1, par3, par4);
		 int var2 = par1World.getBlockId(par2-1, par3, par4);
		 int var3 = par1World.getBlockId(par2, par3+1, par4);
		 int var4 = par1World.getBlockId(par2, par3-1, par4);
		 int var5 = par1World.getBlockId(par2, par3, par4+1);
		 int var6 = par1World.getBlockId(par2, par3, par4-1);
		 
		 if (var1 == par5)
			count++;
		 if (var2 == par5)
			count++;
		 if (var3 == par5)
			count++;
		 if (var4 == par5)
			count++;
		 if (var5 == par5)
			count++;
		 if (var6 == par5)
			count++;
		 return count;
	 }
	
	
	 public int[] checkForStructure(int par1, int par2, int par3, World par4World)
	 {
		 boolean test = true;
		 int count = 0;
		 int county =  0;
		 int countz = 0;
		 for(int i = 1; i<=10 && test; i++)
		 {
			 int var1 = par4World.getBlockId(par1+i, par2, par3);
			 
			 if(var1 == MineFluence.bacteriaContainer.blockID || var1 == MineFluence.cardSlot.blockID || var1 == MineFluence.buildingBlock.blockID || var1 == MineFluence.machineBlock.blockID || var1 == MineFluence.display.blockID)
			 {
				 	count++;
		     }
			 else if(count < 2)
				return null;
			 
			 else
				 test = false;
		 }
		 test = true;
		 
		 
		 for(int i = 1; i<=10 && test; i++)
		 {
			 int var1 = par4World.getBlockId(par1+i, par2, par3);
			 if(var1 == MineFluence.bacteriaContainer.blockID || var1 == MineFluence.cardSlot.blockID || var1 == MineFluence.buildingBlock.blockID || var1 == MineFluence.machineBlock.blockID || var1 == MineFluence.display.blockID)
			 {
			 	county++;
			 }
			 
			 
			 else if(county < 2)
				return null;
			 
			 else
				 test = false;
		 }
		 test = true;
		 
		 
		 for(int i = 1; i<=10 && test; i++)
		 {
			 int var1 = par4World.getBlockId(par1+i, par2, par3);
			 if(var1 == MineFluence.bacteriaContainer.blockID || var1 == MineFluence.cardSlot.blockID || var1 == MineFluence.buildingBlock.blockID || var1 == MineFluence.machineBlock.blockID || var1 == MineFluence.display.blockID)
			 {
				 	countz++;
			 }
			 else if(countz < 2)
				return null;
			 
			 else
				 test = false;
		 }
		 test = true;
		 
		 int[] result = new int[6];
		 result[0] = par1;
		 result[1] = par2;
		 result[2] = par3;
		 result[3] = count;
		 result[4] = county;
		 result[5] = countz;
		 return result;
	 }
	
	 
	 public void structure(World par1World, int x, int y, int z)
	 {
			 int[] var1 = checkForStructure(x, y, z, par1World);
			 if(var1 != null)
			 {
				 int[] var2 = getBlocksInCoords(var1, par1World);
				 System.out.println(cardSlotsCount);
				 System.out.println(bacteriaContainersCount);
				 System.out.println(displaysCount);
				 cardSlotsCount = 0;
				 displaysCount = 0;
				 bacteriaContainersCount = 0;
				 Multiblockstructure mbs = new Multiblockstructure(var2, var1[0], var1[1], var1[2], par1World, cardSlots, displays, bacteriaContainers);
			 }
	 }
	 
	 @SideOnly(Side.CLIENT)
	 public void getSubBlocks(int par1, CreativeTabs par2Tab, List par3List)
	 {
		 par3List.add(new ItemStack(this, 1, 0));
		 par3List.add(new ItemStack(this, 1, 1));
	 }
}
