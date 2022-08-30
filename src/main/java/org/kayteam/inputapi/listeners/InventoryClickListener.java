package org.kayteam.inputapi.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.kayteam.inputapi.InputManager;

public class InventoryClickListener implements Listener {

    private final InputManager inputManager;

    public InventoryClickListener(InputManager inputManager) {

        this.inputManager = inputManager;

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

    }

}