package org.kayteam.inputapi.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.kayteam.inputapi.InputManager;

public class PlayerQuitListener implements Listener {

    private final InputManager inputManager;

    public PlayerQuitListener(InputManager inputManager) {

        this.inputManager = inputManager;

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        inputManager.getBlocks().remove(event.getPlayer().getUniqueId());

        inputManager.getChats().remove(event.getPlayer().getUniqueId());

        inputManager.getDrops().remove(event.getPlayer().getUniqueId());

        inputManager.getShifts().remove(event.getPlayer().getUniqueId());

    }

}