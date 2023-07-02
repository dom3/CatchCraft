package xyz.domcore.catchcraft.rarity;

import org.bukkit.ChatColor;

public class Common extends Rarity{
    @Override
    public String id() {
        return "common";
    }

    @Override
    public String name() {
        return "Common";
    }

    @Override
    public ChatColor color() {
        return ChatColor.GREEN;
    }

    @Override
    public float chance() {
        return 9;
    }

    @Override
    public float mulitplier() {
        return 1;
    }

    @Override
    public long speed() {
        return 7;
    }
}
