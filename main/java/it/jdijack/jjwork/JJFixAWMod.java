package it.jdijack.jjwork;

import it.jdijack.jjwork.commands.CommandExe;
import it.jdijack.jjwork.items.ModItems;
import it.jdijack.jjwork.proxy.CommonProxy;
import it.jdijack.jjwork.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions=Reference.ACCEPTED_VERSIONS)
@Mod.EventBusSubscriber(modid = Reference.MODID)
public class JJFixAWMod {
	
	public static SoundEvent bell;
	
	public static SimpleNetworkWrapper rete;
	
	@Mod.Instance(Reference.MODID)
	public static JJFixAWMod instance;
	
	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event){
		proxy.preinit(event);
	}
	
	@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	proxy.registerBlocks(event);	
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	proxy.registerItems(event);	
    }
    
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event){
		proxy.registerModels(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.init(event);	
	}

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {    	
    	proxy.postinit(e);
    }   

	@EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandExe());
    }

    public static CreativeTabs tab = new CreativeTabs("jjfixaw"){
    	@Override
    	public ItemStack getTabIconItem(){
    		return new ItemStack(ModItems.exe_item);
    	}
    };
}

