package ioniancupcake.common.lib;


public class Gui 
{
	public static final int BIOSPHERE_COOKING_TIME = 20*1;
	
	public static int getCookTimeRemainingScaled(int par1, int par2)
	{
	        return par2 * par1 / BIOSPHERE_COOKING_TIME;
	}
}
