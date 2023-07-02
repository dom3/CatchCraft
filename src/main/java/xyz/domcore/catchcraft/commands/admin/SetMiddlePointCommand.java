package xyz.domcore.catchcraft.commands.admin;

import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import dev.jorel.commandapi.annotations.Permission;
import org.bukkit.entity.Player;
import xyz.domcore.catchcraft.CatchCraft;
import xyz.domcore.catchcraft.fish.FishManager;

@Command("setmidpoint")
@Permission("cc.admin.setmidpoint")
public class SetMiddlePointCommand {
    @Default
    public static void set(Player player){
        FishManager.getInstance().location = player.getLocation();
        CatchCraft.getPlugin(CatchCraft.class).config.set("midpoint",FishManager.getInstance().location);
        CatchCraft.getPlugin(CatchCraft.class).saveConfig();
        CatchCraft.getPlugin(CatchCraft.class).reloadConfig();
    }
}
