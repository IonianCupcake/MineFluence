package ioniancupcake.common.Proxys;


import ioniancupcake.common.entity.throwable.BacteriaBlasterMissile;
import ioniancupcake.common.lib.Sprites;
import ioniancupcake.common.render.render.BacteriaBlasterMissileRender;
import net.minecraft.src.ModLoader;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class ClientProxyMF extends CommonProxyMF
{
	@Override
	public void RegisterRenderThings() 
	{
		MinecraftForgeClient.preloadTexture(Sprites.GUI_BIOSPHERE);
		MinecraftForgeClient.preloadTexture(Sprites.GUI_MODIFYING_TOOL);
		EntityRegistry.registerGlobalEntityID(BacteriaBlasterMissile.class, "BacteriaBlasterMissile", ModLoader.getUniqueEntityId());
		RenderingRegistry.registerEntityRenderingHandler(BacteriaBlasterMissile.class, new BacteriaBlasterMissileRender());
	}
	
}
