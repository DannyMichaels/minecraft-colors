package com.daniel.minecraftcolors;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

import org.bukkit.Bukkit;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

// when to use static? 
// https://stackoverflow.com/questions/2671496/when-to-use-static-methods

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		System.out.println("COLORS PLUGIN ENABLED!");
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		// Player player = event.getPlayer();

		String message = event.getMessage();
		message = Utils.matchHexcodeWithChatMessage(message);

		// player.sendMessage(message); // this sends the message to the player only
		event.setMessage(message); // will update the message and send to the whole server.
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String cmdName = cmd.getName();
		Player player = (Player) sender;

		switch (cmdName) {
		case "greet":
			greetPlayer(player);
			break;
		default:
			break;
		}
		return false;
	}

	public void greetPlayer(Player player) {
		ChatColor purple = Utils.getOneColor("purple"); // my separate utilities file (Utils.java)

		player.sendMessage(purple + "Hello " + player.getName() + "!");
	}
}
