package ioniancupcake.common.items;

import ioniancupcake.common.entity.throwable.BacteriaBlasterMissile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BacteriaBlaster extends MineFluenceItems
{

    public BacteriaBlaster(int i, int s)
    {
        super(i, s);
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer) {
      if(par3EntityPlayer.capabilities.isCreativeMode||par3EntityPlayer.inventory.consumeInventoryItem(Item.redstone.itemID))
      {
        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if (!par2World.isRemote)
        {
          par2World.spawnEntityInWorld(new BacteriaBlasterMissile(par2World, par3EntityPlayer));
        }
      }
      return par1ItemStack;
      }
}
