package io.github.phantamanta44.mcrail.railchest;

import io.github.phantamanta44.mcrail.Rail;
import io.github.phantamanta44.mcrail.railchest.tile.EntityExtendedChest;
import org.bukkit.plugin.java.JavaPlugin;

public class RCMain extends JavaPlugin {

    @Override
    public void onEnable() {
        Rail.signRegistry().register("dirtchest", b -> new EntityExtendedChest(b, 1, "Dirt Chest"));
        Rail.signRegistry().register("ironchest", b -> new EntityExtendedChest(b, 54, "Iron Chest"));
        Rail.signRegistry().register("goldchest", b -> new EntityExtendedChest(b, 81, "Gold Chest"));
        Rail.signRegistry().register("diamondchest", b -> new EntityExtendedChest(b, 108, "Diamond Chest"));
    }

}
