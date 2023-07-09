package xyz.domcore.catchcraft.items;

import org.bukkit.Material;

public class RideBow extends CustomItem{
    @Override
    public String id() {
        return "ridebow";
    }

    @Override
    public String name() {
        return "Ride Bow";
    }

    @Override
    public Material material() {
        return Material.BOW;
    }
}
