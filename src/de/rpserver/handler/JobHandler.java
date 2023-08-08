package de.rpserver.handler;

import org.bukkit.Material;

public class JobHandler {

    public enum Jobs {
        LUMBERJACK(Material.IRON_AXE, "Holzfäller"),
        MINER(Material.IRON_PICKAXE, "Miner"),
        HUNTER(Material.IRON_SWORD, "Jäger"),
        FARMER(Material.IRON_HOE, "Farmer");

        public final Material material;
        public final String displayName;

        Jobs(Material material, String displayName) {
            this.material = material;
            this.displayName = displayName;
        }
    }
}
