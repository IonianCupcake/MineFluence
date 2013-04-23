package ioniancupcake.common.items;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ioniancupcake.common.lib.Reference;
import ioniancupcake.common.main.MineFluence;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MineFluenceItems extends Item{
	
	public MineFluenceItems(int i, int s)
	    {
	        super(i-Reference.SHIFTED_ID_RANGE_CORRECTION);
	        maxStackSize = s;
	        this.setCreativeTab(MineFluence.tab);
	    }
	
	public MineFluenceItems(int i, int s, CreativeTabs cT)
    	{
			super(i);
			maxStackSize = s;
			this.setCreativeTab(cT);
    	}
	 
	
	@Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister iconRegister) {

        iconIndex = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

}
