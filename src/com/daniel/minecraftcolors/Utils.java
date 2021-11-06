package com.daniel.minecraftcolors;

import java.awt.Color;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.md_5.bungee.api.ChatColor;

public class Utils {
	/*
	 * hexcodeRegex: hexcodes are numbers and A to F (uppercase or lower case) after
	 * 1 hashtag, there are 6 figures in hexcode. hexcodeRegex has to be public so
	 * can be accessed in Main.java
	 */
	public static Pattern hexcodeRegex = Pattern.compile("#[a-fA-F0-9]{6}");

	public static HashMap<String, ChatColor> getAllColors() {
		HashMap<String, ChatColor> colorMap = new HashMap<>();

		colorMap.put("purple", ChatColor.of("#800080")); // hexcode
		colorMap.put("red", ChatColor.of("#FF0000"));
		colorMap.put("blue", ChatColor.of("#0000FF"));
		colorMap.put("yellow", ChatColor.of(new Color(255, 255, 0))); // rgb

		return colorMap;
	}

	public static ChatColor getOneColor(String colorKey) {
		HashMap<String, ChatColor> colorMap = getAllColors();

		ChatColor colorValue = colorMap.get(colorKey);
		return colorValue;
	}

	/*
	 * @method matchHexcodeWithChatMessage
	 * 
	 * @desc // add hexcode color to string input. for example: #FF0000 Hello will
	 * be sent as: red color "Hello"
	 */
	public static String matchHexcodeWithChatMessage(String message) {
		Matcher matcher = hexcodeRegex.matcher(message);

		while (matcher.find()) {
			String color = message.substring(matcher.start(), matcher.end());
			message = message.replace(color, ChatColor.of(color) + ""); // convert it to string with + ""
			message = replaceAndSymbolIfExists(message);
			matcher = hexcodeRegex.matcher(message);
		}

		return message;
	}

	/*
	 * @method replaceAndSymbolIfExists /* @desc replace & symbol from gradient
	 * hexcodes from https://rgb.birdflop.com/ (type /* default)
	 */
	public static String replaceAndSymbolIfExists(String string) {
		if (string.contains("&")) {
			string = string.replaceAll("&", "");
		}

		return string;
	}
}
