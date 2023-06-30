package xyz.domcore.catchcraft.rods;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.domcore.catchcraft.CatchCraft;

import java.util.ArrayList;
import java.util.logging.Level;

public class RodManager {

    public static RodManager instance;

    public RodManager() {
        instance = this;
    }

    JavaPlugin plugin = CatchCraft.getPlugin(CatchCraft.class);
    public ArrayList<CustomRod> rods = new ArrayList<>();
    public void init() {
        plugin.getLogger().log(Level.INFO,"Loading rods...");
        rods.add(new Beginner());
    }

    public void giveRod() {

    }
}
