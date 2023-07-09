package xyz.domcore.catchcraft.rods;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public class Intermediate extends CustomRod{
    @Override
    public String id() {
        return "intermediate";
    }

    @Override
    public String name() {
        return "Intermediate";
    }

    @Override
    public ArrayList<String> bio() {
        ArrayList<String> list = new ArrayList<>();
        list.add("You are rich!");
        list.add("like really rich!");
        return list;
    }

    @Override
    public float luck() {
        return 0.4f;
    }

    @Override
    public ChatColor color() {
        return ChatColor.YELLOW;
    }
}
