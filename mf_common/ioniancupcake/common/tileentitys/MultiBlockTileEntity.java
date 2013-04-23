package ioniancupcake.common.tileentitys;

import ioniancupcake.common.gui.guis.GuiModifyTool;
import ioniancupcake.common.gui.recipes.BiosphereRecipes;
import ioniancupcake.common.helper.LogHelper;
import ioniancupcake.common.lib.Gui;
import ioniancupcake.common.lib.GuiIds;
import ioniancupcake.common.lib.ItemIds;
import ioniancupcake.common.multiblockstructures.MultiblockstructureBase;
import ioniancupcake.common.multiblockstructures.MultiblockstructureBiosphere;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class MultiBlockTileEntity extends TileEntity implements IInventory {

    public boolean inUse = false;
	public ItemStack[] inv;
    public MultiblockstructureBiosphere MbsB;
    public MultiblockstructureBase base;
    public int guiId = 20;
    public int cookTime = 0;
    public int combineTime = 0;
    public boolean masterBlock = false;
    private static String player = null;
    public String inv1 = new String("No Bacteria!");
    public String inv2 = new String("No Environmentcard!");
    public int metadata = 0;
    private boolean changeMetadata = true;
    public int[] masterCoords = new int[3];
    public boolean firstTick = true;
    
    
    public void setMultiblockstructure(MultiblockstructureBiosphere mbsb)
    {
    	MbsB = mbsb;
    }
    
    public static String getPlayer()
    {
    	return player;
    }
    
    public static void setPlayer(String var1)
    {
    	player = var1;
    }

    public MultiBlockTileEntity()
    {
        setInv(new ItemStack[9]);
    }
    
    
    
    @Override
    public int getSizeInventory() {
            return getInv().length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
            return getInv()[slot];
    }
    
    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
            LogHelper.debugLog(stack);
            if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                    stack.stackSize = getInventoryStackLimit();
            }    
            getInv()[slot] = stack;
    }

    @Override
    public ItemStack decrStackSize(int slot, int amt) {
        LogHelper.debugLog("decrStackSize by " + amt);
            ItemStack stack = getStackInSlot(slot);
            if (stack != null) {
                    if (stack.stackSize <= amt) {
                            setInventorySlotContents(slot, null);
                    } else {
                            stack = stack.splitStack(amt);
                            if (stack.stackSize == 0) {
                                    setInventorySlotContents(slot, null);
                            }
                            else
                            {
                                setInventorySlotContents(slot, stack);
                            }
                    }
            }
            return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
            ItemStack stack = getStackInSlot(slot);
            if (stack != null) {
                    setInventorySlotContents(slot, null);
            }
            return stack;
    }
    
    @Override
    public int getInventoryStackLimit() {
            return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
            return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this;
    }

    @Override
    public void openChest() {}

    @Override
    public void closeChest() {}
    
    /*
    @Override
    public boolean canInsertSide(int i, ItemStack itemstack) {

        return true;
    }
    */
    
    public void readFromNBT(NBTTagCompound tagCompound) {
            super.readFromNBT(tagCompound);
            masterBlock = tagCompound.getBoolean("MasterBlock");
            masterCoords = tagCompound.getIntArray("MasterBlockCoords");
            
            
            NBTTagList tagList = tagCompound.getTagList("Inventory");
            for (int i = 0; i < tagList.tagCount(); i++) {
                    NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
                    byte slot = tag.getByte("Slot");
                    if (slot >= 0 && slot < getInv().length) {
                            getInv()[slot] = ItemStack.loadItemStackFromNBT(tag);
                    }
            }
    }

    public void writeToNBT(NBTTagCompound tagCompound)
    {
            super.writeToNBT(tagCompound);
            tagCompound.setBoolean("MasterBlock", masterBlock);
            if(!masterBlock)
            {
            	tagCompound.setIntArray("MasterBlockCoords", masterCoords);
            }
            tagCompound.setInteger("GuiID", guiId);
            	
            	NBTTagList itemList = new NBTTagList();
            	for (int i = 0; i < getInv().length; i++)
            	{
            		ItemStack stack = getInv()[i];
            		if (stack != null) 
                    {
                            NBTTagCompound tag = new NBTTagCompound();
                            tag.setByte("Slot", (byte) i);
                            stack.writeToNBT(tag);
                            itemList.appendTag(tag);
                    }
            	}
              	tagCompound.setTag("Inventory", itemList);
     }

	@Override
	public String getInvName() {
		return "Multiblockstructure";
	}
	
	private boolean canSmelt()
    {
        if (this.getInv()[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = BiosphereRecipes.smelting().getSmeltingResult(this.getInv()[0]);
            if (var1 == null) {return false;}
            if(this.getInv()[2] != null)
            {
            	if (!this.getInv()[2].isItemEqual(var1)) 
            	{
            		return false;
            	}
            	int result = getInv()[2].stackSize + var1.stackSize;
                return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
            }
            return true;
        }
    }

	public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack var1 = BiosphereRecipes.smelting().getSmeltingResult(this.getInv()[1]);

            if (this.getInv()[2] == null)
            {
                this.getInv()[2] = var1.copy();
            }
            else if (this.getInv()[2].isItemEqual(var1))
            {
                getInv()[2].stackSize += var1.stackSize;
            }

            --this.getInv()[0].stackSize;

            if (this.getInv()[0].stackSize <= 0)
            {
                this.getInv()[0] = null;
            }
        }
    }
	
	
	public void updateEntity()
	{
		inUse = true;
		
		
		if(worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 0 && changeMetadata)
		{
			changeMetadata = !GuiModifyTool.changeMetadata(this, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		}
		
		if(firstTick) 
		{
			onFirstTick();
		}
		
		
		//if(getInv()[0] != null && canSmelt())
		//{
		//	if(cookTime == 2)
		//	{
		//		this.smeltItem();
		//		cookTime = 0;
		//	}
		//	cookTime++;
		//}
		//else
		//{
		//	cookTime = 0;
		//}
		
		
		if(guiId == GuiIds.BIOSPHERE_GUI_ID)
		{
			if (this.getInv()[2] != null && this.getInv()[1] != null && canCombine())
			{
				if(combineTime == Gui.BIOSPHERE_COOKING_TIME)
				{
					this.combineItem();
					combineTime = 0;
				}
				combineTime++;
			}
		}
		
	}
	
	public boolean canCombine()
	{
		if (this.getInv()[2] == null || this.getInv()[1] == null)
        {
            return false;
        }
		
        if(getInv()[2].itemID == ItemIds.MINEFLUENCE_BACTERIA)
        {
            ItemStack var1 = BiosphereRecipes.smelting().getCombineResult(this.getInv()[1]);
            if (var1 == null) {return false;}
            if(this.getInv()[3] != null)
            {
            	if (!this.getInv()[3].isItemEqual(var1)) 
            	{
            		return false;
            	}
            	
            	int result = getInv()[3].stackSize + var1.stackSize;
                return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
            }
            return true;
        }
		return false;
	}
	
	public void combineItem()
	{
		if (this.getInv()[2] != null || this.getInv()[1] != null)
		{
			if (this.canCombine())
	        {
				if (this.getInv()[0] == null)
				{
					this.getInv()[0] = BiosphereRecipes.smelting().getCombineResult(getInv()[1]).copy();
					if(getInv()[1].itemID != ItemIds.DUPLICATIONCARD)
					{
						getInv()[2].stackSize--;
						
					}
		        }
		        else if (this.getInv()[0].itemID == BiosphereRecipes.smelting().getCombineResult(getInv()[1]).itemID && getInv()[0].stackSize < 64)
		        {
		        	getInv()[0].stackSize++;
		        	if(getInv()[1].itemID != ItemIds.DUPLICATIONCARD)
					{
						getInv()[2].stackSize--;
					}
		        } 
	        }
				
		}
	}

	public ItemStack[] getInv() {
		return inv;
	}

	public void setInv(ItemStack[] inv) {
		this.inv = inv;
	}
	
	public void onFirstTick()
	{
		if((worldObj.getBlockMetadata(xCoord, yCoord, zCoord)%2) != 0)
		{
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, worldObj.getBlockMetadata(xCoord, yCoord, zCoord)-1, 5);
		}
		firstTick = false;
	}

    @Override
    public boolean isInvNameLocalized()
    {
        return false;
    }

    @Override
    public boolean isStackValidForSlot(int i, ItemStack itemstack)
    {
        return true;
    }
}