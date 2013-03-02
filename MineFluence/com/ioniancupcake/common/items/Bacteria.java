package MineFluence.com.ioniancupcake.common.items;

import java.util.HashMap;

import MineFluence.MineFluence;
import MineFluence.com.ioniancupcake.common.guis.BiosphereRecipes;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Bacteria extends MineFluenceItems{

	MineFluenceEnvironmentcard mfe;
	private static HashMap Environmentcards = new HashMap();
	private static int[] cards = new int[100];
	static int length = 0;
	
	public Bacteria(int id1, int id2, int t, int te, String st1, String st2, String st3) 
	{	
		super(id1, 64);
		setItemName(st1);
		System.out.println("New Bacteria added! " + this.itemID);
		LanguageRegistry.addName(this, st1);
		this.setIconIndex(t);
        mfe = new MineFluenceEnvironmentcard(te, id2, st2);
        ItemStack stack = new ItemStack(itemID, 1, 0);
        BiosphereRecipes.smelting().addCombine(mfe.itemID, stack);
		BiosphereRecipes.smelting().addCard(st3, mfe);
        addEnvironmentcard(st1, mfe, id2);
	}
	
	public static MineFluenceEnvironmentcard getCard(String par1)
	{
		return (MineFluenceEnvironmentcard) Environmentcards.get(par1);
	}
	
	public void addEnvironmentcard(String par1, MineFluenceEnvironmentcard par2, int par3)
	{
		Environmentcards.put(par1, par2);
		cards[length] = par3;
		length++;
		for(int i = 0; i<length+1; i++)
		{
			System.out.println(cards[i]);
		}
	}
	
	public static boolean isEnvironmentcard(ItemStack par1)
	{
		System.out.println(par1.itemID);
		System.out.println(length);
		System.out.println(cards[0]);
		System.out.println(cards[1]);
		System.out.println(cards[2]);
		System.out.println(cards[3]);
		int id = par1.itemID;
		for(int i = 0; i<length; i++)
		{
			if(cards[i] == id)
			{
				return true;
			}
		}
		return false;
	}
	
	

}
