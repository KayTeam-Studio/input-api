package org.kayteam.inputapi.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.kayteam.inputapi.InputManager;
import org.kayteam.inputapi.inputs.DropInput;

import java.util.UUID;

public class PlayerDropItemListener implements Listener {

    private final InputManager inputManager;

    public PlayerDropItemListener(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {

        Player player = event.getPlayer();

        UUID uuid = player.getUniqueId();

        if ( ! inputManager.getDrops().containsKey(uuid))   return;

        event.setCancelled(true);

        DropInput chatInput = inputManager.getDrops().get(uuid);

        chatInput.onPLayerDrop(player, event.getItemDrop().getItemStack());

        inputManager.getDrops().remove(uuid);

    }

}