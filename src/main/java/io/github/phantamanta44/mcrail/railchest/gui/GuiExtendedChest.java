package io.github.phantamanta44.mcrail.railchest.gui;

import io.github.phantamanta44.mcrail.gui.GuiInventory;
import io.github.phantamanta44.mcrail.railchest.tile.EntityExtendedChest;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

public class GuiExtendedChest extends GuiInventory {

    private final int pageCount;
    private int page;

    public GuiExtendedChest(EntityExtendedChest se, Player pl) {
        super(6, se.getName(), pl, se.getInventory(),
                (gui, index) -> new PaginatedInventorySlot((GuiExtendedChest)gui, index));
        this.pageCount = (int)Math.ceil(size() / 45D);
        this.page = 0;
    }

    @Override
    public void init() {
        slot(0, new PageOffsetSlot(this, "Previous Page", -1));
        slot(4, new PageNumberSlot(this));
        slot(8, new PageOffsetSlot(this, "Next Page", 1));
        for (int i = 0; i < 45; i++)
            slot(i + 9, genSlot(i));
        setPage(0);
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getPage() {
        return page;
    }

}
