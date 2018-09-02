package it.jdijack.jjwork.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class CommandExe extends CommandBase {

	@Override
	public String getName() {
		return "exe";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return new TextComponentTranslation("command.exe_desc").getFormattedText();
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {	
		// /exe
		if(args.length == 0) {
			try{
			}catch (Exception e) {
			}
		}else
			sender.sendMessage(new TextComponentString(new TextComponentTranslation("command.exe_error").getFormattedText()));
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}	

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return true;		
	}

}
