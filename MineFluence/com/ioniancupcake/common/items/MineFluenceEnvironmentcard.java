package MineFluence.com.ioniancupcake.common.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.ItemStack;

public class MineFluenceEnvironmentcard extends MineFluenceItems {

	public MineFluenceEnvironmentcard(int t, int id, String st) {
		super(id, 1);
		System.out.println("New Environmentcard added! " + id);
		setItemName(st);
		LanguageRegistry.addName(this, st);
		this.setIconIndex(t);
	}

}
