package ioniancupcake.common.items;


import ioniancupcake.common.gui.recipes.BiosphereRecipes;

import java.util.HashMap;


import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Bacteria extends MineFluenceItems{

	Environmentcards mfe;
	private static HashMap<String, Environmentcards> Environmentcards = new HashMap<String, Environmentcards>();
	private static int[] cards = new int[100];
	static int length = 0;
	
	public Bacteria(int id1, int id2, String st1, String st2, String st3) 
	{	
		super(id1, 64);
		setUnlocalizedName(st1);
		LanguageRegistry.addName(this, st1);
        mfe = new Environmentcards(id2, st2);
        ItemStack stack = new ItemStack(itemID, 1, 0);
        BiosphereRecipes.smelting().addCombine(mfe.itemID, stack);
		BiosphereRecipes.smelting().addCard(st3, mfe);
        addEnvironmentcard(st1, mfe, id2);
	}
	
	public static Environmentcards getCard(String par1)
	{
		return Environmentcards.get(par1);
	}
	
	public void addEnvironmentcard(String par1, Environmentcards par2, int par3)
	{
		Environmentcards.put(par1, par2);
		cards[length] = par3;
		length++;
	}
	
	public static boolean isEnvironmentcard(ItemStack par1)
	{
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
