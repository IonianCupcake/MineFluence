package ioniancupcake.common.containers;

import ioniancupcake.common.helper.GeneralHelper;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class EnvironmentcardSlot extends MineFluenceSlot
{

	public EnvironmentcardSlot(IInventory par1iInventory, int par2, int par3, int par4, boolean par5) {
		super(par1iInventory, par2, par3, par4, par5, true);
	}

	public boolean isItemValid(ItemStack par1ItemStack)
    {
        return GeneralHelper.isEnvironmentCard(par1ItemStack);
    }
}
