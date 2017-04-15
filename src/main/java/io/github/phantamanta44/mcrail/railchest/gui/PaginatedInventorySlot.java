package io.github.phantamanta44.mcrail.railchest.gui;

import io.github.phantamanta44.mcrail.gui.slot.InventorySlot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PaginatedInventorySlot extends InventorySlot {

    private static final ItemStack UNAVAIL;

    static {
        UNAVAIL = new ItemStack(Material.IRON_FENCE);
        ItemMeta meta = UNAVAIL.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Unavailable Slot");
        UNAVAIL.setItemMeta(meta);
    }

    private final GuiExtendedChest gui;
    private final int index;

    public PaginatedInventorySlot(GuiExtendedChest gui, int index) {
        super(gui, index);
        this.gui = gui;
        this.index = index;
    }

    @Override
    public ItemStack stack() {
        int index = index();
        if (index >= gui.size())
            return UNAVAIL;
        if (dirty) {
            gui.set(index, gui.inventory().getItem(gui.indexOf(this)));
            dirty = false;
        }
        return gui.get(index);
    }

    @Override
    public boolean onInteract(Player player, InventoryClickEvent event) {
        return index() < gui.size() && super.onInteract(player, event);
    }

    private int index() {
        return index + gui.getPage() * 45;
    }

}
