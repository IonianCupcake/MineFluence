package ioniancupcake.common.gui.recipes;

import ioniancupcake.common.lib.Reference;

import java.util.HashMap;

public class ModifyToolRecipes 
{
	private HashMap<Integer, Integer> recipes = new HashMap<Integer, Integer>();
	private HashMap<Integer, int[]> advancedRecipes = new HashMap<Integer, int[]>();

	private static final ModifyToolRecipes smeltingBase = new ModifyToolRecipes();
	
	public static final ModifyToolRecipes recipes()
    {
        return smeltingBase;
    }
	
	
	public void addRecipe(int metadata, int[] ids)
    {
		if(ids.length == 2)
		{
			int[] ints = new int[2];
			ints[0] = ids[1];
			ints[1] = metadata;
			this.advancedRecipes.put(ids[0], ints);
		}
		else
		{
			System.out.println("WARNING!!!! int[](" + ids + ").lenght != 2!!");
		}
    }
	
	public void addRecipe(int metadata, int id)
    {
			this.recipes.put(id, metadata);
    }
	
	public int getResult(int var1, int var2)
    {
		int[] ints = this.advancedRecipes.get(var1);
		if(ints != null)
		{
			if(var2 == ints[0])
			{
				return ints[1];
			}
		}
			return -1;
    }
	
	public int getResult(int var1)
    {
		if(this.recipes.get(var1-Reference.SHIFTED_ID_RANGE_CORRECTION) != null)
		{
			int metadata = (int) this.recipes.get(var1-Reference.SHIFTED_ID_RANGE_CORRECTION);
			return metadata;
		}
        return -1;
    }
}
