package ioniancupcake.common.containers;

import ioniancupcake.common.tileentitys.MultiBlockTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerModifyTool extends Container {
	
	public ContainerModifyTool (InventoryPlayer inventoryPlayer, MultiBlockTileEntity te)
    {
            //the Slot constructor takes the IInventory and the slot number in that it binds to
            //and the x-y coordinates it resides on-screen
            addSlotToContainer(new Slot(te , 6, 26, 33));
            addSlotToContainer(new Slot(te , 7, 80, 33));
            addSlotToContainer(new Slot(te , 8, 134, 33));

            //commonly used vanilla code that adds the player's inventory
            bindPlayerInventory(inventoryPlayer);
    }

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}
	
	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) 
	{
        for (int i = 0; i < 3; i++) 
        {
                for (int j = 0; j < 9; j++) 
                {
                        addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                                        8 + j * 18, 84 + i * 18));
                }
        }

        for (int i = 0; i < 9; i++) {
                addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
    }       
}
	 @Override
	    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {

	       return null;
	 }


}
