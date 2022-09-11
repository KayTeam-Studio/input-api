package org.kayteam.inputapi.inputs;

import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

public interface BlockBreakInput {

    /**
     * Executed when the player breaks a block.
     * @param player the player.
     * @param event the event.
     * @return when true is returned the player is removed from the InputManager.
     */
    boolean onBlockBreak(Player player, BlockBreakEvent event);

    /**
     * Executed when the player toggle sneak.
     * When executed, the player is removed from the InputManager.
     * @param player the player.
     */
    void onPlayerSneak(Player player);

}