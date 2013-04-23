package ioniancupcake.common.gui.recipes;

import ioniancupcake.common.helper.LogHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BiosphereRecipes {
	private HashMap<Integer, ItemStack> biosphereRecipeList = new HashMap<Integer, ItemStack>();
	private HashMap<Integer, ItemStack> biosphereCombiningList = new HashMap<Integer, ItemStack>();
	private HashMap<String, ItemStack> biosphereCardList = new HashMap<String, ItemStack>();
	
	private static final BiosphereRecipes smeltingBase = new BiosphereRecipes();
	
	public static final BiosphereRecipes smelting()
    {
        return smeltingBase;
    }
	
	public void addRecipe(int blockID, ItemStack par2ItemStack)
    {
	    LogHelper.log(Level.INFO, "Added Biosphere Recipe");
        this.biosphereRecipeList.put(blockID, par2ItemStack);
    }
	
	public void addCombine(int blockID, ItemStack par2ItemStack)
    {
        LogHelper.log(Level.INFO, "Added Biosphere Recipe");
        this.biosphereCombiningList.put(blockID, par2ItemStack);
    }
	
	public void addCard(String str, Item item)
    {
        this.biosphereCardList.put(str, new ItemStack(item, 1, 0));
    }
	
	public Map<Integer, ItemStack> getRecipeList()
    {
        return this.biosphereRecipeList;
    }
	
	public ItemStack getSmeltingResult(ItemStack var1)
    {
        return this.biosphereRecipeList.get(Integer.valueOf(var1.itemID));
    }
	
	public ItemStack getCombineResult(ItemStack var1)
    {
        return this.biosphereCombiningList.get(Integer.valueOf(var1.itemID));
    }
	
	public ItemStack getCardBiome(String var1)
    {
        return biosphereCardList.get(var1);
    }
}
