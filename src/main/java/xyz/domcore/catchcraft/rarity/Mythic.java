package xyz.domcore.catchcraft.rarity;

import org.bukkit.ChatColor;

public class Mythic extends Rarity{
    @Override
    public String id() {
        return "mythic";
    }

    @Override
    public String name() {
        return "Mythic";
    }

    @Override
    public ChatColor color() {
        return ChatColor.GOLD;
    }

    @Override
    public float chance() {
        return 3;
    }

    @Override
    public float mulitplier() {
        return 5f;
    }

     @Override
    public long speed() {
        return 3;
    }
}
