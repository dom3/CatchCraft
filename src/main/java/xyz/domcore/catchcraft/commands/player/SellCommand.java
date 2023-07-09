package xyz.domcore.catchcraft.commands.player;

import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.domcore.catchcraft.CatchCraft;
import xyz.domcore.catchcraft.fish.Fish;
import xyz.domcore.catchcraft.fish.FishManager;
import xyz.domcore.catchcraft.rarity.Rarity;

import java.util.ArrayList;

@Command("sellfish")
public class SellCommand {
    @Default
    public static void sell(Player player) {
        if (player.getInventory().getItemInMainHand() .getType() != Material.AIR) {
            if (player.getInventory().getItemInMainHand().hasItemMeta()) {
                ArrayList<String> lore = (ArrayList<String>) player.getInventory().getItemInMainHand().getItemMeta().getLore();
                if (lore.get(lore.size() - 1).contains(":")) {
                    for (int i = 0; i < 1; i++) {
                        String[] id = lore.get(lore.size() - 1).split(":");
                        Rarity rarity = FishManager.getInstance().getRarityById(id[0]);
                        Fish fish = FishManager.getInstance().getFishById(id[1]);

                        int value = (int)(fish.value()*rarity.mulitplier())*player.getInventory().getItemInMainHand().getAmount();
                        CatchCraft.getEconomy().depositPlayer(player,value);
                        player.sendMessage(ChatColor.GREEN + "Sold x" + player.getInventory().getItemInMainHand().getAmount() + " " + rarity.color() + rarity.name() + " " + fish.name() + " " + ChatColor.GREEN + " for " + value + "!");
                        ItemStack stack = player.getInventory().getItemInMainHand();
                        stack.setAmount(1);
                        player.getInventory().remove(stack);
                    }
                }
            }
        }
    }
}
