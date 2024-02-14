package me.gamingoninsulin.slimefood.managers;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
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

    void registerItem(SlimefunItem item) {
        item.register(addon);
    }

    public SlimefunItemStack createItem(String id, Material type, String name, String... lore) {
        return new SlimefunItemStack(id, type, name, lore);
    }
}
