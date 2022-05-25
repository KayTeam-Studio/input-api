package org.kayteam.inputapi.inputs;

import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

public interface BlockBreakInput {

    boolean onBlockBreak(Player player, BlockBreakEvent event);

    void onPlayerSneak(Player player);

}
