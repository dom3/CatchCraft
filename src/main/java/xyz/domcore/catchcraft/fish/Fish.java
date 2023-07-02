package xyz.domcore.catchcraft.fish;

import org.bukkit.Material;
import xyz.domcore.catchcraft.Vector2;
import xyz.domcore.catchcraft.rarity.Rarity;

import java.util.ArrayList;

public abstract class Fish {
    public abstract String id();
    public abstract String name();
    public abstract ArrayList<String> lore();
    public abstract Material type();
    public abstract int value();
    public abstract Vector2 sizes();
    public abstract float chance();
    public abstract Rarity[] rarity();
}
