package tileentitys;

import guis.BiosphereRecipes;
import main.MineFluence;
import multiblockstructures.MultiblockstructureBiosphere;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBiosphere extends TileEntity implements IInventory {

    public ItemStack[] inv;
    public MultiblockstructureBiosphere MbsB;
    public int guiId = 20;
    public int cookTime = 0;
    public int combineTime = 0;
    private static String player = null;
    public String inv1 = new String("No Bacteria!");
    public String inv2 = new String("No Environmentcard!");
    
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

    public TileEntityBiosphere()
    {
            setInv(new ItemStack[4]);
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
            getInv()[slot] = stack;
            if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                    stack.stackSize = getInventoryStackLimit();
            }               
    }

    @Override
    public ItemStack decrStackSize(int slot, int amt) {
            ItemStack stack = getStackInSlot(slot);
            if (stack != null) {
                    if (stack.stackSize <= amt) {
                            setInventorySlotContents(slot, null);
                    } else {
                            stack = stack.splitStack(amt);
                            if (stack.stackSize == 0) {
                                    setInventorySlotContents(slot, null);
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
            return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this &&
            player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

    @Override
    public void openChest() {}

    @Override
    public void closeChest() {}
    
    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
            super.readFromNBT(tagCompound);
            
            NBTTagList tagList = tagCompound.getTagList("Inventory");
            for (int i = 0; i < tagList.tagCount(); i++) {
                    NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
                    byte slot = tag.getByte("Slot");
                    if (slot >= 0 && slot < getInv().length) {
                            getInv()[slot] = ItemStack.loadItemStackFromNBT(tag);
                    }
            }
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound)
    {
            super.writeToNBT(tagCompound);
            
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
		return "Biosphere";
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
	
	public void updateEntity(){
		if(guiId == 0)
		{
			ItemStack stack1 = MbsB.getCards();
			ItemStack stack2 = MbsB.getBacterias();
			if(stack1 != null)
			{
				getInv()[1] = stack1.copy();
				inv1 = getInv()[1].getDisplayName();
			}
			
			if(stack2 != null)
			{
				getInv()[2] = stack2.copy();
				inv2 = getInv()[2].getDisplayName();
			}
			
			
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
		
		if (this.getInv()[2] != null && this.getInv()[1] != null && canCombine())
		{
			if(combineTime == 1*20)
			{
				this.combineItem();
				combineTime = 0;
			}
			combineTime++;
		}
	}
	
	public boolean canCombine()
	{
		if (this.getInv()[2] == null || this.getInv()[1] == null)
        {
            return false;
        }
        else if(getInv()[2].itemID == MineFluence.MinefluenceBacteria.itemID)
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
		if (this.getInv()[2] != null && this.getInv()[1] != null)
		{
			if (this.canCombine())
	        {
				if (this.getInv()[3] == null)
				{
					this.getInv()[3] = BiosphereRecipes.smelting().getCombineResult(getInv()[1]).copy();
					if(getInv()[1].itemID != MineFluence.duplicateCard.itemID)
					{
						getInv()[2].stackSize--;
					}
		        }
		        else if (this.getInv()[3].isItemEqual(BiosphereRecipes.smelting().getCombineResult(getInv()[1]).copy()) && getInv()[3].stackSize < 64)
		        {
		        	getInv()[3].stackSize++;
		        	if(getInv()[1].itemID != MineFluence.duplicateCard.itemID)
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
}