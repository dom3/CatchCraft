package xyz.domcore.catchcraft.rarity;

import org.bukkit.ChatColor;

public class Rare extends Rarity{
    @Override
    public String id() {
        return "rare";
    }

    @Override
    public String name() {
        return "Rare";
    }

    @Override
    public ChatColor color() {
        return ChatColor.BLUE;
    }

    @Override
    public float chance() {
        return 8;
    }

    @Override
    public float mulitplier() {
        return 1.5f;
    }

    @Override
    public long speed() {
        return 6;
    }
}
