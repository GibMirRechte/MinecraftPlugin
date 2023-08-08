package de.rpserver.main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static String PREFIX = "§8[§9Server§8] §7";

    @Override
    public void onEnable() {
        System.out.println("[RPPlugin] Plugin wurde erfolgreich geladen.");
    }

    @Override
    public void onDisable() {
        System.out.println("[RPPlugin] Plugin wurde erfolgreich deaktiviert.");
    }
}
