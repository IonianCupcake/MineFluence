package MineFluence.com.ioniancupcake.src;

import MineFluence.com.ioniancupcake.common.CommonProxyMF;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxyMF extends CommonProxyMF{
	
	@Override
	public void RegisterRenderThings() {
		
		MinecraftForgeClient.preloadTexture("/MineFluence/com/ioniancupcake/src/textures/blocks/Blocks.png");
		MinecraftForgeClient.preloadTexture("/MineFluence/com/ioniancupcake/src/textures/items/Items.png");
		MinecraftForgeClient.preloadTexture("/MineFluence/com/ioniancupcake/src/textures/guis/Biosphere.png");
		
	}
	
}
