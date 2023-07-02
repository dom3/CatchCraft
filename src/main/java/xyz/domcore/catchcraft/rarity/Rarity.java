package xyz.domcore.catchcraft.rarity;

import org.bukkit.ChatColor;

public abstract class Rarity {
    public abstract String id();
    public abstract String name();
    public abstract ChatColor color();
    public abstract float chance();
    public abstract float mulitplier();

    public abstract long speed();
}
