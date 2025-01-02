package me.gamingoninsulin.slimefood.food;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class SFSlimyCake extends SlimefunItem {

    private final SlimefunItemStack slimeCake;

    public SFSlimyCake(ItemGroup itemGroup) {
        super(itemGroup,
                new SlimefunItemStack(
                        "SLIME_CAKE", // This is the ID for your item
                        Material.CAKE, // This is the material for your item
                        "&a粘液蛋糕", // This is the name of your item
                        "", // This is the lore of your item
                        "&7&o恢复 &b&o" + "6.0" + " &7&o饥饿值" // This is additional lore of your item
                ),
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.MILK_BUCKET), new ItemStack(Material.MILK_BUCKET), new ItemStack(Material.MILK_BUCKET),
                        new ItemStack(Material.SUGAR), new ItemStack(Material.EGG), new ItemStack(Material.SUGAR),
                        new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL)
                }
        );

        this.slimeCake = (SlimefunItemStack) this.getItem();
    }

    public SlimefunItemStack getSlimeCake() {
        return slimeCake;
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
