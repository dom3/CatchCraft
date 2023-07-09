package xyz.domcore.catchcraft.items;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import xyz.domcore.catchcraft.ItemBuilder;
import xyz.domcore.catchcraft.fish.Fish;
import xyz.domcore.catchcraft.fish.FishManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemManager {

    static ItemManager instance;
    public ArrayList<CustomItem> customItems = new ArrayList<>();

    public ItemManager() {

    }

    public static ItemManager getInstance() {
        if (instance == null) {
            instance = new ItemManager();
        }
        return instance;
    }

    public void init() {
        customItems.add(new RideBow());
    }

    public CustomItem getItemById(String id) {
        CustomItem f = null;
        for (CustomItem fish : customItems) {
            if (Objects.equals(fish.id(), id)) {
                f=fish;
            }
        }
        return f;
    }

    public void giveItem(CustomItem item, Player player) {
        ItemBuilder i = new ItemBuilder(item.material(),"item:" + item.id(),item.name(),new ArrayList<>());
    }

    public CustomItem getItemByLore(List<String> lore) {
        return getItemById(lore.get(lore.size() - 1));
    }
}
