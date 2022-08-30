package org.kayteam.inputapi.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.kayteam.inputapi.InputManager;
import org.kayteam.inputapi.inputs.InventoryInput;

import java.util.List;
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

        if ( ! inputManager.getInventories().containsKey(uuid))   return;

        InventoryInput inventoryInput = inputManager.getInventories().get(uuid);

        int slot = event.getRawSlot();

        if ( ! (slot > -1))   return;

        if ( ! (slot < inventoryInput.getRows() * 9))   return;

        List<Integer> disabledSlots = inventoryInput.getDisabledSlots();

        if ( ! disabledSlots.contains(slot)) return;

        event.setCancelled(true);

    }



}