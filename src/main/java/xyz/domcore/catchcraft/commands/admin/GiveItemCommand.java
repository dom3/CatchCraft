package xyz.domcore.catchcraft.commands.admin;

import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import dev.jorel.commandapi.annotations.Permission;
import dev.jorel.commandapi.annotations.arguments.APlayerArgument;
import dev.jorel.commandapi.annotations.arguments.AStringArgument;
import org.bukkit.entity.Player;
import xyz.domcore.catchcraft.items.ItemManager;

@Command("giveitem")
@Permission("cc.admin.giveitem")
public class GiveItemCommand {
    @Default
    public static void give(Player player, @AStringArgument String id, @APlayerArgument Player target) {
        ItemManager.getInstance().giveItem(ItemManager.getInstance().getItemById(id), target);
    }
}
