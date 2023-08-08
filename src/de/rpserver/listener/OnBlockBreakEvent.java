package de.rpserver.listener;

import de.rpserver.handler.PlayerHandler;
import de.rpserver.utils.ServerPlayer;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.HashMap;

public class OnBlockBreakEvent implements Listener {

    PlayerHandler playerHandler = new PlayerHandler();
    static HashMap<Material, Integer> blockList = new HashMap<>();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        setup();
        if (blockList.containsKey(event.getBlock().getType())) {
            ServerPlayer serverPlayer = playerHandler.getServerPlayer(event.getPlayer().getUniqueId());
            serverPlayer.addXP(blockList.get(event.getBlock().getType()));
        }
    }

    public void setup() {
        if (!blockList.isEmpty()) return;

        blockList.put(Material.STONE, 1);
        blockList.put(Material.DIRT, 1);
        blockList.put(Material.DIAMOND_ORE, 10);
    }

}
