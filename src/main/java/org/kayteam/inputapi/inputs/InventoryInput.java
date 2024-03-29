package org.kayteam.inputapi.inputs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class InventoryInput {

    private final String title;
    private final int rows;
    private final Inventory inventory;
    public final List<Integer> disabledSlots;

    public InventoryInput(String title, int rows) {

        this.title = ChatColor.translateAlternateColorCodes('&', title);

        this.rows = rows;

        this.inventory = Bukkit.createInventory(null, rows * 9, ChatColor.translateAlternateColorCodes('&', title));

        this.disabledSlots = new ArrayList<>();

    }

    /**
     * Get inventory title.
     *
     * @return the inventory title.
     */
    public String getTitle() {

        return title;

    }

    /**
     * Get inventory rows.
     *
     * @return The inventory rows.
     */
    public int getRows() {

        return rows;

    }

    /**
     * Get inventory.
     *
     * @return The inventory.
     */
    public Inventory getInventory() {

        return inventory;

    }

    /**
     * Get disabled slots.
     *
     * @return Disabled slots.
     */
    public List<Integer> getDisabledSlots() {

        return disabledSlots;

    }

    /**
     * Executed when the player opens this inventory.
     *
     * @param inventoryInput the inventory input.
     */
    public void onOpenInventory(InventoryInput inventoryInput) {
    }

    /**
     * Executed when the player closes this inventory.
     *
     * @param inventoryInput the inventory input.
     */
    public void onCloseInventory(InventoryInput inventoryInput) {
    }

}