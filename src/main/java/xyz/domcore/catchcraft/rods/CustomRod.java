package xyz.domcore.catchcraft.rods;

public abstract class CustomRod {
    /**
     * The id of the fishing rod
     */
    public abstract String id();

    /**
     * The name of the fishing rod
     */
    public abstract String name();

    /**
     * The description of the fishing rod
     */
    public abstract String bio();

    /**
     * The fishing rod's luck
     */
    public abstract int luck();
}
