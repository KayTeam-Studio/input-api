package org.kayteam.inputapi.inputs;

import org.bukkit.entity.Player;

public interface ChatInput {

    /**
     * Executed when the player sends a message.
     *
     * @param player the player.
     * @param input  the message input.
     * @return when true is returned the player is removed from the InputManager.
     */
    boolean onChatInput(Player player, String input);

    /**
     * Executed when the player toggle sneak.
     * When executed, the player is removed from the InputManager.
     *
     * @param player the player.
     */
    void onPlayerSneak(Player player);

}
