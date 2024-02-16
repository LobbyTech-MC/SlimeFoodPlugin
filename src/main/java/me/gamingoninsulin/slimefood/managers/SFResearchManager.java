package me.gamingoninsulin.slimefood.managers;

import java.util.HashMap;

public class SFResearchManager {

    // Use a HashMap to store the item and It's corresponding to unlock level
    private final HashMap<String, Integer> researchItems = new HashMap<>();

    // Method to set the unlock level for a specific item
    public void setUnlockLevel(String item, int level) {
        researchItems.put(item, level);
    }

    // Method to get the unlock level of a specific item
    public int getUnlockLevel(String item) {
        return researchItems.getOrDefault(item, -1);
    }

    // Incorporating SFSlimyCake and SFCocolateApple
    public SFResearchManager() {
        setUnlockLevel("SFSlimyCake", 5); // Set the unlock level for SFSlimyCake to 4
        setUnlockLevel("SFCocolateApple", 5); // Set the unlock level for SFCocolateApple to 4
        setUnlockLevel("SFBrickOven", 25); // Set the unlock level for SFBrickOven to 4
    }
}
