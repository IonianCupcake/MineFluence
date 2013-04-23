package ioniancupcake.common.items;

import ioniancupcake.common.lib.ItemIds;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items 
{
	public static net.minecraft.item.Item ingotTin;
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
	public static net.minecraft.item.Item modifyTool;
	public static net.minecraft.item.Item itemDisplay;
    public static net.minecraft.item.Item cardSlot;
    public static net.minecraft.item.Item bacteriaBlaster;
	
	public static void initialize()
	{
		//Items:
					ingotTin = new MineFluenceItems(ItemIds.INGOT_TIN, 64).setUnlocalizedName("Tin Ingot");
					machineCircuit = new MineFluenceItems(ItemIds.MACHINE_CIRCUIT, 16).setUnlocalizedName("Machine Circuit");
					MinefluenceEssence = new MineFluenceItems(ItemIds.MINEFLUENCE_ESSENCE, 64).setUnlocalizedName("Minefluence Essence");
					blanckEnvironmentCard = new MineFluenceItems(ItemIds.BLANK_ENVIRONMENTCARD, 64).setUnlocalizedName("Blanck Environmentcard");
					modifyTool = new MineFluenceItems(ItemIds.MODIFYING_TOOL, 1).setUnlocalizedName("Mofifying Tool");
					itemDisplay = new MineFluenceItems(ItemIds.ITEM_DISPLAY, 64).setUnlocalizedName("Display Panel");
                    cardSlot = new MineFluenceItems(ItemIds.CARD_SLOT, 64).setUnlocalizedName("Card Slot");
                    bacteriaBlaster = new BacteriaBlaster(ItemIds.BACTERIA_BLASTER, 1).setUnlocalizedName("Bacteria Blaster");
	
						
					//Bacterias
					greenBacteria = new Bacteria(ItemIds.GREEN_BACTERIA, ItemIds.FOREST_ENVIRONMENTCARD, "Forest Bacteria", "Forest Environmentcard", "Forest");
					redBacteria = new Bacteria(ItemIds.RED_BACTERIA, ItemIds.NETHER_ENVIRONMENTCARD, "Nether Bacteria", "Nether Environmentcard", "Hell");
					yellowBacteria = new Bacteria(ItemIds.YELLOW_BACTERIA, ItemIds.DESERT_ENVIRONMENTCARD, "Desert Bacteria", "Desert Environmentcard", "Desert");
					MinefluenceBacteria = new Bacteria(ItemIds.MINEFLUENCE_BACTERIA, ItemIds.DUPLICATIONCARD, "Minefluence Bacteria", "Duplicationcard", "MushroomIslandShore");
					
					//Environmentcards
					netherEnvironmentCard = Bacteria.getCard("Nether Bacteria");
					forestEnvironmentCard = Bacteria.getCard("Forest Bacteria");
					desertEnvironmentCard = Bacteria.getCard("Desert Bacteria");
					duplicateCard = Bacteria.getCard("Minefluence Bacteria");
					
					//Language Registries;
					LanguageRegistry.addName(ingotTin, "Tin Ingot");
					LanguageRegistry.addName(machineCircuit, "Machine Circuit");
					LanguageRegistry.addName(redBacteria, "Nether Bacteria");
					LanguageRegistry.addName(yellowBacteria, "Forest Bacteria");
					LanguageRegistry.addName(greenBacteria, "Desert Bacteria");
					LanguageRegistry.addName(MinefluenceBacteria, "Minefluence Bacteria");
					LanguageRegistry.addName(MinefluenceEssence, "Minefluence Essence");
					LanguageRegistry.addName(blanckEnvironmentCard, "Blanck Environmentcard");
					LanguageRegistry.addName(itemDisplay, "Display Panel");
					LanguageRegistry.addName(modifyTool, "Modification Tool");
                    LanguageRegistry.addName(cardSlot, "Card Slot");
                    LanguageRegistry.addName(bacteriaBlaster, "Bacteria Blaster");
	}
}
