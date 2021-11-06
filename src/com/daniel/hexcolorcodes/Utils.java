package com.daniel.hexcolorcodes;

import java.awt.Color;
import java.util.HashMap;
import net.md_5.bungee.api.ChatColor;

public class Utils {

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
