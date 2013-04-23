package ioniancupcake.common.blocks;


import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public class blockSeethrough extends MineFluenceBlocks{
	
	
	public blockSeethrough(int par1, Material material)
    {
        super(par1, material);
        this.setCreativeTab(CreativeTabs.tabBlock);
}
	
	
	public boolean renderAsNormalBlock()
		{
        	return false;
		}
	
	protected boolean canSilkHarvest()
		{
	        return true;
	    }
	 public boolean isOpaqueCube()
	    {
	        return false;
	    }
	 
	 public int getRenderBlockPass()
	    {
	        return 0;
	    }
}
