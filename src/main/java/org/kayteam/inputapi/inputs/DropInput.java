package org.kayteam.inputapi.inputs;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface DropInput {

    /**
     * Executed when the player drop an item.
     * @param player the player.
     * @param itemStack the ItemStack dropped.
     */
    void onPLayerDrop(Player player, ItemStack itemStack);

    /**
     * Executed when the player toggle sneak.
     * When executed, the player is removed from the InputManager.
     * @param player the player.
     */
    void onPlayerSneak(Player player);

}