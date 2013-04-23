package ioniancupcake.common.crafting;

import ioniancupcake.common.blocks.Blocks;
import ioniancupcake.common.gui.recipes.BiosphereRecipes;
import ioniancupcake.common.gui.recipes.ModifyToolRecipes;
import ioniancupcake.common.items.Items;
import ioniancupcake.common.lib.BlockIds;
import ioniancupcake.common.lib.ItemIds;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class MineFluenceRecipes 
{
	public static void initRecipes()
	{
		initCrafting();
		initBiosphereRecipes();
		initSmeltings();
		initModifyRecipes();
	}
	
	
	private static void initCrafting()
	{
		GameRegistry.addRecipe(new ItemStack(Blocks.multiBlockStructureBlocks, 1, 0), new Object[]
			    {
			"###", "#+#", "###", '#', Block.stoneBrick, '+', Item.diamond
			    });
		
		
		GameRegistry.addRecipe(new ItemStack(Blocks.multiBlockStructureBlocks, 1, 2), new Object[]
				{
			"###", "#+#", "###", '#', new ItemStack(Blocks.multiBlockStructureBlocks, 1, 0), '+', Items.machineCircuit
				});
		
		GameRegistry.addRecipe(new ItemStack(Items.machineCircuit), new Object[]
				{
			"+#+", "#+#", "+#+", '#', Item.ingotIron, '+', Item.redstone
				});
		
		GameRegistry.addRecipe(new ItemStack(Items.blanckEnvironmentCard), new Object[]
				{
			"+++", "+#+", "+++", '#', Item.diamond, '+', Item.paper
				});
		
		 GameRegistry.addRecipe(new ItemStack(Items.duplicateCard), new Object[]
				{
			"+#+", "+#+", "+#+", '#', Item.emerald, '+', Items.blanckEnvironmentCard
				});	
		 
		 GameRegistry.addRecipe(new ItemStack(Items.itemDisplay), new Object[]
					{
				"+++", "###", "***", '*', Block.stone, '+', Block.glass, '#', Item.redstone 
					});	
	}
	
	
	private static void initBiosphereRecipes()
	{
		BiosphereRecipes.smelting().addRecipe(ItemIds.MINEFLUENCE_ESSENCE, new ItemStack(Items.MinefluenceBacteria));
	}
	
	
	private static void initSmeltings()
	{
		GameRegistry.addSmelting(BlockIds.ORE_TIN, new ItemStack(Items.ingotTin), 10F);
	}
	
	
	private static void initModifyRecipes()
	{
		ModifyToolRecipes.recipes().addRecipe(2, new int[]{ItemIds.MACHINE_CIRCUIT, Item.ingotIron.itemID});
		ModifyToolRecipes.recipes().addRecipe(4, new int[]{ItemIds.ITEM_DISPLAY, Item.diamond.itemID});
		ModifyToolRecipes.recipes().addRecipe(6, new int[]{BlockIds.BLOCK_OF_CONCRETE, Block.glass.blockID});
		ModifyToolRecipes.recipes().addRecipe(8, new int[]{ItemIds.CARD_SLOT, Item.emerald.itemID});
	}
	
}
