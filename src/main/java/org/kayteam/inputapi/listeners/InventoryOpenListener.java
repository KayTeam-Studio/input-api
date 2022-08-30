package org.kayteam.inputapi.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryView;
import org.kayteam.inputapi.InputManager;
import org.kayteam.inputapi.inputs.InventoryInput;

import java.util.UUID;

public class InventoryOpenListener implements Listener {

    private final InputManager inputManager;

    public InventoryOpenListener(InputManager inputManager) {

        this.inputManager = inputManager;

    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {

        Player player = (Player) event.getPlayer();

        UUID uuid = player.getUniqueId();

        if ( ! inputManager.getInventories().containsKey(uuid))   return;

        InventoryInput inventoryInput = inputManager.getInventories().get(uuid);

        InventoryView inventoryView = event.getView();

        String title = inventoryView.getTitle();

        if ( ! title.equals(inventoryInput.getTitle()))   return;

        inventoryInput.onOpenInventory(inventoryInput);

    }

}