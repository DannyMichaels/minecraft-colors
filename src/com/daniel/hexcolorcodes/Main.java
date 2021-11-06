package com.daniel.hexcolorcodes;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import java.awt.Color;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		System.out.println("HEX CODE PLUGIN ENABLED!");
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		ChatColor purple = getOneColor("purple");
		ChatColor yellow = getOneColor("purple");

		player.sendMessage(purple + "Hello! " + yellow + player.getName());
	}

	public HashMap<String, ChatColor> getAllColors() {
		HashMap<String, ChatColor> colorMap = new HashMap<>();

		colorMap.put("purple", ChatColor.of("#800080"));
		colorMap.put("red", ChatColor.of("#FF0000"));
		colorMap.put("blue", ChatColor.of("#0000FF"));
		colorMap.put("yellow", ChatColor.of(new Color(255, 255, 0))); // new java util rgb

		return colorMap;
	}

	public ChatColor getOneColor(String colorKey) {
		HashMap<String, ChatColor> colorMap = getAllColors();

		ChatColor colorValue = colorMap.get(colorKey);
		return colorValue;
	}
}
