package xyz.domcore.catchcraft;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.domcore.catchcraft.commands.admin.GiveRodCommand;
import xyz.domcore.catchcraft.commands.admin.SetMiddlePointCommand;
import xyz.domcore.catchcraft.commands.player.SellCommand;
import xyz.domcore.catchcraft.fish.FishManager;
import xyz.domcore.catchcraft.listeners.FishListener;
import xyz.domcore.catchcraft.listeners.GameListener;
import xyz.domcore.catchcraft.rods.RodManager;

public final class CatchCraft extends JavaPlugin {

    public FileConfiguration config = this.getConfig();

    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;

    @Override
    public void onLoad() {
        CommandAPI.onLoad(new CommandAPIBukkitConfig(this));
    }

    @Override
    public void onEnable() {
        config.addDefault("midpoint",new Location(getServer().getWorld("world"),0,0,0));
        config.options().copyDefaults(true);
        saveConfig();
        // Plugin startup logic
        CommandAPI.onEnable();
        // Load rods
        RodManager.getInstance().init();
        // Load fishes
        FishManager.getInstance().init();

        //ADMIN CMDS
        CommandAPI.registerCommand(GiveRodCommand.class);
        CommandAPI.registerCommand(SetMiddlePointCommand.class);
        //PLAYER CMDS
        CommandAPI.registerCommand(SellCommand.class);

        //Register listeners
        getServer().getPluginManager().registerEvents(new FishListener(),this);
        getServer().getPluginManager().registerEvents(new GameListener(),this);

        if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        CommandAPI.onDisable();
    }

    public static String error(String message){
        return ChatColor.RED + "[Error] " + message;
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public static Economy getEconomy() {
        return econ;
    }
}
