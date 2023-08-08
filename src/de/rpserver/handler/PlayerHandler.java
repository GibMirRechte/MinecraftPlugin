package de.rpserver.handler;

import de.rpserver.utils.ServerPlayer;

import java.util.HashMap;
import java.util.UUID;

public class PlayerHandler {

    static HashMap<UUID, ServerPlayer> players = new HashMap<>();

    public ServerPlayer getServerPlayer(UUID uuid) {
        if (players.containsKey(uuid)) {
            return players.get(uuid);
        }

        return new ServerPlayer(uuid, 0, null, System.currentTimeMillis());
    }

    public UUID getUUID(String name) {
        return null;
        //@TODO
    }
}