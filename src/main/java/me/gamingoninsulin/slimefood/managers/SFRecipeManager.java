package me.gamingoninsulin.slimefood.managers;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.gamingoninsulin.slimefood.food.SFSlimyCake;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class SFRecipeManager {
    private final SlimefunAddon addon;
    private final ItemGroup itemGroup;
    private final SFItemManager itemManager;


    public SFRecipeManager(SlimefunAddon addon, ItemGroup itemGroup) {
        this.addon = addon;
        this.itemGroup = itemGroup;
        this.itemManager = new SFItemManager(addon, itemGroup);
    }

    public void registerSFSlimyCake() {
        // Create and register the slimy cake item and its recipe
        SlimefunItemStack slimeCake = itemManager.createAndRegisterItem("SLIME_CAKE", Material.CAKE, "§2Slimy Cake", itemGroup, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                // ... existing code ...
        });
    }
}
