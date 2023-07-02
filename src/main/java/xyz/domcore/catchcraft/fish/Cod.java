package xyz.domcore.catchcraft.fish;

import org.bukkit.Material;
import xyz.domcore.catchcraft.Vector2;
import xyz.domcore.catchcraft.rarity.*;

import java.util.ArrayList;

public class Cod extends Fish{
    @Override
    public String id() {
        return "cod";
    }

    @Override
    public String name() {
        return "Cod";
    }

    @Override
    public ArrayList<String> lore() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A pretty common fish");
        list.add("one of the most popular in the world!");
        return list;
    }

    @Override
    public Material type() {
        return Material.COD;
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
        return 8f;
    }

    @Override
    public Rarity[] rarity() {
        return new Rarity[]{new Common(),new Rare(),new Epic(),new Legendary()};
    }
}
