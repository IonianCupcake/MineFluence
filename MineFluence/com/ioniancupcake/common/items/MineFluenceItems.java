package items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MineFluenceItems extends Item{
	
	public MineFluenceItems(int i, int s)
	    {
	        super(i);
	        maxStackSize = s;
	        this.setCreativeTab(CreativeTabs.tabMaterials);
	    }
	
	public MineFluenceItems(int i, int s, CreativeTabs cT)
    	{
			super(i);
			maxStackSize = s;
			this.setCreativeTab(cT);
    	}
	 
	 
	public String getTextureFile()
		{
	               
	         return "/MineFluence/com/ioniancupcake/src/textures/items/Items.png";
	               
	    }

}
