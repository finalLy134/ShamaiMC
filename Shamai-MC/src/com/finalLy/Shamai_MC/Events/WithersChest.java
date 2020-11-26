package com.finalLy.Shamai_MC.Events;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;

import com.finalLy.Shamai_MC.MainClass;
import com.finalLy.Shamai_MC.Utils.Utils;

public class WithersChest implements Listener {
	
	public MainClass plugin;
	
	public WithersChest(MainClass plugin) {
		
		this.plugin = plugin;
		
	}
	
	private static void createTrackerCompass(Player player, Location location) {
		
        boolean inMainHand = false;
        if(player.getInventory().getItemInMainHand().getType().equals(Material.COMPASS)) inMainHand = true;
        org.bukkit.inventory.ItemStack compass = new org.bukkit.inventory.ItemStack(Material.COMPASS);
        CompassMeta compassMeta = (CompassMeta) compass.getItemMeta();
        compassMeta.setLodestoneTracked(false);
        compassMeta.setLodestone(location);
        compass.setItemMeta(compassMeta);
       
        if(inMainHand) player.getInventory().setItemInMainHand(compass);
        else player.getInventory().setItemInOffHand(compass);
        
   }
	
	public static void StartEvent(World world, String mode) {
		
		if(mode == "easy") {
			
			Random randomizer = new Random();
			
			int x = randomizer.nextInt(0 + 200);
			int z = randomizer.nextInt(0 + 200);
			int y = world.getHighestBlockYAt(x, z) + 1;
			
			Location availableLoc = new Location(world, x, y, z);
			
			availableLoc.getBlock().setType(Material.CHEST);
			
	        Block block = world.getBlockAt(x, y, z);
	        Chest chest = (Chest) block.getState();
	        chest.getBlockInventory().setItem(13, new ItemStack(Material.WITHER_SKELETON_SKULL));
	        
	        int availableLocY = availableLoc.getBlockY() - 1;
	        
	        Location lodestoneLoc = world.getBlockAt(availableLoc.getBlockX(), availableLocY, availableLoc.getBlockZ()).getLocation();
	        
	        world.getBlockAt(availableLoc.getBlockX(), availableLocY, availableLoc.getBlockZ()).setType(Material.LODESTONE);
	        
	        for(Player players : Bukkit.getOnlinePlayers()) {
	        	
				createTrackerCompass(players, lodestoneLoc);
	        	
	        }
	        
			world.playSound(availableLoc, Sound.ENTITY_WITHER_SPAWN, 100.0F, 1.0F);
						
			Bukkit.broadcastMessage(Utils.chat("&4☠ &6&lWither's Chest &7has spawned at the &d&lHollylands."));
			System.out.println(Utils.chat("&4☠ &6&lWither's Chest &7has spawned at the &d&lHollylands. &5(" + x + ", " + y + ", " + z + ")"));
			
		}
		
	}

}
