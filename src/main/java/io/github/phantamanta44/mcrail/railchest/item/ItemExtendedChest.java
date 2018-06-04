package io.github.phantamanta44.mcrail.railchest.item;

import io.github.phantamanta44.mcrail.item.ItemRailTile;
import io.github.phantamanta44.mcrail.railchest.ChestTier;
import org.bukkit.Material;

public class ItemExtendedChest extends ItemRailTile {

    public ItemExtendedChest(ChestTier tier) {
        super(tier.id, tier.col + tier.name, Material.ENDER_CHEST);
    }

}
