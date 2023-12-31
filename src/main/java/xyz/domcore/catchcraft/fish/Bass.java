package xyz.domcore.catchcraft.fish;

import org.bukkit.Material;
import xyz.domcore.catchcraft.Vector2;
import xyz.domcore.catchcraft.rarity.*;

import java.util.ArrayList;

public class Bass extends Fish{
    @Override
    public String id() {
        return "bass";
    }

    @Override
    public String name() {
        return "Bass";
    }

    @Override
    public ArrayList<String> lore() {
        ArrayList<String> array = new ArrayList<>();
        array.add("A big bass that can rule the world!");
        return array;
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
        return new Vector2(100,500);
    }

    @Override
    public float chance() {
        return 9f;
    }

    @Override
    public Rarity[] rarity() {
        return new Rarity[]{new Common(),new Rare(),new Epic(),new Legendary()};
    }
}
