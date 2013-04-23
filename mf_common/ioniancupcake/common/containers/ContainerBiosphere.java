package ioniancupcake.common.containers;

import ioniancupcake.common.tileentitys.MultiBlockTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBiosphere extends Container
{

        protected MultiBlockTileEntity tileEntity;
        int ID;
        
        public ContainerBiosphere (InventoryPlayer inventoryPlayer, MultiBlockTileEntity te, int id)
        {
                tileEntity = te;
                ID = id;

                //the Slot constructor takes the IInventory and the slot number in that it binds to
                //and the x-y coordinates it resides on-screen

                addSlotToContainer(new MineFluenceSlot(tileEntity, 0, 112, 35,true, false));
                addSlotToContainer(new EnvironmentcardSlot(tileEntity, 1, 44, 17,true));
                addSlotToContainer(new BacteriaSlot(tileEntity, 2, 44, 53,true));


                //commonly used vanilla code that adds the player's inventory
                bindPlayerInventory(inventoryPlayer);
        }

        @Override
        public boolean canInteractWith(EntityPlayer player) 
        {
                return tileEntity.isUseableByPlayer(player);
        }


        protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
                for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 9; j++) {
                                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                                                8 + j * 18, 84 + i * 18));
                        }
                }

                for (int i = 0; i < 9; i++) {
                        addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
                }
        }
       
        
	  @Override
	  public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slot)
      {
              ItemStack stack = null;
              Slot slotObject = (Slot) inventorySlots.get(slot);

              if(slotObject != null && slotObject.getHasStack())
              {
                      ItemStack stackInSlot = slotObject.getStack();
                      stack = stackInSlot.copy();

                      if(slot == 0)
                      {
                              if(!mergeItemStack(stackInSlot, 1, inventorySlots.size(), true)) { return null; }
                      }
                      else if(!mergeItemStack(stackInSlot, 0, 1, false)) { return null; }

                      if(stackInSlot.stackSize == 0)
                      {
                              slotObject.putStack(null);
                      }
                      else
                      {
                              slotObject.onSlotChanged();
                      }
              }

              return stack;
      }
}

