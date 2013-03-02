package MineFluence.com.ioniancupcake.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class MineFluenceBlocks extends Block{
	
	
	public MineFluenceBlocks(int par1, int par2, Material material)
    {
        super(par1, par2, material);
        this.setCreativeTab(CreativeTabs.tabBlock);
}
	
	 public MineFluenceBlocks(int par1, int par2, Material material, CreativeTabs tab)
	 {
	    super(par1, par2, material);
	    this.setCreativeTab(tab);
	 }
	
	


	public String getTextureFile(){
		 return "/MineFluence/com/ioniancupcake/src/textures/blocks/Blocks.png";
	 }
}
