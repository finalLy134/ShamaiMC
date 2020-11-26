package com.finalLy.Shamai_MC;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.finalLy.Shamai_MC.Commands_Events.EventCommand;

public class MainClass extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		
		Bukkit.getPluginManager().registerEvents(this, this);
		getCommand("event").setExecutor(new EventCommand());
		
	}
	
	@Override
	public void onDisable() {
		
	}

}
