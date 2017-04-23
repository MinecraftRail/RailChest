package io.github.phantamanta44.mcrail.railchest;

import io.github.phantamanta44.mcrail.Rail;
import io.github.phantamanta44.mcrail.crafting.RailRecipe;
import io.github.phantamanta44.mcrail.railchest.tile.EntityExtendedChest;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class RCMain extends JavaPlugin {

    @Override
    public void onEnable() {
        Rail.signRegistry().register(
                "railchest:dirt",
                ChatColor.WHITE + "Dirt Chest",
                b -> new EntityExtendedChest(b, 1, "Dirt Chest", "railchest:dirt"));
        Rail.recipes().register(new RailRecipe()
                .line("ddd").line("dcd").line("ddd")
                .ingredient('d', Material.DIRT)
                .ingredient('c', Material.CHEST)
                .withResult("railchest:dirt"));
        Rail.signRegistry().register(
                "railchest:iron",
                ChatColor.WHITE + "Iron Chest",
                b -> new EntityExtendedChest(b, 54, "Iron Chest", "railchest:iron"));
        Rail.recipes().register(new RailRecipe()
                .line("ddd").line("dcd").line("ddd")
                .ingredient('d', Material.IRON_INGOT)
                .ingredient('c', Material.CHEST)
                .withResult("railchest:iron"));
        Rail.signRegistry().register(
                "railchest:gold",
                ChatColor.AQUA + "Gold Chest",
                b -> new EntityExtendedChest(b, 81, "Gold Chest", "railchest:gold"));
        Rail.recipes().register(new RailRecipe()
                .line("ddd").line("dcd").line("ddd")
                .ingredient('d', Material.GOLD_INGOT)
                .ingredient('c', "railchest:iron")
                .withResult("railchest:gold"));
        Rail.signRegistry().register(
                "railchest:diamond",
                ChatColor.LIGHT_PURPLE + "Diamond Chest",
                b -> new EntityExtendedChest(b, 108, "Diamond Chest", "railchest:diamond"));
        Rail.recipes().register(new RailRecipe()
                .line("ggg").line("dcd").line("ggg")
                .ingredient('g', Material.GLASS)
                .ingredient('d', Material.DIAMOND)
                .ingredient('c', "railchest:gold")
                .withResult("railchest:diamond"));
    }

}
