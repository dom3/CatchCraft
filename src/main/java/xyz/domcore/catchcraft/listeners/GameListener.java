package xyz.domcore.catchcraft.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import xyz.domcore.catchcraft.fish.FishManager;

public class GameListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.GREEN + "[+] " + event.getPlayer().getName());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(ChatColor.RED + "[-] " + event.getPlayer().getName());
        if (FishManager.getInstance().states.containsKey(event.getPlayer())) {
            FishManager.getInstance().states.remove(event.getPlayer());
        }

    }
    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {
        event.setCancelled(true);
    }
}
