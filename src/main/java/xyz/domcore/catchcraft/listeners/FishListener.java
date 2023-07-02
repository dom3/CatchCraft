package xyz.domcore.catchcraft.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import xyz.domcore.catchcraft.CatchCraft;
import xyz.domcore.catchcraft.ItemBuilder;
import xyz.domcore.catchcraft.fish.Fish;
import xyz.domcore.catchcraft.fish.FishManager;
import xyz.domcore.catchcraft.fish.FishState;
import xyz.domcore.catchcraft.rarity.Rarity;
import xyz.domcore.catchcraft.rods.CustomRod;
import xyz.domcore.catchcraft.rods.RodManager;

import java.util.logging.Level;

public class FishListener implements Listener {
    JavaPlugin plugin = CatchCraft.getPlugin(CatchCraft.class);
    @EventHandler
    public void onFish(PlayerFishEvent event) {
        float luck = 0;

        ItemStack rodItem = event.getPlayer().getInventory().getItemInMainHand();
        String loreID = rodItem.getItemMeta().getLore().get(rodItem.getItemMeta().getLore().size() - 1);
        CustomRod rod = RodManager.getInstance().getRodById(loreID);
        luck += rod.luck();

        double distance = event.getPlayer().getLocation().distance(FishManager.getInstance().location);
        float fixed = (float)distance/100;
        luck += fixed;

        if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            Fish fish = FishManager.getInstance().getRandomFish(luck);
            Rarity rarity = FishManager.getInstance().getRandomRarity(fish,luck);
            if (!(event.getPlayer().getInventory().getItemInMainHand().getType() == Material.FISHING_ROD)) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(CatchCraft.error("Please keep the fishing rod in your hand."));
            }
            event.getCaught().remove();
            FishManager.getInstance().states.put(event.getPlayer(),new FishState(fish,rarity));

            FishState state = FishManager.getInstance().states.get(event.getPlayer());
            state.task = plugin.getServer().getScheduler().runTaskTimer(plugin, () -> {
                if (FishManager.getInstance().states.containsKey(event.getPlayer())) {
                    state.pos++;
                    if (state.pos > 10) {
                        state.pos = 0;
                    }
                    event.getPlayer().playSound(event.getPlayer(), Sound.BLOCK_NOTE_BLOCK_PLING,1,1);
                    event.getPlayer().sendTitle(FishManager.getInstance().generateCatchString(state.rarity.color(),state.pos), "Press CROUCH when the indicator is in the middle!");
                    FishManager.getInstance().states.put(event.getPlayer(),state);
                } else {
                    state.task.cancel();
                }
            },0,rarity.speed());
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (FishManager.getInstance().states.containsKey(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onShift(PlayerToggleSneakEvent event) {
        if (FishManager.getInstance().states.containsKey(event.getPlayer())) {
            event.setCancelled(true);
            FishState state = FishManager.getInstance().states.get(event.getPlayer());
            if (state.pos == 5) {
                ItemBuilder fish = new ItemBuilder(state.reward.type(),state.rarity.id() + ":" + state.reward.id(),state.rarity.color() + state.rarity.name() + " " + state.reward.name(),state.reward.lore());
                event.getPlayer().getInventory().addItem(fish.getStack());
                event.getPlayer().sendTitle(ChatColor.GREEN + "That's a catch!",state.rarity.color() + state.rarity.name() + " " + state.reward.name());
                event.getPlayer().playSound(event.getPlayer(),Sound.ENTITY_PLAYER_LEVELUP,1,1);
            } else {
                event.getPlayer().sendTitle(ChatColor.RED + "The fish escaped!", "");
                event.getPlayer().playSound(event.getPlayer(),Sound.BLOCK_NOTE_BLOCK_BIT,1,0.5f);
            }
            FishManager.getInstance().states.remove(event.getPlayer());
        }
    }
}
