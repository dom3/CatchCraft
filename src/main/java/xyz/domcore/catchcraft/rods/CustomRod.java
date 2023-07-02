package xyz.domcore.catchcraft.rods;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public abstract class CustomRod {
    /**
     * The id of the fishing rod
     */
    public abstract String id();

    /**
     * The name of the fishing rod
     */
    public abstract String name();

    /**
     * The description of the fishing rod
     */
    public abstract ArrayList<String> bio();

    /**
     * The fishing rod's luck
     */
    public abstract float luck();

    public abstract ChatColor color();
}
