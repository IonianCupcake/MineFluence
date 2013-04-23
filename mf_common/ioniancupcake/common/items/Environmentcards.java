package ioniancupcake.common.items;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class Environmentcards extends MineFluenceItems {

	public Environmentcards(int id, String st) {
		super(id, 1);
		setUnlocalizedName(st);
		LanguageRegistry.addName(this, st);
	}

}
