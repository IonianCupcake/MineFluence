package MineFluence.com.ioniancupcake.common.tileentitys;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class BacteriaContainerTileEntity extends TileEntity implements IInventory
{
public ItemStack[] inv;
	
	public BacteriaContainerTileEntity()
    {
		inv = new ItemStack[1];
    }
	
	@Override
    public int getSizeInventory() {
            return inv.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
            return inv[slot];
    }
    
    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
            inv[slot] = stack;
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
            inv[0] = new ItemStack(tagCompound.getInteger("BacteriaContainer"), tagCompound.getInteger("BacteriaContainerStackSize"), -1);
            
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound)
    {
            super.writeToNBT(tagCompound);
            if(inv[0] != null)
            {
            	tagCompound.setInteger("BacteriaContainer", inv[0].itemID);
            	tagCompound.setInteger("BacteriaContainerStackSize", inv[0].stackSize);
            }
    }

	@Override
	public String getInvName() {
		return "Card Slot";
	}
}