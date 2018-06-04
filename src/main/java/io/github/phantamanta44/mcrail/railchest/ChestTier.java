package io.github.phantamanta44.mcrail.railchest;

import org.bukkit.ChatColor;

public enum ChestTier {

    DIRT(1, ChatColor.RESET, "Dirt Chest", "dirt"),
    IRON(54, ChatColor.RESET, "Iron Chest", "iron"),
    GOLD(81, ChatColor.AQUA, "Gold Chest", "gold"),
    DIAMOND(108, ChatColor.LIGHT_PURPLE, "Diamond Chest", "diamond"),
    COPPER(45, ChatColor.RESET, "Copper Chest", "copper"),
    SILVER(72, ChatColor.AQUA, "Silver Chest", "silver");

    public final int capacity;
    public final ChatColor col;
    public final String name;
    public final String id;

    ChestTier(int capacity, ChatColor col, String name, String id) {
        this.capacity = capacity;
        this.col = col;
        this.name = name;
        this.id = "railchest:" + id;
    }

}
