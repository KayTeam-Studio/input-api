package org.kayteam.inputapi.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.kayteam.inputapi.InputManager;
import org.kayteam.inputapi.inputs.BlockBreakInput;

import java.util.UUID;

public class BlockBreakListener implements Listener {

    private final InputManager inputManager;

    public BlockBreakListener(InputManager inputManager) {

        this.inputManager = inputManager;

    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();

        UUID uuid = player.getUniqueId();

        if ( ! inputManager.getBlocks().containsKey(uuid))   return;

        BlockBreakInput blockBreakInput = inputManager.getBlocks().get(uuid);

        if ( ! blockBreakInput.onBlockBreak(player, event))   return;

        inputManager.getBlocks().remove(uuid);

    }

}