package xyz.domcore.catchcraft.rods;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public class Advanced extends CustomRod{
    @Override
    public String id() {
        return "advanced";
    }

    @Override
    public String name() {
        return "Advanced";
    }

    @Override
    public ArrayList<String> bio() {
        ArrayList<String> list = new ArrayList<>();
        list.add("You are definitely advanced");
        list.add("Im starting to run out of things to say.");
        return list;
    }

    @Override
    public float luck() {
        return 0.5f;
    }

    @Override
    public ChatColor color() {
        return ChatColor.GOLD;
    }
}
