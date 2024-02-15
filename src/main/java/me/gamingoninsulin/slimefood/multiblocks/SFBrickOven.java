package me.gamingoninsulin.slimefood.multiblocks;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.core.multiblocks.MultiBlockMachine;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class SFBrickOven extends MultiBlockMachine implements RecipeDisplayItem {

    private final ItemStack[] recipe;

    public SFBrickOven(ItemGroup itemGroup, SlimefunItemStack item, ItemStack[] multiblock, ItemStack[] recipe) {
        super(itemGroup, item, multiblock, recipe, BlockFace.NORTH);
        this.recipe = recipe;
    }

    @Override
    public List<ItemStack> getDisplayRecipes() {
        return List.of(recipe);
    }

    private static ItemStack[] getMultiBlockPattern() {
        return new ItemStack[]{
                null, new ItemStack(Material.BRICK), null,
                null, new ItemStack(Material.FIRE), null,
                null, new ItemStack(Material.BRICK), null
        };
    }

    @Override
    public void onInteract(Player p, Block b) {
        // Get the dispenser block
        Block dispenserBlock = b.getRelative(BlockFace.DOWN);
        if (dispenserBlock.getType() != Material.DISPENSER) {
            return;
        }

        // Get the dispenser's inventory
        Dispenser dispenser = (Dispenser) dispenserBlock.getState();
        Inventory inv = dispenser.getInventory();

        // Check if the dispenser has the required items for the recipe
        for (ItemStack item : recipe) {
            if (!inv.containsAtLeast(item, item.getAmount())) {
                p.sendMessage(ChatColor.RED + "The oven is missing some ingredients!");
                return;
            }
        }

        // Remove the required items from the dispenser's inventory
        for (ItemStack item : recipe) {
            inv.removeItem(item);
        }

        // Add the result of the recipe to the dispenser's inventory
        inv.addItem(getRecipeOutput());

        p.sendMessage(ChatColor.GREEN + "The oven successfully cooked the recipe!");
    }

    SlimefunItemStack item = new SlimefunItemStack("SF_BRICK_OVEN", Material.BRICK, "Brick Oven", "...");
}