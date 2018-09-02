package it.jdijack.jjwork.proxy;

import it.jdijack.jjwork.JJFixAWMod;
import it.jdijack.jjwork.blocks.ModBlocks;
import it.jdijack.jjwork.entity.EntityChestCart;
import it.jdijack.jjwork.handler.EventsHandler;
import it.jdijack.jjwork.items.ModItems;
import it.jdijack.jjwork.network.PacketExeAlClient;
import it.jdijack.jjwork.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy {

	public void preinit(FMLPreInitializationEvent e) {
		ModBlocks.init(); 
		ModItems.init();
		
		JJFixAWMod.rete = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);
		//ultimo parametro indica verso quale lato deve essere inviato il pacchetto
		JJFixAWMod.rete.registerMessage(PacketExeAlClient.Handler.class, PacketExeAlClient.class, 0, Side.CLIENT); 
		
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID), EntityChestCart.class, "ChestCart", 0, JJFixAWMod.instance, 64, 1, true);
	}

	public void registerBlocks(RegistryEvent.Register<Block> event) {
		for(Block block: ModBlocks.blocks){
			event.getRegistry().register(block);
		}
	}

	public void registerItems(RegistryEvent.Register<Item> event) {
		for (Block block : ModBlocks.blocks){
			event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		}
		for(Item item: ModItems.items){ 
			event.getRegistry().register(item);
		}	
	}

	public void registerModels(ModelRegistryEvent event){	   	
	}

	public void init(FMLInitializationEvent event) {
	}

	public void postinit(FMLPostInitializationEvent event) {
    	MinecraftForge.EVENT_BUS.register(new EventsHandler());
	}   

}
