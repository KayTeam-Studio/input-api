package org.kayteam.inputapi.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.kayteam.inputapi.InputManager;
import org.kayteam.inputapi.inputs.InventoryInput;

import java.util.UUID;

public class InventoryClickListener implements Listener {

    private final InputManager inputManager;

    public InventoryClickListener(InputManager inputManager) {

        this.inputManager = inputManager;

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        UUID uuid = player.getUniqueId();

        if ( ! inputManager.getInventories().containsKey(uuid)) return;

        InventoryInput inventoryInput = inputManager.getInventories().get(uuid);

        int slot = event.getRawSlot();

        if (slot > 0 && slot < inventoryInput.getRows() * 9) {

            player.sendMessage("> Dentro");

        } else {

            player.sendMessage("> Fuera");

        }

        player.sendMessage(" ");
        player.sendMessage("> Slot: " + slot);
        player.sendMessage("> InventoryAction: " + event.getAction());
        player.sendMessage("> InventoryAction: " + event.getSlotType());
        player.sendMessage(" ");

    }



}