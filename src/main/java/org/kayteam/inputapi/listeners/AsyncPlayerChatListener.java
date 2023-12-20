package org.kayteam.inputapi.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.kayteam.inputapi.InputManager;
import org.kayteam.inputapi.inputs.ChatInput;

import java.util.UUID;

public class AsyncPlayerChatListener implements Listener {

    private final InputManager inputManager;

    public AsyncPlayerChatListener(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if (!inputManager.getChats().containsKey(uuid)) return;

        event.setCancelled(true);
        ChatInput chatInput = inputManager.getChats().get(uuid);

        if (!chatInput.onChatInput(player, event.getMessage())) return;

        inputManager.getChats().remove(uuid);
    }
}