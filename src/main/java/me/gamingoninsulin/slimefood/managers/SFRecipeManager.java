package me.gamingoninsulin.slimefood.managers;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.gamingoninsulin.slimefood.food.SFChocolateApple;
import me.gamingoninsulin.slimefood.food.SFSlimyCake;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class SFRecipeManager {
    private final ItemGroup itemGroup;
    private final SFItemManager itemManager;


    public SFRecipeManager(ItemGroup itemGroup, SFItemManager itemManager) {
        this.itemGroup = itemGroup;
        this.itemManager = itemManager;
    }

    public void registerSFSlimyCake() {
        SFSlimyCake sfSlimyCake = new SFSlimyCake(itemGroup);
        SlimefunItemStack slimeCake = sfSlimyCake.getSlimeCake();

        ItemStack[] recipe = {
                new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL),
                new ItemStack(Material.SUGAR), new ItemStack(Material.EGG), new ItemStack(Material.SUGAR),
                new ItemStack(Material.WHEAT), new ItemStack(Material.WHEAT), new ItemStack(Material.WHEAT)
        };

        // Register the slimy cake item
        itemManager.createAndRegisterItem(slimeCake.getItemId(), slimeCake.getType(), Objects.requireNonNull(slimeCake.getItemMeta()).getDisplayName(),
                RecipeType.ENHANCED_CRAFTING_TABLE, recipe, "&7&oRestores &b&o" + "6.0" + " &7&oHunger");
    }

    public void registerSFChocolateApple() {
        SFChocolateApple sfChocolateApple = new SFChocolateApple(itemGroup);
        SlimefunItemStack chocolateApple = sfChocolateApple.getChocolateApple();

        ItemStack[] recipe = {
                new ItemStack(Material.COCOA_BEANS), null, new ItemStack(Material.COCOA_BEANS),
                null, new ItemStack(Material.APPLE), null,
                new ItemStack(Material.COCOA_BEANS), null, new ItemStack(Material.COCOA_BEANS)
        };

        // Register the slimy cake item
        itemManager.createAndRegisterItem(chocolateApple.getItemId(), chocolateApple.getType(), Objects.requireNonNull(chocolateApple.getItemMeta()).getDisplayName(),
                RecipeType.ENHANCED_CRAFTING_TABLE, recipe, "&7&oRestores &b&o" + "6.0" + " &7&oHunger");
    }
}
