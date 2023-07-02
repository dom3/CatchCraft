package xyz.domcore.catchcraft.rarity;

import org.bukkit.ChatColor;

public class Legendary extends Rarity{
    @Override
    public String id() {
        return "legendary";
    }

    @Override
    public String name() {
        return "Legendary";
    }

    @Override
    public ChatColor color() {
        return ChatColor.YELLOW;
    }

    @Override
    public float chance() {
        return 5;
    }

    @Override
    public float mulitplier() {
        return 2.5f;
    }

    @Override
    public long speed() {
        return 4;
    }
}
