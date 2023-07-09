package xyz.domcore.catchcraft.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import xyz.domcore.catchcraft.items.ItemManager;
import xyz.domcore.catchcraft.items.RideBow;

public class ItemListeners implements Listener {
    @EventHandler
    public void shoot(EntityShootBowEvent event) {
        if (ItemManager.getInstance().getItemByLore(event.getBow().getItemMeta().getLore()) instanceof RideBow) {
            if (event.getEntity() instanceof Player) {
                event.getProjectile().addPassenger(event.getEntity());
            }
        }
    }
}
