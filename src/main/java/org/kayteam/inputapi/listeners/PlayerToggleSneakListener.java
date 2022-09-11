package org.kayteam.inputapi.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.kayteam.inputapi.InputManager;
import org.kayteam.inputapi.inputs.BlockBreakInput;
import org.kayteam.inputapi.inputs.ChatInput;
import org.kayteam.inputapi.inputs.DropInput;
import org.kayteam.inputapi.inputs.ShiftInput;

import java.util.UUID;

public class PlayerToggleSneakListener implements Listener {

    private final InputManager inputManager;

    public PlayerToggleSneakListener(InputManager inputManager) {

        this.inputManager = inputManager;

    }

    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {

        Player player = event.getPlayer();

        UUID uuid = player.getUniqueId();

        if (inputManager.getBlocks().containsKey(uuid)) {

            BlockBreakInput blockBreakInput = inputManager.getBlocks().get(uuid);

            blockBreakInput.onPlayerSneak(player);

            inputManager.getBlocks().remove(uuid);

        }

        if (inputManager.getChats().containsKey(uuid)) {

            ChatInput chatInput = inputManager.getChats().get(uuid);

            chatInput.onPlayerSneak(player);

            inputManager.getChats().remove(uuid);

        }

        if (inputManager.getDrops().containsKey(uuid)) {

            DropInput chatInput = inputManager.getDrops().get(uuid);

            chatInput.onPlayerSneak(player);

            inputManager.getDrops().remove(uuid);

        }

        if (inputManager.getShifts().containsKey(uuid)) {

            ShiftInput shiftInput = inputManager.getShifts().get(uuid);

            shiftInput.onShift(player);

            inputManager.getShifts().remove(uuid);

        }

    }

}