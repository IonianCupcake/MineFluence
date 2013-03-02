package Proxys;


import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxyMF extends CommonProxyMF
{
	@Override
	public void RegisterRenderThings() 
	{
		MinecraftForgeClient.preloadTexture("/ioniancupcake/src/textures/blocks/Blocks.png");
		MinecraftForgeClient.preloadTexture("/ioniancupcake/src/textures/items/Items.png");
		MinecraftForgeClient.preloadTexture("/ioniancupcake/src/textures/guis/Biosphere.png");
		
	}
	
}
