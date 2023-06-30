package xyz.domcore.catchcraft.fish;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.domcore.catchcraft.CatchCraft;
import xyz.domcore.catchcraft.rarity.Rarity;
import xyz.domcore.catchcraft.rods.CustomRod;
import xyz.domcore.catchcraft.rods.RodManager;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Level;

public class FishManager {

    JavaPlugin plugin = CatchCraft.getPlugin(CatchCraft.class);
    public static FishManager instance;

    public FishManager() {

    }

    public static FishManager getInstance() {
        if (instance == null) {
            instance = new FishManager();
        }
        return instance;
    }

    public ArrayList<Fish> fishes = new ArrayList<>();

    public void init() {
        fishes.add(new Bass());
    }

    public Fish getRodById(String id) {
        Fish f = null;
        for (Fish fish : fishes) {
            plugin.getLogger().log(Level.INFO,"Matching " + fish.id());
            if (Objects.equals(fish.id(), id)) {
                plugin.getLogger().log(Level.INFO,"Found rod! " + fish.id());
                f=fish;
            }
        }
        return f;
    }

    public Fish getRandomFish() {
        return fishes.get(new Random().nextInt(fishes.size()));
    }

    public Rarity getRandomRarityFromFish(Fish fish) {
        return fish.rarity()[new Random().nextInt(fish.rarity().length)];
    }
}
