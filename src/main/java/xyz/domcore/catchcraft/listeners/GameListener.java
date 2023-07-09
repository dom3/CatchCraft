package xyz.domcore.catchcraft.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import xyz.domcore.catchcraft.CatchCraft;
import xyz.domcore.catchcraft.fish.FishManager;

public class GameListener implements Listener {
    JavaPlugin plugin = CatchCraft.getPlugin(CatchCraft.class);
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.GREEN + "[+] " + event.getPlayer().getName());
        for (Player p : plugin.getServer().getOnlinePlayers()) {
            p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP,1,1);
        }
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
