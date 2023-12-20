package org.kayteam.inputapi.inputs;

import org.bukkit.entity.Player;

public interface ShiftInput {

    /**
     * Executed when the player toggle sneak.
     *
     * @param player the player.
     */
    void onShift(Player player);
}