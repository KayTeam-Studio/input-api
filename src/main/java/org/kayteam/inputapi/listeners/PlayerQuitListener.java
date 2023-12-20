package org.kayteam.inputapi.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.kayteam.inputapi.InputManager;

import java.util.UUID;

public class PlayerQuitListener implements Listener {

    private final InputManager inputManager;

    public PlayerQuitListener(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        inputManager.getBlocks().remove(uuid);
        inputManager.getChats().remove(uuid);
        inputManager.getDrops().remove(uuid);
        inputManager.getShifts().remove(uuid);
        inputManager.getInventories().remove(uuid);
    }
}