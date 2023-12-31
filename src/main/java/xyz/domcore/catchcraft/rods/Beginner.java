package xyz.domcore.catchcraft.rods;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public class Beginner extends CustomRod{

    @Override
    public String id() {
        return "beginner";
    }

    @Override
    public String name() {
        return "Beginner";
    }

    @Override
    public ArrayList<String> bio() {
        ArrayList<String> bio = new ArrayList<>();
        bio.add("The beginning of your adventure");
        bio.add("...the very beginning.");
        return bio;
    }

    @Override
    public float luck() {
        return 0.1f;
    }

    @Override
    public ChatColor color() {
        return ChatColor.GREEN;
    }
}
