package de.rpserver.handler;

import java.util.HashMap;

public class MessageHandler {

    static final HashMap<String, String> messages = new HashMap<>();

    public String getMessage(String messageKey) {
        if (messages.isEmpty()) setup();
        if (messages.containsKey(messageKey.toLowerCase()))
            return messages.get(messageKey.toLowerCase());

        return "{" + messageKey + "}";
    }

    public void setup() {
        messages.put("general.noperm", "Dazu hast du keine Berechtigung.");
    }

}
