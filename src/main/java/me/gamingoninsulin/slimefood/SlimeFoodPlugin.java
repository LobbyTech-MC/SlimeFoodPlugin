package me.gamingoninsulin.slimefood;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.gamingoninsulin.slimefood.managers.SFItemManager;
import me.gamingoninsulin.slimefood.managers.SFRecipeManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;

public class SlimeFoodPlugin extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {

        // Create a new ItemGroup
        ItemStack itemGroupItem = new CustomItemStack(Material.CAKE, "&2SlimeFood", "", "&a> Click to open");
        NamespacedKey itemGroupId = new NamespacedKey(this, "sf_slime_food_plugin");
        ItemGroup itemGroup = new ItemGroup(itemGroupId, itemGroupItem);

        SFItemManager itemManager = new SFItemManager(this, itemGroup);
        SFRecipeManager recipeManager = new SFRecipeManager(itemGroup, itemManager);

        // Register the SFSlimyCake item
        recipeManager.registerSFSlimyCake();

        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return "https://github.com/gamingoninsulin/SlimeFoodPlugin/issues";
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
