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

    public SFItemManager(SlimefunAddon addon, ItemGroup itemGroup) {
        this.addon = addon;
    }
    public SlimefunItemStack createAndRegisterItem(String id, Material type, String name, ItemGroup itemGroup, RecipeType recipeType, ItemStack[] recipe, String... lore) {
        SlimefunItemStack itemStack = createItem(id, type, name, lore);
        SlimefunItem item = new SlimefunItem(itemGroup, itemStack, recipeType, recipe);
        registerItem(item);
        return itemStack;
    }

    void registerItem(SlimefunItem item) {
        item.register(addon);
    }

    public SlimefunItemStack createItem(String id, Material type, String name, String... lore) {
        return new SlimefunItemStack(id, type, name, lore);
    }
}
