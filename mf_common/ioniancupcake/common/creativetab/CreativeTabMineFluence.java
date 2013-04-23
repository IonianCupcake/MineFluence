package ioniancupcake.common.creativetab;

import ioniancupcake.common.items.Items;
import ioniancupcake.common.lib.ItemIds;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabMineFluence extends CreativeTabs{

	public CreativeTabMineFluence(int par1, String par2Str) 
	{
		super(par1, par2Str);
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		System.out.println(ItemIds.GREEN_BACTERIA);
		return ItemIds.GREEN_BACTERIA;
	}
	
	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(Items.greenBacteria,1 ,0);
	}
	
	@Override
	public String getTranslatedTabLabel()
	{
		return "MineFluence Creative Tab";
	}
}
