package de.rpserver.commands;

import de.rpserver.handler.PlayerHandler;
import de.rpserver.main.Main;
import de.rpserver.utils.ServerPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class XPCommand implements CommandExecutor {

    PlayerHandler playerHandler = new PlayerHandler();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Dazu musst du ein Spieler sein.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("rp.admin.xp")) {
            player.sendMessage(Main.PREFIX + "§cDazu hast du keine Berechtigung");
            return true;
        }

        if (args.length != 3) {
            player.sendMessage(Main.PREFIX + "§cBitte benutze /xp <add|remove|set> <Spieler> <Anzahl>");
            return true;
        }

        String operation = args[0];

        ServerPlayer serverPlayer = playerHandler.getServerPlayer(playerHandler.getUUID(args[1]));

        if (serverPlayer == null) {
            player.sendMessage(Main.PREFIX + "§cDieser Spieler war noch nie auf dem Server.");
            return true;
        }

        if (operation.equalsIgnoreCase("add")) {
            serverPlayer.addXP(Integer.parseInt(args[2]));
        } else if (operation.equalsIgnoreCase("remove")) {
            serverPlayer.removeXP(Integer.parseInt(args[2]));
        } else if (operation.equalsIgnoreCase("set")) {
            serverPlayer.setXP(Integer.parseInt(args[2]));
        }

        player.sendMessage(Main.PREFIX + "§c" + args[1] + " §7hat nun §b" + String.format("%,d", serverPlayer.getXp()) + " XP§7.");

        return false;
    }
}
