package xyz.domcore.catchcraft;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemBuilder {

    ItemStack stack;

    public ItemBuilder(Material material,String name, ArrayList<String> lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GRAY + name);
        ArrayList<String> l = new ArrayList<>();
        l.add(ChatColor.GRAY + "+---------+");
        l.add("");
        for (String line : lore) {
            l.add(ChatColor.GRAY + line);
        }
        l.add("");
        l.add(ChatColor.GRAY + "+---------+");
        meta.setLore(l);
        item.setItemMeta(meta);
        stack = item;
    }

    public ItemStack getStack() {
        return stack;
    }
}
