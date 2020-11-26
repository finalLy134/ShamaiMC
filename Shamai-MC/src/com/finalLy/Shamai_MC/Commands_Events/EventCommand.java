package com.finalLy.Shamai_MC.Commands_Events;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.finalLy.Shamai_MC.Events.WithersChest;
import com.finalLy.Shamai_MC.Utils.Utils;

public class EventCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if(player.hasPermission("shamaimc.events_witherschest")) {
		
			//Conditions
			if(args.length == 0) {}
			
			//Events
			if(args.length == 1) {
				
				if(args[0].equalsIgnoreCase("WITHERS_CHEST")) {
				
					WithersChest.StartEvent(player.getWorld(), "easy");
				
				}
			
			}
		
		}
		
		return true;
		
	}
	
}
