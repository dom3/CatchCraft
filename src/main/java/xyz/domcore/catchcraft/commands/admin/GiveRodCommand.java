package xyz.domcore.catchcraft.commands.admin;

import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import dev.jorel.commandapi.annotations.Permission;
import dev.jorel.commandapi.annotations.arguments.APlayerArgument;
import dev.jorel.commandapi.annotations.arguments.AStringArgument;
import org.bukkit.entity.Player;
import xyz.domcore.catchcraft.CatchCraft;
import xyz.domcore.catchcraft.rods.RodManager;

@Command("giverod")
@Permission("cc.admin.giverod")
public class GiveRodCommand {
    @Default
    public static void give(Player player, @AStringArgument String id, @APlayerArgument Player target) {
        if (target != null) {
            RodManager.getInstance().giveRod(id.toLowerCase(),target);
        } else {
            player.sendMessage(CatchCraft.error("User does not exist!"));
        }
    }
}
