package ioniancupcake.common.blocks;

import ioniancupcake.common.lib.BlockIds;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks
{
    public static net.minecraft.block.Block oreTin;
    public static net.minecraft.block.Block blockOfConcrete;
    public static net.minecraft.block.Block multiBlockStructureBlocks;

    public static void initialize()
    {
        // Ores:
        oreTin = new MineFluenceBlocks(BlockIds.ORE_TIN, Material.rock)
                .setHardness(3F).setResistance(1.0F).setUnlocalizedName("oreTin");
        GameRegistry.registerBlock(oreTin, "IonianCupcake_MineFluence_oreTin");
        OreDictionary.registerOre("oreTin", new ItemStack(oreTin));

        // Blocks:
        blockOfConcrete = new MineFluenceBlocks(
                BlockIds.BLOCK_OF_CONCRETE, Material.clay).setHardness(10F).setResistance(10F).setUnlocalizedName("blockOfConcrete");
        GameRegistry.registerBlock(blockOfConcrete,
                "IonianCupcake_MineFluence_blockOfConcrete");
        
        multiBlockStructureBlocks = new Multiblockstructureblock(
                BlockIds.MACHINEPARTS).setHardness(1F).setResistance(0F);
        GameRegistry.registerBlock(multiBlockStructureBlocks,
                "IonianCupcake_MineFluence_multiBlockStructureBlocks");

        // LanguageRegistrys:
        LanguageRegistry.addName(multiBlockStructureBlocks,
                "Multiblockstructure-Blocks");
        LanguageRegistry.addName(oreTin, "Tin Ore");
        LanguageRegistry.addName(blockOfConcrete, "Block of Concrete");
    }
}
