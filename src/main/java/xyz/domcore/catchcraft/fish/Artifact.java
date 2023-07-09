package xyz.domcore.catchcraft.fish;

import org.bukkit.Material;
import xyz.domcore.catchcraft.Vector2;
import xyz.domcore.catchcraft.rarity.*;

import java.util.ArrayList;

public class Artifact extends Fish{
    @Override
    public String id() {
        return "artifact";
    }

    @Override
    public String name() {
        return "Artifact";
    }

    @Override
    public ArrayList<String> lore() {
        ArrayList<String> list = new ArrayList<>();
        list.add("An artifact found in the deepest parts of the ocean!");
        return list;
    }

    @Override
    public Material type() {
        return Material.ECHO_SHARD;
    }

    @Override
    public int value() {
        return 250;
    }

    @Override
    public Vector2 sizes() {
        return new Vector2(0,0);
    }

    @Override
    public float chance() {
        return 3f;
    }

    @Override
    public Rarity[] rarity() {
        return new Rarity[] {new Rare(),new Epic(),new Legendary()};
    }
}
