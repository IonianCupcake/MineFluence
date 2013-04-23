package ioniancupcake.common.helper;

import ioniancupcake.common.lib.ItemIds;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GeneralHelper 
{
	public static boolean isBacteria(ItemStack stack)
	{
		if(stack.itemID == ItemIds.RED_BACTERIA || stack.itemID == ItemIds.GREEN_BACTERIA || stack.itemID == ItemIds.YELLOW_BACTERIA || stack.itemID == ItemIds.MINEFLUENCE_BACTERIA)
		{
			return true;
		}
		return false;
	}
	
	public static boolean isEnvironmentCard(ItemStack stack)
	{
		if(stack.itemID == ItemIds.BLANK_ENVIRONMENTCARD || stack.itemID == ItemIds.NETHER_ENVIRONMENTCARD || stack.itemID == ItemIds.FOREST_ENVIRONMENTCARD || stack.itemID == ItemIds.DUPLICATIONCARD || stack.itemID == ItemIds.DESERT_ENVIRONMENTCARD)
		{
			return true;
		}
		return false;
			 
	}
	
	public static String getName(int id)
	{
		return new ItemStack(id, 1, 0).getDisplayName();
	}
	
	public static String getName(int id, int metadata)
	{
		return new ItemStack(id, 1, metadata).getDisplayName();
	}
	
	public String getName(Object object)
	{
		if(object instanceof Block)
		{
			return new ItemStack((Block) object, 1, 0).getDisplayName();
		}
		
		if(object instanceof Item)
		{
			return new ItemStack((Item) object, 1, 0).getDisplayName();
		}
		return null;
	}
}
