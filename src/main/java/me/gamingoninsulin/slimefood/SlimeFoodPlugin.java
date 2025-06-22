package me.gamingoninsulin.slimefood;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import me.gamingoninsulin.slimefood.managers.SFItemGroupManager;
import me.gamingoninsulin.slimefood.managers.SFItemManager;
import me.gamingoninsulin.slimefood.managers.SFRecipeManager;
import me.gamingoninsulin.slimefood.managers.SFResearchManager;
import me.gamingoninsulin.slimefood.multiblocks.SFBrickOven;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
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
        // register managers
        // SFItemGroupManager
        SFItemGroupManager itemGroupManager = new SFItemGroupManager(this);
        ItemGroup itemGroup = itemGroupManager.getItemGroup();
        // SFItemManager
        SFItemManager itemManager = new SFItemManager(this, itemGroup);
        // SFRecipeManager
        SFRecipeManager recipeManager = new SFRecipeManager(itemGroup, itemManager, this); // Modify this line
        // SFResearchManager
        SFResearchManager researchManager = new SFResearchManager();
        this.registerManager(researchManager);
        getLogger().info("SlimeFood Managers has been enabled!");

        // Register Multiblock
        // Initialize SFBrickOven
        // Create and register SFBrickOven
        SlimefunItemStack sfBrickOvenItem = itemManager.createSFBrickOven();
        ItemStack[] multiblock = SFBrickOven.getMultiBlockPattern(); // Use the method from SFBrickOven class
        ItemStack[] recipe = new ItemStack[]{new ItemStack(Material.APPLE), new ItemStack(Material.SUGAR), null, null, null, null, null, null, null};
        sfBrickOven = new SFBrickOven(itemGroup, sfBrickOvenItem, multiblock, recipe, BlockFace.SELF);
        //itemManager.registerSFBrickOven(sfBrickOven);
        itemGroupManager.addItem(sfBrickOven);

        getLogger().info("SlimeFood Multibiocks has been enabled!");

        // Register the SFBrickOven recipe
        recipeManager.registerSFBrickOven(sfBrickOven);
        // Register the SFSlimyCake item
        recipeManager.registerSFSlimyCake();
        // Register the SFChocolateApple item
        recipeManager.registerSFChocolateApple();
        getLogger().info("SlimeFood Food Items has been enabled!");

        // Config File
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
        getLogger().info("SlimeFood has been enabled!");
    }

    public void registerManager(SFResearchManager manager) {
        // Your code to register the manager goes here
        getLogger().info("SFResearchManager has been registered!");
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