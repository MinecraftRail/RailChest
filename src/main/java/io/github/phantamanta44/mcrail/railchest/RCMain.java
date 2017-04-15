package io.github.phantamanta44.mcrail.railchest;

import io.github.phantamanta44.mcrail.RailMain;
import io.github.phantamanta44.mcrail.railchest.tile.EntityExtendedChest;
import org.bukkit.plugin.java.JavaPlugin;

public class RCMain extends JavaPlugin {

    @Override
    public void onEnable() {
        RailMain.INSTANCE.registry().register("dirtchest", b -> new EntityExtendedChest(b, 1, "Dirt Chest"));
        RailMain.INSTANCE.registry().register("ironchest", b -> new EntityExtendedChest(b, 54, "Iron Chest"));
        RailMain.INSTANCE.registry().register("goldchest", b -> new EntityExtendedChest(b, 81, "Gold Chest"));
        RailMain.INSTANCE.registry().register("diamondchest", b -> new EntityExtendedChest(b, 108, "Diamond Chest"));
    }

}
