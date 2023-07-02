package xyz.domcore.catchcraft.fish;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.domcore.catchcraft.CatchCraft;
import xyz.domcore.catchcraft.rarity.*;
import xyz.domcore.catchcraft.rods.CustomRod;
import xyz.domcore.catchcraft.rods.RodManager;

import java.util.*;
import java.util.logging.Level;

public class FishManager {

    JavaPlugin plugin = CatchCraft.getPlugin(CatchCraft.class);
    static FishManager instance;

    public Location location;

    public FishManager() {

    }

    public static FishManager getInstance() {
        if (instance == null) {
            instance = new FishManager();
        }
        return instance;
    }

    public ArrayList<Fish> fishes = new ArrayList<>();
    public ArrayList<Rarity> rarities = new ArrayList<>();
    public HashMap<Player,FishState> states = new HashMap<>();

    public void init() {
        location = plugin.getConfig().getLocation("midpoint");
        fishes.add(new Bass());
        fishes.add(new Cod());
        fishes.add(new Salmon());

        rarities.add(new Common());
        rarities.add(new Rare());
        rarities.add(new Epic());
        rarities.add(new Legendary());
        rarities.add(new Mythic());
    }

    public Fish getFishById(String id) {
        Fish f = null;
        for (Fish fish : fishes) {
            if (Objects.equals(fish.id(), id)) {
                f=fish;
            }
        }
        return f;
    }

    public Rarity getRarityById(String id) {
        Rarity r = null;
        for (Rarity rarity : rarities) {
            if (Objects.equals(rarity.id(), id)) {
                r=rarity;
            }
        }
        return r;
    }

    // thanks gpt 4
    public Fish getRandomFish(float luck) {
        double total = fishes.stream().mapToDouble(fish -> fish.chance() * (1 + luck)).sum();
        double rand = new Random().nextDouble(total);
        int culm = 0;
        for (Fish fish : fishes) {
            culm += fish.chance() * (1 + luck);
            if (rand < culm) {
                return fish;
            }
        }
        return null;
    }

    public Rarity getRandomRarity(Fish fish, float luck) {
        double total = Arrays.stream(fish.rarity()).mapToDouble(rarity -> rarity.chance() * (1 + luck)).sum();
        double rand = new Random().nextDouble(total);
        int culm = 0;
        for (Rarity rarity : fish.rarity()) {
            culm += rarity.chance() * (1 + luck);
            if (rand < culm) {
                return rarity;
            }
        }
        return null;
    }

    public String generateCatchString(ChatColor rarity, int pos) {
        String s = "";
        for (int i = 0; i < 10; i++) {
            if (i == pos) {
                s += rarity + "[=]";
            } else if (i == 5) {
                s += rarity +""+ ChatColor.BOLD + "=";
            } else if (i == 5 && i == pos) {
                s += rarity +""+ ChatColor.BOLD + "[=]";
            } else {
                s += rarity + "=";
            }
        }
        return s;
    }
}
