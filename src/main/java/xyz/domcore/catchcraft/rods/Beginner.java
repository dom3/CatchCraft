package xyz.domcore.catchcraft.rods;

public class Beginner extends CustomRod{

    @Override
    public String id() {
        return null;
    }

    @Override
    public String name() {
        return "Beginner";
    }

    @Override
    public String bio() {
        return "The beginning of your adventure. This rod sucks honestly.";
    }

    @Override
    public int luck() {
        return 1;
    }
}
