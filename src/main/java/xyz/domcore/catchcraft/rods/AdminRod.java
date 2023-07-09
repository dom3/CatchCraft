package xyz.domcore.catchcraft.rods;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public class AdminRod extends CustomRod{
    @Override
    public String id() {
        return "admin";
    }

    @Override
    public String name() {
        return "[Admin]";
    }

    @Override
    public ArrayList<String> bio() {
        ArrayList<String> list = new ArrayList<>();
        list.add("How do you have this?");
        return list;
    }

    @Override
    public float luck() {
        return 999;
    }

    @Override
    public ChatColor color() {
        return ChatColor.RED;
    }
}
