package xyz.domcore.catchcraft.fish;

import org.bukkit.Material;
import xyz.domcore.catchcraft.Vector2;
import xyz.domcore.catchcraft.rarity.*;

import java.util.ArrayList;

public class Salmon extends Fish{
    @Override
    public String id() {
        return "salmon";
    }

    @Override
    public String name() {
        return "Salmon";
    }

    @Override
    public ArrayList<String> lore() {
        ArrayList<String> list = new ArrayList<>();
        list.add("One of the healthiest fishes on the market");
        list.add("I think I would recommend it...");
        return list;
    }

    @Override
    public Material type() {
        return Material.SALMON;
    }

    @Override
    public int value() {
        return 100;
    }

    @Override
    public Vector2 sizes() {
        return null;
    }

    @Override
    public float chance() {
        return 7f;
    }

    @Override
    public Rarity[] rarity() {
        return new Rarity[]{new Common(),new Rare(),new Epic(),new Legendary(),new Mythic()};
    }
}
