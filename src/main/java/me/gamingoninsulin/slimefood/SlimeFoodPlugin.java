package me.gamingoninsulin.slimefood;

import me.gamingoninsulin.slimefood.managers.SFItemManager;
import me.gamingoninsulin.slimefood.managers.SFRecipeManager;;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;

public class SlimeFoodPlugin extends JavaPlugin implements SlimefunAddon {

    private SFItemManager itemManager;
    private SFRecipeManager recipeManager; // Change this line
    private ItemGroup itemGroup;
    @Override
    public void onEnable() {

        itemManager = new SFItemManager(this, itemGroup);
        recipeManager = new SFRecipeManager(this, itemGroup);


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
