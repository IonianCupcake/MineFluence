package ioniancupcake.common.blocks;

import ioniancupcake.common.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ioniancupcake.common.main.MineFluence;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;


public class MineFluenceBlocks extends Block{
	
	
	public MineFluenceBlocks(int par1, Material material)
    {
        super(par1, material);
        this.setCreativeTab(MineFluence.tab);
    }
	
	 public MineFluenceBlocks(int par1, int par2, Material material, CreativeTabs tab)
	 {
	    super(par1, material);
	    this.setCreativeTab(tab);
	 }
	 
	 @Override
	    @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister iconRegister) {

	        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	    }
}
