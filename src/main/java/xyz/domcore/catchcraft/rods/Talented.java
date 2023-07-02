package xyz.domcore.catchcraft.rods;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public class Talented extends CustomRod{
    @Override
    public String id() {
        return "talented";
    }

    @Override
    public String name() {
        return "Talented";
    }

    @Override
    public ArrayList<String> bio() {
        ArrayList<String> list = new ArrayList<>();
        list.add("I would say this is slightly better than beginner.");
        list.add("You are still a bad fisher though.");
        return list;
    }

    @Override
    public float luck() {
        return 0.2f;
    }

    @Override
    public ChatColor color() {
        return ChatColor.DARK_GREEN;
    }
}
