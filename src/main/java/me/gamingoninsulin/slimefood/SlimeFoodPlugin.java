package me.gamingoninsulin.slimefood;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.gamingoninsulin.slimefood.managers.SFItemManager;
import me.gamingoninsulin.slimefood.managers.SFRecipeManager;
import me.gamingoninsulin.slimefood.managers.SFResearchManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
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
        SFResearchManager researchManager = new SFResearchManager();
        this.registerManager(researchManager);

//        SFBrickOven sfBrickOven = new SFBrickOven(this);
//        Bukkit.getPluginManager().registerEvents((Listener) sfBrickOven, this);

        // Register the SFSlimyCake item
        System.out.println("Before registering SFSlimyCake");
        recipeManager.registerSFSlimyCake();
        System.out.println("After registering SFSlimyCake");

        // Register the SFChocolateApple item
        System.out.println("Before registering SFChocolateApple");
        recipeManager.registerSFChocolateApple();
        System.out.println("After registering SFChocolateApple");

        // Read something from your config.yml
        Config cfg = new Config(this);

        // Get the name of your plugin
        String name = cfg.getString("name");
        // Get the version of your plugin
        String version = cfg.getString("version");
        // Get the author of your plugin
        String author = cfg.getString("author");
        // Get the description of your plugin
        String description = cfg.getString("description");
        // Get the website of your plugin
        String website = cfg.getString("website");

        // Print some information to the console
        getLogger().info("Loading " + name + " v" + version + " by " + author);
        getLogger().info(description);
        getLogger().info("Visit " + website + " for more information.");

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }
    }
    public void registerManager(SFResearchManager manager) {
        // Your code to register the manager goes here
        System.out.println("SFResearchManager has been registered!");
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
