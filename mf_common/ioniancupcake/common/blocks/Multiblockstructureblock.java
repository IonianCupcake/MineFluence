package ioniancupcake.common.blocks;

import ioniancupcake.common.gui.guis.GuiModifyTool;
import ioniancupcake.common.helper.LogHelper;
import ioniancupcake.common.lib.BlockIds;
import ioniancupcake.common.lib.GuiIds;
import ioniancupcake.common.lib.ItemIds;
import ioniancupcake.common.lib.Reference;
import ioniancupcake.common.main.MineFluence;
import ioniancupcake.common.multiblockstructures.Multiblockstructure;
import ioniancupcake.common.multiblockstructures.MultiblockstructureBase;
import ioniancupcake.common.tileentitys.MultiBlockTileEntity;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class Multiblockstructureblock extends BlockContainer
{
	
	int textureTopBot, textureFront, textureActivatedTopBot, textureActivatedFront, x, y, z, neighborMbsBlocks;
	public MultiblockstructureBase mbs;
	public MultiBlockTileEntity[] cardSlots = new MultiBlockTileEntity[1000];
	public MultiBlockTileEntity[] bacteriaContainers = new MultiBlockTileEntity[1000];
	public MultiBlockTileEntity[] displays = new MultiBlockTileEntity[1000];
	int cardSlotsCount = 0, bacteriaContainersCount = 0, displaysCount = 0, machineBlockCount = 0, buildingBlockCount = 0;
	int metadata;
	boolean spitOutInventory = true;
    private Icon[] iconArray;
    private String[] names = {"Building Block", "Activated Building Block", "Machineblock", "Activated Machineblock", "Display", "Activated Display", "Bacteriacontainer", "Activated Bacteriacontainer", "Cardslot", "Activated Cardslot"};
    Icon icon;
	
	
	public Multiblockstructureblock(int par1)
	{
		super(par1, Material.rock);
        this.setCreativeTab(MineFluence.tab);
        
	}
	
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
	    return par9;
	}
	
	
	@Override
	public int damageDropped(int par1)
	{
		return 0;
	}

	
	@Override
	public TileEntity createNewTileEntity(World par1World) 
	{
		return new MultiBlockTileEntity();
	}
	
	
	protected void dropItems(World world, int x, int y, int z)
	{
		if(spitOutInventory)
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
                    	   entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
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
	 
	 public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	    {
		 	metadata = world.getBlockMetadata(x, y, z);
	        return false;
	    }
	 
	 public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	 {
		 int metadata = par1World.getBlockMetadata(par2, par3, par4);
		 if(par1World.isRemote)
		 {
			 return true;
		 }
		 if(par5EntityPlayer.isSneaking())
		 {
			 return false;
		 }
		 
		 
		 if((metadata % 2) == 0)
		 {
			 structure(par1World, par2, par3, par4);
		 }
		
		  if(metadata == 0 && par5EntityPlayer.getHeldItem() != null)
		 {
			 if(par5EntityPlayer.getHeldItem().itemID == ItemIds.MODIFYING_TOOL)
			 {
				 par5EntityPlayer.openGui(MineFluence.instance, GuiIds.MODIFYING_TOOL_GUI_ID, par1World, par2, par3, par4);
				 spitOutInventory = true;
				 return true;
			 }
		 }
		 
		 if(metadata == 5)
		 {
			 MultiBlockTileEntity tileEntity = (MultiBlockTileEntity) par1World.getBlockTileEntity(par2, par3, par4);
			 spitOutInventory = true;
			 par5EntityPlayer.openGui(MineFluence.instance, tileEntity.guiId, par1World, par2, par3, par4);
			 return true;
		 }
		 
		 spitOutInventory = true;
		 return false;
	 }
	 
	 @Override
	 public Icon getBlockTextureFromSideAndMetadata(int side, int metadata)
	 {   
	     int switsch = 0;
		 if (side == 0 || side == 1)
		 {
			 if(metadata % 2 == 0)
			 {
				 switsch = 0;
			 }
			 else
			 {
			     switsch = 1;
			 }
		 }
		 else
		 {
			 switch(metadata)
			 {
			 	case 0: {switsch = 0;}break;
			 	case 1: {switsch = 1;}break;
			 	case 2: {switsch = 2;}break;
			 	case 3: {switsch = 2;}break;
			 	case 4: {switsch = 3;}break;
			 	case 5: {switsch = 3;}break;
			 	case 6: {switsch = 4;}break;
			 	case 7: {switsch = 4;}break;
			 	case 8: {switsch = 5;}break;
			 	case 9: {switsch = 5;}break;
			 	case 10: {switsch = 0;}break;
			 	case 11: {switsch = 0;}break;
			 	case 12: {switsch = 0;}break;
			 	case 13: {switsch = 0;}break;
			 	case 14: {switsch = 0;}break;
			 	case 15: {switsch = 0;}break;
			 }
		 }
		 
	     icon = iconArray[switsch];
		 if(icon == null)
		 {
		     icon = iconArray[0];
		 }
		 return icon;
	 }
	 
	 @Override
	 public void registerIcons(IconRegister par1IconRegister)
	    {
	        this.iconArray = new Icon[16];
	        LogHelper.debugLog("Registering Icons");
	        for (int i = 0; i < 6; ++i)
	        {
	            this.iconArray[i] = par1IconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "multiblock_" + i);
	        }
	    }
	 
	 @Override
     public void breakBlock(World world, int x, int y, int z, int par5, int par6) 
	 {
             this.dropItems(world, x, y, z);
             MultiBlockTileEntity entity = (MultiBlockTileEntity) world.getBlockTileEntity(x, y, z);
             if(entity.base != null)
             {
            	 entity.base.destroyMultiBlock();
             }
             super.breakBlock(world, x, y, z, par5, par6);
     }
	 
	 
	 public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) 
	 {
		 x = par2;
		 y = par3;
		 z = par4;
		 if((par1World.getBlockMetadata(par2, par3, par4) % 2)  == 0)
			 structure(par1World, par2, par3, par4);
		 par1World.scheduleBlockUpdate(par2, par3, par4, blockID, 5*20);
	 }
	 
	 public void onBlockAdded(World par1World, int par2, int par3, int par4)
	 {
		x = par2;
		y = par3;
		z = par4;
		if((par1World.getBlockMetadata(par2, par3, par4) % 2)  == 0)
			GuiModifyTool.changeMetadata((MultiBlockTileEntity) par1World.getBlockTileEntity(par2, par3, par4), par1World, par2, par3, par4);
		par1World.scheduleBlockUpdate(par2, par3, par4, blockID, 3*20);
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
					 var1[var1Count] = par2World.getBlockMetadata(par1[0]+k, par1[1]+j, par1[2]+i);
					 int id = par2World.getBlockId(par1[0]+k, par1[1]+j, par1[2]+i);
					 
					 if(var1[var1Count] == 8 && id == BlockIds.MACHINEPARTS)
					 {
						 cardSlots[cardSlotsCount] = (MultiBlockTileEntity) par2World.getBlockTileEntity(par1[0]+k,  par1[1]+j, par1[2]+i);
						 cardSlotsCount++;
					 }
					 if(var1[var1Count] == 6 && id == BlockIds.MACHINEPARTS)
					 {
						 bacteriaContainers[bacteriaContainersCount] = (MultiBlockTileEntity) par2World.getBlockTileEntity(par1[0]+k,  par1[1]+j, par1[2]+i);
						 bacteriaContainersCount++;
					 }
					 if(var1[var1Count] == 4 && id == BlockIds.MACHINEPARTS)
					 {
						 displays[displaysCount] = (MultiBlockTileEntity) par2World.getBlockTileEntity(par1[0]+k,  par1[1]+j, par1[2]+i);
						 displaysCount++;
					 }
					 if(var1[var1Count] == 2 && id == BlockIds.MACHINEPARTS)
					 {
						 machineBlockCount++;
					 }
					 if(var1[var1Count] == 0 && id == BlockIds.MACHINEPARTS)
					 {
						 buildingBlockCount++;
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
			 if(var1 == BlockIds.MACHINEPARTS)
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
			 if(var1 == BlockIds.MACHINEPARTS)
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
			 if(var1 == BlockIds.MACHINEPARTS)
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
		 if(getNeighborBlockCount(par1World, x, y, z, BlockIds.MACHINEPARTS) == 3)
		 {
			 int[] var1 = checkForStructure(x, y, z, par1World);
			 if(var1 != null)
			 {
				 int[] var2 = getBlocksInCoords(var1, par1World);
				 cardSlotsCount = 0;
				 displaysCount = 0;
				 bacteriaContainersCount = 0;
				 new Multiblockstructure(var2, var1[0], var1[1], var1[2], par1World, cardSlots, displays, bacteriaContainers, var1, buildingBlockCount, machineBlockCount);
			 }
		 }
	 }
	 
	@SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
	 public void getSubBlocks(int par1, CreativeTabs par2Tab, List par3List)
	 {
	     LogHelper.debugLog("SubBlocks requested");
		 for(int i = 0; i < 10; i++)
		 {
			 ItemStack stack = new ItemStack(this, 1, i);
			 stack.setItemName(this.names[i]);
             par3List.add(stack);
		 }
	 }
	 
}
