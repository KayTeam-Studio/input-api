package org.kayteam.inputapi.inputs;

import org.bukkit.entity.Player;

public interface ChatInput {

    boolean onChatInput(Player player, String input);

    void onPlayerSneak(Player player);

}
