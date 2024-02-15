package me.gamingoninsulin.slimefood;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.gamingoninsulin.slimefood.managers.SFItemManager;
import me.gamingoninsulin.slimefood.managers.SFRecipeManager;
import me.gamingoninsulin.slimefood.managers.SFResearchManager;
import me.gamingoninsulin.slimefood.multiblocks.SFBrickOven;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;

public class SlimeFoodPlugin extends JavaPlugin implements SlimefunAddon {

    // Declare an instance of SFBrickOven
    private SFBrickOven sfBrickOven;


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

        // Initialize SFBrickOven
        SlimefunItemStack item = new SlimefunItemStack("SF_BRICK_OVEN", Material.BRICK, "&cBrick Oven");
        ItemStack[] multiblock = new ItemStack[]{null, new ItemStack(Material.BRICK), null, null, new ItemStack(Material.FIRE), null, null, new ItemStack(Material.BRICK), null};
        ItemStack[] recipe = new ItemStack[]{new ItemStack(Material.APPLE), new ItemStack(Material.SUGAR), null, null, null, null, null, null, null};
        sfBrickOven = new SFBrickOven(itemGroup, item, multiblock, recipe);

        // Register the SFSlimyCake item
        recipeManager.registerSFSlimyCake();
        // Register the SFChocolateApple item
        recipeManager.registerSFChocolateApple();

        // Read something from your config.yml
        Config cfg = new Config(this);

        String name = cfg.getString("name");
        String version = cfg.getString("version");
        String author = cfg.getString("author");
        String description = cfg.getString("description");
        String website = cfg.getString("website");

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

    // Getter for SFBrickOven
    public SFBrickOven getSFBrickOven() {
        return sfBrickOven;
    }
}
