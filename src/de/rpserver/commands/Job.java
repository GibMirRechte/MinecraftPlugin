package de.rpserver.commands;

import de.rpserver.handler.JobHandler;
import de.rpserver.handler.PlayerHandler;
import de.rpserver.utils.ServerPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Job implements CommandExecutor, Listener {

    PlayerHandler playerHandler = new PlayerHandler();
    JobHandler jobHandler = new JobHandler();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Dazu musst du ein Spieler sein.");
            return true;
        }

        Player player = (Player) sender;
        ServerPlayer serverPlayer = playerHandler.getServerPlayer(player.getUniqueId());

        if (serverPlayer.getJob() == null) {
            openJobListOverview(player);
        } else {

        }

        return false;
    }

    public void openJobOverview(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9 * 5, "§7Jobübersicht");


        player.openInventory(inventory);
    }

    public void openJobListOverview(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9 * 3, "§7Verfügbare Jobs");

        ItemStack glassPane = new ItemStack(Material.STAINED_GLASS_PANE);
        ItemMeta glassPaneMeta = glassPane.getItemMeta();
        glassPaneMeta.setDisplayName("");
        glassPane.setItemMeta(glassPaneMeta);

        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, glassPane);
        }

        int slot = 0;

        for (JobHandler.Jobs job : JobHandler.Jobs.values()) {
            ItemStack jobItem = new ItemStack(job.material);
            ItemMeta jobMeta = jobItem.getItemMeta();
            jobMeta.setDisplayName("§c" + job.displayName);
            jobItem.setItemMeta(jobMeta);

            inventory.setItem(slot, jobItem);
            slot++;
        }

        player.openInventory(inventory);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getInventory().getName().equalsIgnoreCase("§7Verfügbare Jobs")) {
            event.setCancelled(true);
        }
    }

}
