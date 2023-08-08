package de.rpserver.main;

import de.rpserver.commands.Job;
import de.rpserver.commands.XPCommand;
import de.rpserver.listener.OnBlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static String PREFIX = "§8[§9Server§8] §7";

    @Override
    public void onEnable() {
        getCommand("xp").setExecutor(new XPCommand());
        getCommand("job").setExecutor(new Job());

        getServer().getPluginManager().registerEvents(new OnBlockBreakEvent(), this);

        System.out.println("[RPPlugin] Plugin wurde erfolgreich geladen.");
    }

    @Override
    public void onDisable() {
        System.out.println("[RPPlugin] Plugin wurde erfolgreich deaktiviert.");
    }
}
