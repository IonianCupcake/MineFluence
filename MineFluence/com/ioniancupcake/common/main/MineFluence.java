package main;

import guis.BiosphereRecipes;
import handler.GuiHandlerMineFluence;
import items.Bacteria;
import items.MineFluenceItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import tileentitys.BacteriaContainerTileEntity;
import tileentitys.CardSlotTileEntity;
import tileentitys.TileEntityBiosphere;
import worldgen.MineFluenceWorldGenerator;
import Proxys.CommonProxyMF;
import blocks.MineFluenceBlocks;
import blocks.Multiblockstructureblock;
import blocks.multiblockstructures.BacteriaContainer;
import blocks.multiblockstructures.CardSlot;
import blocks.multiblockstructures.Display;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;



@Mod(name = "MineFluence by Ionian Cupcake", modid = "MineFluence", version = "1.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)



public class MineFluence{
	
	@SidedProxy (clientSide = "Proxys.ClientProxyMF", serverSide = "Proxys.CommonProxyMF")
	public static CommonProxyMF proxy;
	@Instance("MineFluence")
	public static MineFluence instance; 
	
	
	public static net.minecraft.block.Block oreIod;
	public static net.minecraft.block.Block oreTin;
	public static net.minecraft.block.Block buildingBlock;
	public static net.minecraft.block.Block machineBlock;
	public static net.minecraft.block.Block cardSlot;
	public static net.minecraft.block.Block display;
	public static net.minecraft.block.Block bacteriaContainer;
	
	public static net.minecraft.item.Item Tip;
	public static net.minecraft.item.Item ingotDisinfectedIron;
	public static net.minecraft.item.Item ingotIod;
	public static net.minecraft.item.Item disinfectant;
	public static net.minecraft.item.Item ingotTin;
	public static net.minecraft.item.Item redSyringe;
	public static net.minecraft.item.Item yellowSyringe;
	public static net.minecraft.item.Item greenSyringe;
	public static net.minecraft.item.Item machineCircuit;
	public static net.minecraft.item.Item redBacteria;
	public static net.minecraft.item.Item yellowBacteria;
	public static net.minecraft.item.Item greenBacteria;
	public static net.minecraft.item.Item MinefluenceBacteria;
	public static net.minecraft.item.Item MinefluenceEssence;
	public static net.minecraft.item.Item netherEnvironmentCard;
	public static net.minecraft.item.Item forestEnvironmentCard;
	public static net.minecraft.item.Item desertEnvironmentCard;
	public static net.minecraft.item.Item duplicateCard;
	public static net.minecraft.item.Item blanckEnvironmentCard;
	static int sID = -1;
	
	
	
	public static int mineFluenceID(int sID) {
		return 2629 + sID();
	}
	

	public static int sID(){
		sID++;
		return sID;
	}


	@Init
	public void load(FMLInitializationEvent event) {
		
		MineFluenceWorldGenerator worldGen = new MineFluenceWorldGenerator();
		GameRegistry.registerWorldGenerator(worldGen);
		
		proxy.RegisterRenderThings();
		
		GameRegistry.registerTileEntity(CardSlotTileEntity.class, "TileEntity_Ionian_Cupcake_MineFluence_CardReader"); 
		GameRegistry.registerTileEntity(BacteriaContainerTileEntity.class, "TileEntity_IonianCupcake_MineFluence_BacteriaContainer");
		GameRegistry.registerTileEntity(TileEntityBiosphere.class, "TileEntity_IonianCupcake_MineFluence_Biosphere");

		NetworkRegistry.instance().registerGuiHandler(instance, new GuiHandlerMineFluence());

		
		//Ores: 
		oreIod = new MineFluenceBlocks(mineFluenceID(sID()), 1, Material.rock).setHardness(3.0F).setResistance(1.0F).setBlockName("Iod Ore");
		GameRegistry.registerBlock(oreIod, "IonianCupcake_MineFluence_oreIod");
		OreDictionary.registerOre("oreIod", new ItemStack(oreIod));
		 
		
		oreTin = new MineFluenceBlocks(mineFluenceID(sID()), 2, Material.rock).setHardness(3F).setResistance(1.0F).setBlockName("Tin Ore");
		GameRegistry.registerBlock(oreTin, "IonianCupcake_MineFluence_oreTin");
		OreDictionary.registerOre("oreTin", new ItemStack(oreTin));
		
		
		
		
		//Blocks:
		buildingBlock = new Multiblockstructureblock(mineFluenceID(sID()), 0, 0).setHardness(1F).setResistance(0F).setBlockName("Building Block");
		GameRegistry.registerBlock(buildingBlock, "IonianCupcake_MineFluence_buildingBlock");
		System.out.println(buildingBlock.blockID);
		machineBlock = new Multiblockstructureblock(mineFluenceID(sID()), 3, 0).setHardness(1F).setResistance(0F).setBlockName("Machine Block");
		GameRegistry.registerBlock(machineBlock,"IonianCupcake_MineFluence_machineBlock");
		cardSlot = new CardSlot(mineFluenceID(sID())).setHardness(1F).setResistance(0F).setBlockName("Card Slot");
		GameRegistry.registerBlock(cardSlot,"IonianCupcake_MineFluence_cardSlot");
		display = new Display(mineFluenceID(sID()), 6, 0).setHardness(1F).setResistance(0F).setBlockName("Display");
		GameRegistry.registerBlock(display,"IonianCupcake_MineFluence_display");
		bacteriaContainer = new BacteriaContainer(mineFluenceID(sID())).setHardness(1F).setResistance(0F).setBlockName("Bacteria Container");
		GameRegistry.registerBlock(bacteriaContainer,"IonianCupcake_MineFluence_bacteriaContainer");
		
		
		
		//Items:
		Tip = new MineFluenceItems(mineFluenceID(sID()), 64).setIconIndex(0).setItemName("Tip of a Syringe");
		ingotDisinfectedIron = new MineFluenceItems(mineFluenceID(sID()), 64).setIconIndex(1).setItemName("Disinfected Iron Ingot");
		ingotIod = new MineFluenceItems(mineFluenceID(sID()), 64).setIconIndex(2).setItemName("Iod Ingot");
		disinfectant = new MineFluenceItems(mineFluenceID(sID()), 4).setIconIndex(4).setItemName("Disinfectant");
		ingotTin = new MineFluenceItems(mineFluenceID(sID()), 64).setIconIndex(3).setItemName("Tin Ingot");
		greenSyringe = new MineFluenceItems(mineFluenceID(sID()), 1).setIconIndex(7).setItemName("Green Syringe");
		redSyringe = new MineFluenceItems(mineFluenceID(sID()), 1).setIconIndex(5).setItemName("Red Syringe");
		yellowSyringe = new MineFluenceItems(mineFluenceID(sID()), 1).setIconIndex(6).setItemName("Yellow Syringe");
		machineCircuit = new MineFluenceItems(mineFluenceID(sID()), 1).setIconIndex(8).setItemName("MachineCircuit");
		MinefluenceEssence = new MineFluenceItems(mineFluenceID(sID()), 64).setIconIndex(13).setItemName("Minefluence Essence");
		blanckEnvironmentCard = new MineFluenceItems(mineFluenceID(sID()), 64).setIconIndex(18).setItemName("Blanck Environmentcard");
			
		//Bacterias
		greenBacteria = new Bacteria(2621, 2622, 9, 14, "Green Bacteria", "Forest Environmentcard", "Forest");
		redBacteria = new Bacteria(2623, 2624, 10, 15, "Red Bacteria", "Nether Environmentcard", "Hell");
		yellowBacteria = new Bacteria(2625, 2626, 11, 16, "Yellow Bacteria", "Desert Environmentcard", "Desert");
		MinefluenceBacteria = new Bacteria(2627, 2628, 12, 17, "Minefluence Bacteria", "Duplicationcard", "MushroomIslandShore");
		
		//Environmentcards
		netherEnvironmentCard = Bacteria.getCard("Red Bacteria");
		System.out.println(netherEnvironmentCard.itemID);
		forestEnvironmentCard = Bacteria.getCard("Green Bacteria");
		System.out.println(forestEnvironmentCard.itemID);
		desertEnvironmentCard = Bacteria.getCard("Yellow Bacteria");
		System.out.println(desertEnvironmentCard.itemID);
		duplicateCard = Bacteria.getCard("Minefluence Bacteria");
		
		//Language Registries;
		LanguageRegistry.addName(ingotTin, "Tin Ingot");
		LanguageRegistry.addName(disinfectant, "Disinfectant");
		LanguageRegistry.addName(ingotIod, "Iod Ingot");
		LanguageRegistry.addName(ingotDisinfectedIron, "Disinfected Iron Ingot");
		LanguageRegistry.addName(Tip, "Tip of a Syringe");
		LanguageRegistry.addName(greenSyringe, "Green Syringe");
		LanguageRegistry.addName(yellowSyringe, "Yellow Syringe");
		LanguageRegistry.addName(redSyringe, "Red Syringe");
		LanguageRegistry.addName(buildingBlock, "Building Block");
		LanguageRegistry.addName(machineBlock, "Machine Block");
		LanguageRegistry.addName(cardSlot, "Card Slot");
		LanguageRegistry.addName(display, "Display");
		LanguageRegistry.addName(bacteriaContainer, "BacteriaContainer");
		LanguageRegistry.addName(oreTin, "Tin Ore");
		LanguageRegistry.addName(oreIod, "Iod Ore");
		LanguageRegistry.addName(machineCircuit, "Machine Circuit");
		LanguageRegistry.addName(redBacteria, "Red Bacteria");
		LanguageRegistry.addName(yellowBacteria, "Yellow Bacteria");
		LanguageRegistry.addName(greenBacteria, "Green Bacteria");
		LanguageRegistry.addName(MinefluenceBacteria, "Minefluence Bacteria");
		LanguageRegistry.addName(MinefluenceEssence, "Minefluence Essence");
		LanguageRegistry.addName(blanckEnvironmentCard, "Blanck Environmentcard");
		
		
		addRecipes();
		addSmeltings();
		addBiosphereRecipes();
	}


	public static void addRecipes()
	{
		
		
		
		GameRegistry.addRecipe(new ItemStack(buildingBlock), new Object[]
			    {
			"###", "#+#", "###", '#', Block.stoneBrick, '+', Item.diamond
			    });
		
		
		GameRegistry.addRecipe(new ItemStack(Tip), new Object[]
			    {
			"#  ", " + ", "  +", '#', ingotTin, '+', ingotDisinfectedIron
			    });
		
		GameRegistry.addRecipe(new ItemStack(machineBlock), new Object[]
				{
			"###", "#+#", "###", '#', buildingBlock, '+', machineCircuit
				});
		
		GameRegistry.addRecipe(new ItemStack(machineCircuit), new Object[]
				{
			"+#+", "#+#", "+#+", '#', Item.ingotIron, '+', Item.redstone
				});
		
		GameRegistry.addRecipe(new ItemStack(blanckEnvironmentCard), new Object[]
				{
			"+++", "+#+", "+++", '#', Item.diamond, '+', Item.paper
				});
		
		 GameRegistry.addRecipe(new ItemStack(duplicateCard), new Object[]
				{
			"+#+", "+#+", "+#+", '#', Item.emerald, '+', blanckEnvironmentCard
				});
		
		
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(ingotDisinfectedIron), new Object[]
			    {
			new ItemStack(Item.ingotIron), new ItemStack(disinfectant)
			    });
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(disinfectant), new Object[]
			    {
			new ItemStack(Item.potion), new ItemStack(ingotIod)
			    });
		
		
		
		
	}
	
	public static void addSmeltings()
	{
		
		GameRegistry.addSmelting(oreTin.blockID, new ItemStack(ingotTin), 10F);
		GameRegistry.addSmelting(oreIod.blockID, new ItemStack(ingotIod), 8F);
		
	}
	
	public static void addBiosphereRecipes() 
	{
		BiosphereRecipes.smelting().addRecipe(MinefluenceEssence.itemID, new ItemStack(MinefluenceBacteria));
	}
}
