package org.kayteam.inputapi;

    import org.bukkit.Server;
    import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
    import org.bukkit.plugin.PluginManager;
    import org.bukkit.plugin.java.JavaPlugin;
    import org.kayteam.inputapi.inputs.*;
    import org.kayteam.inputapi.listeners.AsyncPlayerChatListener;
    import org.kayteam.inputapi.listeners.BlockBreakListener;
    import org.kayteam.inputapi.listeners.PlayerDropItemListener;
    import org.kayteam.inputapi.listeners.PlayerToggleSneakListener;

    import java.util.HashMap;
import java.util.UUID;
public class InputManager implements Listener {

    private final JavaPlugin javaPlugin;
    private final HashMap<UUID, BlockBreakInput> blocks = new HashMap<>();
    private final HashMap<UUID, ChatInput> chats = new HashMap<>();
    private final HashMap<UUID, DropInput> drops = new HashMap<>();
    private final HashMap<UUID, ShiftInput> shifts = new HashMap<>();

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

    public boolean isBlockInput(Player player) {
        return blocks.containsKey(player.getUniqueId());
    }
    public boolean isChatInput(Player player) {
        return chats.containsKey(player.getUniqueId());
    }
    public boolean isDropInput(Player player) {
        return drops.containsKey(player.getUniqueId());
    }
    public boolean isShiftInput(Player player) {
        return shifts.containsKey(player.getUniqueId());
    }

}
