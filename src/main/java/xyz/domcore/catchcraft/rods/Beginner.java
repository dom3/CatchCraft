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
        bio.add("The beginning of your adventure. This rod sucks honestly.");
        return bio;
    }

    @Override
    public int luck() {
        return 1;
    }

    @Override
    public ChatColor color() {
        return ChatColor.GREEN;
    }
}
