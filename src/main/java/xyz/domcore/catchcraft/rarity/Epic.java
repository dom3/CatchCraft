package xyz.domcore.catchcraft.rarity;

import org.bukkit.ChatColor;

public class Epic extends Rarity{
    @Override
    public String id() {
        return "epic";
    }

    @Override
    public String name() {
        return "Epic";
    }

    @Override
    public ChatColor color() {
        return ChatColor.LIGHT_PURPLE;
    }

    @Override
    public float chance() {
        return 7;
    }

    @Override
    public float mulitplier() {
        return 2f;
    }

    @Override
    public long speed() {
        return 5;
    }
}
