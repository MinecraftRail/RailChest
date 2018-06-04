package io.github.phantamanta44.mcrail.railchest;

import io.github.phantamanta44.mcrail.Rail;
import io.github.phantamanta44.mcrail.crafting.RailRecipe;
import io.github.phantamanta44.mcrail.module.IRailModule;
import io.github.phantamanta44.mcrail.railchest.item.ItemExtendedChest;
import io.github.phantamanta44.mcrail.railchest.tile.TileExtendedChest;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class RCMain extends JavaPlugin implements IRailModule {

    @Override
    public void phaseRegistration() {
        for (ChestTier tier : ChestTier.values())
            Rail.tileRegistry().register(new ItemExtendedChest(tier), b -> new TileExtendedChest(b, tier));
    }

    @Override
    public void phasePostRegistration() {
        Rail.recipes().register(new RailRecipe()
                .line("ddd").line("dcd").line("ddd")
                .ingredient('d', Material.DIRT)
                .ingredient('c', Material.CHEST)
                .withResult("railchest:dirt"));
        Rail.recipes().register(new RailRecipe()
                .line("ddd").line("dcd").line("ddd")
                .ingOreDict('d', "ingotCopper")
                .ingredient('c', Material.CHEST)
                .withResult("railchest:copper"));
        Rail.recipes().register(new RailRecipe()
                .line("ddd").line("dcd").line("ddd")
                .ingOreDict('d', "ingotIron")
                .ingredient('c', Material.CHEST)
                .withResult("railchest:iron"));
        Rail.recipes().register(new RailRecipe()
                .line("dgd").line("gcg").line("dgd")
                .ingOreDict('d', "ingotIron")
                .ingOreDict('g', "glass")
                .ingredient('c', "railchest:copper")
                .withResult("railchest:iron"));
        Rail.recipes().register(new RailRecipe()
                .line("ddd").line("dcd").line("ddd")
                .ingOreDict('d', "ingotSilver")
                .ingredient('c', "railchest:copper")
                .withResult("railchest:silver"));
        Rail.recipes().register(new RailRecipe()
                .line("ddd").line("dcd").line("ddd")
                .ingOreDict('d', "ingotSilver")
                .ingredient('c', "railchest:iron")
                .withResult("railchest:silver"));
        Rail.recipes().register(new RailRecipe()
                .line("ddd").line("dcd").line("ddd")
                .ingOreDict('d', "ingotGold")
                .ingredient('c', "railchest:iron")
                .withResult("railchest:gold"));
        Rail.recipes().register(new RailRecipe()
                .line("dgd").line("gcg").line("dgd")
                .ingOreDict('d', "ingotGold")
                .ingOreDict('g', "glass")
                .ingredient('c', "railchest:silver")
                .withResult("railchest:gold"));
        Rail.recipes().register(new RailRecipe()
                .line("ggg").line("dcd").line("ggg")
                .ingOreDict('g', "glass")
                .ingOreDict('d', "gemDiamond")
                .ingredient('c', "railchest:gold")
                .withResult("railchest:diamond"));
        Rail.recipes().register(new RailRecipe()
                .line("ggg").line("gcg").line("ddd")
                .ingOreDict('g', "glass")
                .ingOreDict('d', "gemDiamond")
                .ingredient('c', "railchest:silver")
                .withResult("railchest:diamond"));
    }

}
