package me.gamingoninsulin.slimefood.managers;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.gamingoninsulin.slimefood.multiblocks.SFBrickOven;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class SFItemManager {
    private final SlimefunAddon addon;
    private final ItemGroup itemGroup;

    public SFItemManager(SlimefunAddon addon, ItemGroup itemGroup) {
        this.addon = addon;
        this.itemGroup = itemGroup;
    }

    public void createAndRegisterItem(String id, Material type, String name, RecipeType recipeType, ItemStack[] recipe, String... lore) {
        SlimefunItemStack itemStack = createItem(id, type, name, lore);
        SlimefunItem item = new SlimefunItem(itemGroup, itemStack, recipeType, recipe);
        registerItem(item);
    }

    public SlimefunItemStack createSFBrickOven() {
        // Create your SFBrickOven item here
        return new SlimefunItemStack("SF_BRICK_OVEN", Material.BRICK, "Brick Oven", "...");
    }
    public void registerSFBrickOven(SFBrickOven sfBrickOven) {
        sfBrickOven.register(this.addon);
    }

    void registerItem(SlimefunItem item) {
        item.register(addon);
    }

    public SlimefunItemStack createItem(String id, Material type, String name, String... lore) {
        return new SlimefunItemStack(id, type, name, lore);
    }
}
