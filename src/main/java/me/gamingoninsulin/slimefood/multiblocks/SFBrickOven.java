package me.gamingoninsulin.slimefood.multiblocks;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.core.multiblocks.MultiBlockMachine;
import me.gamingoninsulin.slimefood.SlimeFoodPlugin;

public class SFBrickOven extends MultiBlockMachine implements RecipeDisplayItem {

	
	
    private final SlimeFoodPlugin plugin = null;
    private final ItemStack[] recipe;

    public SFBrickOven(ItemGroup itemGroup, SlimefunItemStack item, ItemStack[] multiblock, ItemStack[] recipe, BlockFace self) {
        super(itemGroup, item, multiblock, recipe, BlockFace.SELF);
        this.recipe = recipe;
    }

    @Override
    public List<ItemStack> getDisplayRecipes() {
        return List.of(recipe);
    }

    public static ItemStack[] getMultiBlockPattern() {
        return new ItemStack[]{
                new ItemStack(Material.STONE_BRICKS), new ItemStack(Material.STONE_BRICKS), new ItemStack(Material.STONE_BRICKS),
                new ItemStack(Material.STONE_BRICKS), new ItemStack(Material.DISPENSER), new ItemStack(Material.STONE_BRICKS),
                new ItemStack(Material.STONE_BRICKS), new ItemStack(Material.STONE_BRICKS), new ItemStack(Material.STONE_BRICKS)
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
                p.sendMessage(ChatColor.RED + "砖炉缺少材料!");
                return;
            }
        }

        // Remove the required items from the dispenser's inventory
        for (ItemStack item : recipe) {
            inv.removeItem(item);
        }

        // Add the result of the recipe to the dispenser's inventory
        inv.addItem(getRecipeOutput());

        p.sendMessage(ChatColor.GREEN + "砖炉成功烹饪美食!");
    }

    public void registerSFBrickOven(SFBrickOven sfBrickOven) {
        // Register the SFBrickOven
        sfBrickOven.register(this.plugin);

    }
    
    public static final SlimefunItemStack SF_BRICK_OVEN = new SlimefunItemStack("SF_BRICK_OVEN", Material.BRICK, "砖炉", "...");
}
