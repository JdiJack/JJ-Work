package it.jdijack.jjwork.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketExeAlClient implements IMessage{
	
	NBTTagCompound nbt_message;

	public PacketExeAlClient(){}
	
	public PacketExeAlClient(NBTTagCompound nbt_message){
		this.nbt_message = nbt_message;		
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.nbt_message = ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, nbt_message);
	}
	
	public static class Handler implements IMessageHandler<PacketExeAlClient, IMessage> {

	  @Override 
	  public IMessage onMessage(PacketExeAlClient message_inviato, MessageContext ctx) {
		if(message_inviato.nbt_message!=null){	
		}
	    return null;
	  }
	}	
	
}
