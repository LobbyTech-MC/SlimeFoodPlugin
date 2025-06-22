package me.gamingoninsulin.slimefood.food;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;

public class SFChocolateApple extends SlimefunItem {
    private final SlimefunItemStack chocolateApple;

    public SFChocolateApple(ItemGroup itemGroup) {
        super(itemGroup,
                new SlimefunItemStack(
                        "CHOCOLATE_APPLE", // This is the ID for your item
                        Material.APPLE, // This is the material for your item
                        "&6巧克力苹果", // This is the name of your item
                        "", // This is the lore of your item
                        "&7&o恢复 &b&o" + "8.0" + " &7&o饥饿值" // This is additional lore of your item
                ),
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.COCOA_BEANS), null, new ItemStack(Material.COCOA_BEANS),
                        null, new ItemStack(Material.APPLE), null,
                        new ItemStack(Material.COCOA_BEANS), null, new ItemStack(Material.COCOA_BEANS)
                }
        );

        this.chocolateApple = (SlimefunItemStack) this.getItem();
    }

    public SlimefunItemStack getChocolateApple() {
        return chocolateApple;
    }

    @Override
    public void preRegister() {
        ItemUseHandler itemUseHandler = this::onItemUseRightClick;
        addItemHandler(itemUseHandler);

        ItemUseHandler itemEatHandler = this::onPlayerEat;
        addItemHandler(itemEatHandler);
    }

    private void onItemUseRightClick(PlayerRightClickEvent event) {
        // Calling event.cancel() in here would prevent the cake
        // from being placed down.
        event.getPlayer().giveExpLevels(8);
    }

    private void onPlayerEat(PlayerRightClickEvent event) {
        // Calling event.cancel() in here would prevent the apple
        // from being eaten.
        event.getPlayer().setFoodLevel(event.getPlayer().getFoodLevel() + 8);
    }
}
