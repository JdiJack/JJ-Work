package it.jdijack.jjwork.items;

import java.util.ArrayList;

import net.minecraft.item.Item;
public class ModItems{
	
	public static ArrayList<Item> items;
	public static ItemExe exe_item;
	public static ItemSpawnerVehicle spawner_vehicle;
	
	public static void init(){
		items = new ArrayList<>();
		exe_item = new ItemExe("exe_item", "exe_item");
		spawner_vehicle = new ItemSpawnerVehicle();
		
		items.add(exe_item);
		items.add(spawner_vehicle);
	}
}