package org.kayteam.inputapi.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.kayteam.inputapi.InputManager;
import org.kayteam.inputapi.inputs.InventoryInput;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class InventoryCloseListener implements Listener {

    private final InputManager inputManager;

    public InventoryCloseListener(InputManager inputManager) {

        this.inputManager = inputManager;

    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {

        Player player = (Player) event.getPlayer();

        UUID uuid = player.getUniqueId();

        if ( ! inputManager.getInventories().containsKey(uuid))   return;

        InventoryInput inventoryInput = inputManager.getInventories().get(uuid);

        InventoryView inventoryView = event.getView();

        String title = inventoryView.getTitle();

        if ( ! title.equals(inventoryInput.getTitle()))   return;

        Inventory inventory = event.getInventory();

        HashMap<Integer, ItemStack> items = getItems(inventoryInput);

        if ( ! inventoryInput.onCloseInventory(inventory, items)) return;

        player.openInventory(inventory);

    }

    private HashMap<Integer, ItemStack> getItems(InventoryInput inventoryInput) {

        HashMap<Integer, ItemStack> items = new HashMap<>();

        List<Integer> disabledSlots = inventoryInput.getDisabledSlots();

        Inventory inventory = inventoryInput.getInventory();

        for (int i = 0; i < (inventoryInput.getRows() * 9); i++) {

            if ( disabledSlots.contains(i) ) continue;

            ItemStack itemStack = inventory.getItem(i);

            if (itemStack == null) continue;

            if (itemStack.getType().equals(Material.AIR)) continue;

            items.put(i, itemStack);

        }

        return items;

    }

}