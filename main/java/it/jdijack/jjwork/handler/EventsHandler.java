package it.jdijack.jjwork.handler;

import it.jdijack.jjwork.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class EventsHandler {

	//**************************************[EVENTI COMUNI]
	@SubscribeEvent
	public static void playerLoggedInEvent(PlayerLoggedInEvent event) {
		// side server
		if(!event.player.world.isRemote){
		}
		// side client
		else{
		}
	}
	//**************************************[EVENTI SERVER]
	
	//**************************************[EVENTI CLIENT]
}
