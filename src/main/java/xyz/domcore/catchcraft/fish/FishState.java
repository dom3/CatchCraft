package xyz.domcore.catchcraft.fish;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import xyz.domcore.catchcraft.rarity.Rarity;

public class FishState {
    public int pos = 0;
    public Fish reward;
    public Rarity rarity;
    public BukkitTask task;

    public FishState(Fish reward, Rarity rarity) {
        this.reward = reward;
        this.rarity = rarity;
    }
}
