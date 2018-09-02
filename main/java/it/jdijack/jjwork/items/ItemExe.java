package it.jdijack.jjwork.items;

import it.jdijack.jjwork.JJFixAWMod;
import net.minecraft.item.Item;

public class ItemExe extends Item{

	public ItemExe(String unlocalizedName, String registryName){
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
		this.setCreativeTab(JJFixAWMod.tab);
	}

}
