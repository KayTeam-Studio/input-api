package org.kayteam.inputapi;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.kayteam.inputapi.inputs.*;
import org.kayteam.inputapi.listeners.*;

import java.util.HashMap;
import java.util.UUID;

public class InputManager implements Listener {

    private final JavaPlugin javaPlugin;
    private final HashMap<UUID, BlockBreakInput> blocks = new HashMap<>();
    private final HashMap<UUID, ChatInput> chats = new HashMap<>();
    private final HashMap<UUID, DropInput> drops = new HashMap<>();
    private final HashMap<UUID, ShiftInput> shifts = new HashMap<>();
    private final HashMap<UUID, InventoryInput> inventories = new HashMap<>();

    public InputManager(JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
    }

    public void registerManager() {
        Server server = javaPlugin.getServer();
        PluginManager pluginManager = server.getPluginManager();

        pluginManager.registerEvents(new BlockBreakListener(this), javaPlugin);
        pluginManager.registerEvents(new AsyncPlayerChatListener(this), javaPlugin);
        pluginManager.registerEvents(new PlayerDropItemListener(this), javaPlugin);
        pluginManager.registerEvents(new PlayerToggleSneakListener(this), javaPlugin);
        pluginManager.registerEvents(new PlayerQuitListener(this), javaPlugin);
        pluginManager.registerEvents(new InventoryOpenListener(this), javaPlugin);
        pluginManager.registerEvents(new InventoryClickListener(this), javaPlugin);
        pluginManager.registerEvents(new InventoryCloseListener(this), javaPlugin);
    }

    public JavaPlugin getJavaPlugin() {
        return javaPlugin;
    }

    public HashMap<UUID, BlockBreakInput> getBlocks() {
        return blocks;
    }

    public HashMap<UUID, ChatInput> getChats() {
        return chats;
    }

    public HashMap<UUID, DropInput> getDrops() {
        return drops;
    }

    public HashMap<UUID, ShiftInput> getShifts() {
        return shifts;
    }

    public HashMap<UUID, InventoryInput> getInventories() {
        return inventories;
    }

    public void addInput(Player player, BlockBreakInput input) {
        blocks.put(player.getUniqueId(), input);
    }

    public void addInput(Player player, ChatInput input) {
        chats.put(player.getUniqueId(), input);
    }

    public void addInput(Player player, DropInput input) {
        drops.put(player.getUniqueId(), input);
    }

    public void addInput(Player player, ShiftInput input) {
        shifts.put(player.getUniqueId(), input);
    }

    public void addInput(Player player, InventoryInput input) {
        inventories.put(player.getUniqueId(), input);
    }

    public boolean hasBlockInput(Player player) {
        return blocks.containsKey(player.getUniqueId());
    }

    public boolean hasChatInput(Player player) {
        return chats.containsKey(player.getUniqueId());
    }

    public boolean hasDropInput(Player player) {
        return drops.containsKey(player.getUniqueId());
    }

    public boolean hasShiftInput(Player player) {
        return shifts.containsKey(player.getUniqueId());
    }

    public boolean hasInventoryInput(Player player) {
        return inventories.containsKey(player.getUniqueId());
    }

    public void removeBlockInput(Player player) {
        blocks.remove(player.getUniqueId());
    }

    public void removeChatInput(Player player) {
        chats.remove(player.getUniqueId());
    }

    public void removeDropInput(Player player) {
        drops.remove(player.getUniqueId());
    }

    public void removeShiftInput(Player player) {
        shifts.remove(player.getUniqueId());
    }

    public void removeInventoryInput(Player player) {
        inventories.remove(player.getUniqueId());
    }
}