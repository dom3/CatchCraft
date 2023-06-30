package xyz.domcore.catchcraft.fish;

import org.bukkit.Material;
import xyz.domcore.catchcraft.Vector2;
import xyz.domcore.catchcraft.rarity.Common;
import xyz.domcore.catchcraft.rarity.Rarity;

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
    public Rarity[] rarity() {
        return new Rarity[]{new Common()};
    }
}
