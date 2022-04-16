package dev.akex.neocore.utils;

import org.bukkit.ChatColor;

public class Data {

    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String console() {
        return Data.color("&cLa consola no puede ejecutar este comando");
    }

}