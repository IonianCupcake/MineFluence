package ioniancupcake.common.main;

import ioniancupcake.common.Proxys.ClientProxyMF;
import ioniancupcake.common.blocks.Blocks;
import ioniancupcake.common.configuration.ConfigurationMineFluence;
import ioniancupcake.common.crafting.MineFluenceRecipes;
import ioniancupcake.common.creativetab.CreativeTabMineFluence;
import ioniancupcake.common.handler.GuiHandlerMineFluence;
import ioniancupcake.common.helper.LogHelper;
import ioniancupcake.common.items.Items;
import ioniancupcake.common.lib.Reference;
import ioniancupcake.common.sounds.MFSounds;
import ioniancupcake.common.tileentitys.MultiBlockTileEntity;
import ioniancupcake.common.worldgen.MineFluenceWorldGenerator;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(name = Reference.MOD_NAME, modid = Reference.MOD_ID, version = "1.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)


public class MineFluence{
	
	@SidedProxy (clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static ClientProxyMF proxy;
	@Instance(Reference.MOD_ID)
	public static MineFluence instance; 
	public static CreativeTabs tab = new CreativeTabMineFluence(CreativeTabs.getNextID(), "MineFluence");
	public static boolean isDebug = true;
	
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
	    if(FMLCommonHandler.instance().getSide().isClient())
	    {
	     MinecraftForge.EVENT_BUS.register(new MFSounds());
	    }
	    LogHelper.init();
		Configuration config = new Configuration(new File(event.getModConfigurationDirectory().getAbsolutePath() + "\\MineFluence\\" + Reference.MOD_ID + ".cfg"));
		ConfigurationMineFluence.init(config);
	}


	@Init
	public void load(FMLInitializationEvent event) 
	{
		MineFluenceWorldGenerator worldGen = new MineFluenceWorldGenerator();
		GameRegistry.registerWorldGenerator(worldGen);
		proxy.RegisterRenderThings();
		GameRegistry.registerTileEntity(MultiBlockTileEntity.class, "TileEntity_IonianCupcake_MineFluence_MultiBlocks");
		NetworkRegistry.instance().registerGuiHandler(instance, new GuiHandlerMineFluence());
		Blocks.initialize();
		Items.initialize();
		MineFluenceRecipes.initRecipes();
	}
}
