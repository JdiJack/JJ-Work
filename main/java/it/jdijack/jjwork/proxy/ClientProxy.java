package it.jdijack.jjwork.proxy;

import codechicken.lib.model.ModelRegistryHelper;
import it.jdijack.jjwork.blocks.ModBlocks;
import it.jdijack.jjwork.entity.EntityChestCart;
import it.jdijack.jjwork.items.ItemSpawnerVehicle;
import it.jdijack.jjwork.items.ModItems;
import it.jdijack.jjwork.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.shadowmage.ancientwarfare.core.util.ModelLoaderHelper;
import net.shadowmage.ancientwarfare.vehicle.render.RenderItemSpawner;
import net.shadowmage.ancientwarfare.vehicle.render.RenderVehicle;

public class ClientProxy extends CommonProxy{

	@Override
	public void preinit(FMLPreInitializationEvent event) {
		super.preinit(event);		
		//ClientRegistry.registerKeyBinding(KeyBindingHandler.EXE);
		RenderingRegistry.registerEntityRenderingHandler(EntityChestCart.class, RenderVehicle::new);
	}
	
	@Override
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		super.registerBlocks(event);
    }

	@Override
    public void registerItems(RegistryEvent.Register<Item> event) {
    	super.registerItems(event);
    }
    
	@Override
	public void registerModels(ModelRegistryEvent event){
		super.registerModels(event);
		for (Block block: ModBlocks.blocks){
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
		}
		for (Item item: ModItems.items){
			if(item instanceof ItemSpawnerVehicle) {
				ModelRegistryHelper.registerItemRenderer(item, new RenderItemSpawner());
				ModelLoaderHelper.registerItem(item, "vehicle");
			}else {
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
			}
		}
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);	
	}

	@Override
	public void postinit(FMLPostInitializationEvent event) {
		super.postinit(event);
	}
}
