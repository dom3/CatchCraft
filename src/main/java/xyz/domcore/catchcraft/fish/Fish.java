package xyz.domcore.catchcraft.fish;

import org.bukkit.Material;
import xyz.domcore.catchcraft.Vector2;
import xyz.domcore.catchcraft.rarity.Rarity;

public abstract class Fish {
    public abstract String id();
    public abstract String name();
    public abstract Material type();
    public abstract int value();
    public abstract Vector2 sizes();
    public abstract Rarity[] rarity();
}
