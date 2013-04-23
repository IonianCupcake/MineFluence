package ioniancupcake.common.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class MineFluenceSlot extends Slot
{
	boolean canTakeStack;
	boolean canPutStack; 
	ItemStack allowed = null;
	
	public MineFluenceSlot(IInventory par1iInventory, int par2, int par3,int par4, boolean par5, boolean par6) 
	{
		super(par1iInventory, par2, par3, par4);
		canTakeStack = par5;
		canPutStack = par6;
	}
	
	@Override
	public boolean canTakeStack(EntityPlayer par1EntityPlayer)
    {
        return canTakeStack;
    }
	
	public boolean isItemValid(ItemStack par1ItemStack)
    {
        return canPutStack;
    }

}
