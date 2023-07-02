package xyz.domcore.catchcraft.rods;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public class Skilled extends CustomRod{
    @Override
    public String id() {
        return "skilled";
    }

    @Override
    public String name() {
        return "Skilled";
    }

    @Override
    public ArrayList<String> bio() {
        ArrayList<String> list = new ArrayList<>();
        list.add("You are finally not bad!");
        list.add("Good luck on your adventure!");
        return list;
    }

    @Override
    public float luck() {
        return 0.3f;
    }

    @Override
    public ChatColor color() {
        return ChatColor.BLUE;
    }
}
