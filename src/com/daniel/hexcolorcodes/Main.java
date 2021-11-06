package com.daniel.hexcolorcodes;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

import org.bukkit.Bukkit;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {
	private Utils utils = new Utils(); // my separate utils file (Utils.java)


	@Override
	public void onEnable() {
		System.out.println("HEX CODE PLUGIN ENABLED!");
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		ChatColor purple = utils.getOneColor("purple");
		ChatColor yellow = utils.getOneColor("purple");

		player.sendMessage(purple + "Hello " + yellow + player.getName() + "!");
	}
}
