package xyz.domcore.catchcraft.rods;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.domcore.catchcraft.CatchCraft;
import xyz.domcore.catchcraft.ItemBuilder;

import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;

public final class RodManager {

    public static RodManager instance;

    public RodManager() {

    }

    public static RodManager getInstance() {
        if (instance == null) {
            instance = new RodManager();
        }
        return instance;
    }

    JavaPlugin plugin = CatchCraft.getPlugin(CatchCraft.class);
    public ArrayList<CustomRod> rods = new ArrayList<>();
    public void init() {
        plugin.getLogger().log(Level.INFO,"Loading rods...");
        rods.add(new Beginner());
    }

    public CustomRod getRodById(String id) {
        CustomRod r = null;
        for (CustomRod rod : rods) {
            plugin.getLogger().log(Level.INFO,"Matching " + rod.id());
            if (Objects.equals(rod.id(), id)) {
                plugin.getLogger().log(Level.INFO,"Found rod! " + rod.id());
                r=rod;
            }
        }
        return r;
    }

    public void giveRod(String id, Player player) {
        CustomRod rod = getRodById(id);
        if (rod != null) {
            plugin.getLogger().log(Level.INFO,"Giving " + rod.name() + " rod to " + player.getName());
            ItemBuilder rodItem = new ItemBuilder(Material.FISHING_ROD, rod.color() + rod.name() + " Rod",rod.bio());
            player.getInventory().addItem(rodItem.getStack());
        } else {
            player.sendMessage(CatchCraft.error("Rod does not exist!"));
        }
    }
}
