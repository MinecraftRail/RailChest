package io.github.phantamanta44.mcrail.railchest.gui;

import io.github.phantamanta44.mcrail.gui.slot.GuiSlot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PageOffsetSlot extends GuiSlot {

    private final GuiExtendedChest gui;
    private final ItemStack icon;
    private final int offset;

    public PageOffsetSlot(GuiExtendedChest gui, String name, int offset) {
        this.gui = gui;
        this.icon = new ItemStack(Material.PAPER);
        ItemMeta meta = this.icon.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + name);
        this.icon.setItemMeta(meta);
        this.offset = offset;
    }

    @Override
    public ItemStack stack() {
        return icon;
    }

    @Override
    public boolean onInteract(Player player, InventoryClickEvent event) {
        gui.setPage(Math.max(Math.min(gui.getPage() + offset, gui.getPageCount() - 1), 0));
        return false;
    }

}
