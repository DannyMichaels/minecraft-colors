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

public class Main extends JavaPlugin implements Listener {

	private static Utils utils = new Utils(); // my separate utilities file (Utils.java)

	@Override
	public void onEnable() {
		System.out.println("COLORS PLUGIN ENABLED!");
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public static void onChat(AsyncPlayerChatEvent event) {
		// this is static so I can change message through this utils function https://stackoverflow.com/questions/16503939/java-changing-value-of-a-variable-through-a-method
		Player player = event.getPlayer();
		String message = event.getMessage();
		// also works with gradients https://rgb.birdflop.com/
		message = Utils.matchHexcodeWithChatMessage(message);

		player.sendMessage(message);
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
		ChatColor purple = utils.getOneColor("purple");

		player.sendMessage(purple + "Hello " + player.getName() + "!");
	}
}
