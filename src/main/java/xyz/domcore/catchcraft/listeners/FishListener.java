package xyz.domcore.catchcraft.listeners;

import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.domcore.catchcraft.CatchCraft;
import xyz.domcore.catchcraft.fish.Fish;
import xyz.domcore.catchcraft.fish.FishManager;
import xyz.domcore.catchcraft.rarity.Rarity;

import java.util.logging.Level;

public class FishListener implements Listener {
    JavaPlugin plugin = CatchCraft.getPlugin(CatchCraft.class);
    @EventHandler
    public void onFish(PlayerFishEvent event) {
        Fish fish = FishManager.instance.getRandomFish();
        Rarity rarity = FishManager.instance.getRandomRarityFromFish(fish);
        plugin.getLogger().log(Level.INFO,rarity.color() + rarity.name() + " " + fish.name());
        if (event.getState() == PlayerFishEvent.State.REEL_IN) {
            event.getCaught().remove();
            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP,999999,128));
            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW,999999,255));

        }
    }
}
