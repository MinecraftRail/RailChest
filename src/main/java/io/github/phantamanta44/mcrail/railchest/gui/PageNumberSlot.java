package io.github.phantamanta44.mcrail.railchest.gui;

import io.github.phantamanta44.mcrail.gui.slot.GuiSlot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PageNumberSlot extends GuiSlot {

    private final GuiExtendedChest gui;
    private final ItemStack stack;
    private final ItemMeta meta;

    public PageNumberSlot(GuiExtendedChest gui) {
        this.gui = gui;
        this.stack = new ItemStack(Material.CHEST);
        this.meta = stack.getItemMeta();
    }

    @Override
    public ItemStack stack() {
        meta.setDisplayName(String.format("%sPage %d of %d", ChatColor.BLUE, gui.getPage() + 1, gui.getPageCount()));
        stack.setItemMeta(meta);
        return stack;
    }

}
