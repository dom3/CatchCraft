package xyz.domcore.catchcraft.rods;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public class Expert extends CustomRod{
    @Override
    public String id() {
        return "expert";
    }

    @Override
    public String name() {
        return "Expert";
    }

    @Override
    public ArrayList<String> bio() {
        ArrayList<String> list = new ArrayList<>();
        list.add("I've ran out of things to say");
        return list;
    }

    @Override
    public float luck() {
        return 0.7f;
    }

    @Override
    public ChatColor color() {
        return ChatColor.LIGHT_PURPLE;
    }
}
