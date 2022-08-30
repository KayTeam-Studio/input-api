package org.kayteam.inputapi;

    import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
    import org.bukkit.plugin.java.JavaPlugin;
    import org.kayteam.inputapi.inputs.*;
    import org.kayteam.inputapi.listeners.BlockBreakListener;

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
        javaPlugin.getServer().getPluginManager().registerEvents(new BlockBreakListener(this), javaPlugin);
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



    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        if (chats.containsKey(uuid)) {
            event.setCancelled(true);
            ChatInput chatInput = chats.get(uuid);
            if (chatInput.onChatInput(player, event.getMessage())) {
                chats.remove(uuid);
            }
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        if (drops.containsKey(uuid)) {
            event.setCancelled(true);
            DropInput chatInput = drops.get(uuid);
            chatInput.onPLayerDrop(player, event.getItemDrop().getItemStack());
            drops.remove(uuid);
        }
    }

    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        if (blocks.containsKey(uuid)) {
            BlockBreakInput blockBreakInput = blocks.get(uuid);
            blockBreakInput.onPlayerSneak(player);
            blocks.remove(uuid);
        }
        if (chats.containsKey(uuid)) {
            ChatInput chatInput = chats.get(uuid);
            chatInput.onPlayerSneak(player);
            chats.remove(uuid);
        }
        if (drops.containsKey(uuid)) {
            DropInput chatInput = drops.get(uuid);
            chatInput.onPlayerSneak(player);
            drops.remove(uuid);
        }
        if (shifts.containsKey(uuid)) {
            ShiftInput shiftInput = shifts.get(uuid);
            shiftInput.onShift(player);
            shifts.remove(uuid);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        blocks.remove(event.getPlayer().getUniqueId());
        chats.remove(event.getPlayer().getUniqueId());
        drops.remove(event.getPlayer().getUniqueId());
        shifts.remove(event.getPlayer().getUniqueId());
    }
}
