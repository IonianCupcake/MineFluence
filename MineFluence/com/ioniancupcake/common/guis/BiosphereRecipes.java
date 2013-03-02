package MineFluence.com.ioniancupcake.common.guis;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BiosphereRecipes {
	private HashMap biosphereRecipeList = new HashMap();
	private HashMap biosphereCombiningList = new HashMap();
	private HashMap biosphereCardList = new HashMap();
	
	private static final BiosphereRecipes smeltingBase = new BiosphereRecipes();
	
	public static final BiosphereRecipes smelting()
    {
        return smeltingBase;
    }
	
	public void addRecipe(int blockID, ItemStack par2ItemStack)
    {
		System.out.println("Added Biosphere Recipe");
        this.biosphereRecipeList.put(blockID, par2ItemStack);
    }
	
	public void addCombine(int blockID, ItemStack par2ItemStack)
    {
		System.out.println("Added Biosphere Recipe!");
        this.biosphereCombiningList.put(blockID, par2ItemStack);
    }
	
	public void addCard(String str, Item item)
    {
        this.biosphereCardList.put(str, new ItemStack(item, 1, 0));
    }
	
	public Map getRecipeList()
    {
        return this.biosphereRecipeList;
    }
	
	public ItemStack getSmeltingResult(ItemStack var1)
    {
        return (ItemStack) this.biosphereRecipeList.get(Integer.valueOf(var1.itemID));
    }
	
	public ItemStack getCombineResult(ItemStack var1)
    {
        return (ItemStack) this.biosphereCombiningList.get(Integer.valueOf(var1.itemID));
    }
	
	public ItemStack getCardBiome(String var1)
    {
        return (ItemStack) biosphereCardList.get(var1);
    }
}
