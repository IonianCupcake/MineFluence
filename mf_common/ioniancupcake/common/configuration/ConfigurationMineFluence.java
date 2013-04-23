package ioniancupcake.common.configuration;

import ioniancupcake.common.lib.BlockIds;
import ioniancupcake.common.lib.ItemIds;
import net.minecraftforge.common.Configuration;

public class ConfigurationMineFluence 
{
	public static void init(Configuration config)
	{
		config.load();
		
		BlockIds.MACHINEPARTS = config.get(Configuration.CATEGORY_BLOCK , "Machineparts ID: ", BlockIds.MACHINEPARTS_DEFAULT).getInt();
        BlockIds.ORE_TIN = config.get(Configuration.CATEGORY_BLOCK , "Tin Ore ID: ", BlockIds.ORE_TIN_DEFAULT).getInt();
        BlockIds.BLOCK_OF_CONCRETE = config.get(Configuration.CATEGORY_BLOCK , "Böock of Concrete ID: ", BlockIds.BLOCK_OF_CONCRETE_DEFAULT).getInt();
		
		ItemIds.INGOT_TIN = config.get(Configuration.CATEGORY_ITEM , "Tin Ingot ID: ", ItemIds.INGOT_TIN_DEFAULT).getInt();
		ItemIds.MACHINE_CIRCUIT = config.get(Configuration.CATEGORY_ITEM , "Machine Circuit ID: ", ItemIds.MACHINE_CIRCUIT_DEFAULT).getInt();
		ItemIds.MINEFLUENCE_ESSENCE = config.get(Configuration.CATEGORY_ITEM , "MineFluenceEssence ID: ", ItemIds.MINEFLUENCE_ESSENCE_DEFAULT).getInt();
		ItemIds.RED_BACTERIA = config.get(Configuration.CATEGORY_ITEM , "Red Bacteria ID: ", ItemIds.RED_BACTERIA_DEFAULT).getInt();
		ItemIds.GREEN_BACTERIA = config.get(Configuration.CATEGORY_ITEM , "Green Bacteria ID: ", ItemIds.GREEN_BACTERIA_DEFAULT).getInt();
		ItemIds.YELLOW_BACTERIA = config.get(Configuration.CATEGORY_ITEM , "Yellow Bacteria ID: ", ItemIds.YELLOW_BACTERIA_DEFAULT).getInt();
		ItemIds.MINEFLUENCE_BACTERIA = config.get(Configuration.CATEGORY_ITEM , "MineFluence Bacteria ID: ", ItemIds.MINEFLUENCE_BACTERIA_DEFAULT).getInt();
		ItemIds.NETHER_ENVIRONMENTCARD = config.get(Configuration.CATEGORY_ITEM , "Nether Environmentcard ID: ", ItemIds.NETHER_ENVIRONMENTCARD_DEFAULT).getInt();
		ItemIds.FOREST_ENVIRONMENTCARD = config.get(Configuration.CATEGORY_ITEM , "Forest Environmentcard ID: ", ItemIds.FOREST_ENVIRONMENTCARD_DEFAULT).getInt();
		ItemIds.DESERT_ENVIRONMENTCARD = config.get(Configuration.CATEGORY_ITEM , "Desert Environmentcard ID: ", ItemIds.DESERT_ENVIRONMENTCARD_DEFAULT).getInt();
		ItemIds.DUPLICATIONCARD = config.get(Configuration.CATEGORY_ITEM , "Duplication Card ID: ", ItemIds.DUPLICATIONCARD_DEFAULT).getInt();
		ItemIds.BLANK_ENVIRONMENTCARD = config.get(Configuration.CATEGORY_ITEM , "Blank Environmentcard ID: ", ItemIds.BLANK_ENVIRONMENTCARD_DEFAULT).getInt();
		ItemIds.MODIFYING_TOOL = config.get(Configuration.CATEGORY_ITEM , "Modify Tool ID: ", ItemIds.MODIFYING_TOOL_DEFAULT).getInt();
		ItemIds.ITEM_DISPLAY = config.get(Configuration.CATEGORY_ITEM , "Display Panel ID: ", ItemIds.ITEM_DISPLAY_DEFAULT).getInt();
        ItemIds.CARD_SLOT = config.get(Configuration.CATEGORY_ITEM , "Card Slot ID: ", ItemIds.CARD_SLOT_DEFAULT).getInt();
        ItemIds.BACTERIA_BLASTER = config.get(Configuration.CATEGORY_ITEM , "Bacteria Blaster ID: ", ItemIds.BACTERIA_BLASTER_DEFAULT).getInt();
		
		config.save();
	}
}
