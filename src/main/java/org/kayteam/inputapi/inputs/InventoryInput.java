package org.kayteam.inputapi.inputs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class InventoryInput {

    private final String title;
    private final int rows;
    private final Inventory inventory;
    public final List<Integer> availableSlots;

    public InventoryInput(String title, int rows) {
        this.title = ChatColor.translateAlternateColorCodes('&', title);
        this.rows = rows;
        this.inventory = Bukkit.createInventory(null, rows * 9, ChatColor.translateAlternateColorCodes('&', title));
        this.availableSlots = new ArrayList<>();
    }

    /**
     * Get inventory title
     * @return the inventory title
     */
    public String getTitle() {

        return title;

    }

    /**
     * Get inventory rows
     * @return The inventory rows
     */
    public int getRows() {

        return rows;

    }

    /**
     * Get inventory
     * @return The inventory
     */
    public Inventory getInventory() {

        return inventory;

    }

    /**
     * Get available slots
     * @return Available slots
     */
    public List<Integer> getAvailableSlots() {

        return availableSlots;
    }

    /**
     * Executed when the player opens this inventory.
     * @param inventory open inventory
     */
    public void onOpenInventory(Inventory inventory) {}

    /**
     * Executed when the player adds an item to the inventory.
     * @param inventory the inventory
     * @param slot position where the item was added
     * @param itemStack the added item
     */
    public void onAddItem(Inventory inventory, int slot, ItemStack itemStack) {}

    /**
     * Executed when the player remove an item to the inventory.
     * @param inventory the inventory
     * @param slot position where the item was removed
     * @param itemStack the removed item
     */
    public void onRemoveItem(Inventory inventory, int slot, ItemStack itemStack) {}

    /**
     * Executed when the player closes this inventory.
     * @param inventory the inventory
     */
    public void onCloseInventory(Inventory inventory) {}

}