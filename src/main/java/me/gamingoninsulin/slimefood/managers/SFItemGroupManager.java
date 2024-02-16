package me.gamingoninsulin.slimefood.managers;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.gamingoninsulin.slimefood.food.SFChocolateApple;
import me.gamingoninsulin.slimefood.food.SFSlimyCake;
import me.gamingoninsulin.slimefood.multiblocks.SFBrickOven;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class SFItemGroupManager {
    private final ItemGroup itemGroup;

    public SFItemGroupManager(JavaPlugin plugin) {
        ItemStack itemGroupItem = new CustomItemStack(Material.CAKE, "&2SlimeFood", "", "&a> Click to open");
        NamespacedKey itemGroupId = new NamespacedKey(plugin, "sf_slime_food_plugin");
        this.itemGroup = new ItemGroup(itemGroupId, itemGroupItem);
    }

    public void addItem(SlimefunItem item) {
        itemGroup.add(item);
    }

    public void addItems(SFBrickOven sfBrickOven, SFSlimyCake sfSlimyCake, SFChocolateApple sfChocolateApple) {
        addItem(sfBrickOven);
        addItem(sfSlimyCake);
        addItem(sfChocolateApple);
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }
}