package org.kayteam.inputapi.inputs;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface DropInput {

    void onPLayerDrop(Player player, ItemStack itemStack);

    void onPlayerSneak(Player player);

}