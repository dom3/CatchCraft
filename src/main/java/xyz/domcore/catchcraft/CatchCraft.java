package xyz.domcore.catchcraft;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.domcore.catchcraft.commands.admin.GiveRodCommand;
import xyz.domcore.catchcraft.fish.FishManager;
import xyz.domcore.catchcraft.listeners.FishListener;
import xyz.domcore.catchcraft.rods.RodManager;

public final class CatchCraft extends JavaPlugin {

    @Override
    public void onLoad() {
        CommandAPI.onLoad(new CommandAPIBukkitConfig(this));
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        CommandAPI.onEnable();
        // Load rods
        RodManager.getInstance().init();
        // Load fishes
        FishManager.getInstance().init();
        // Register cmds
        //ADMIN CMDS
        CommandAPI.registerCommand(GiveRodCommand.class);

        //Register listeners
        getServer().getPluginManager().registerEvents(new FishListener(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        CommandAPI.onDisable();
    }

    public static String error(String message){
        return ChatColor.RED + "[Error] " + message;
    }
}
