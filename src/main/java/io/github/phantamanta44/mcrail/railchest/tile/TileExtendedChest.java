package io.github.phantamanta44.mcrail.railchest.tile;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.github.phantamanta44.mcrail.model.IItemAcceptor;
import io.github.phantamanta44.mcrail.model.IItemProvider;
import io.github.phantamanta44.mcrail.railchest.ChestTier;
import io.github.phantamanta44.mcrail.railchest.gui.GuiExtendedChest;
import io.github.phantamanta44.mcrail.tile.RailTile;
import io.github.phantamanta44.mcrail.util.JsonUtils;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;

public class TileExtendedChest extends RailTile implements IItemProvider, IItemAcceptor {

    private final ChestTier tier;
    private ItemStack[] inv;

    public TileExtendedChest(Block block, ChestTier tier) {
        super(block, tier.id);
        this.tier = tier;
        this.inv = new ItemStack[tier.capacity];
    }

    @Override
    public void init() {
        // NO-OP
    }

    @Override
    public boolean onInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && !event.getPlayer().isSneaking()) {
            event.setCancelled(true);
            block().getWorld().playSound(location(), Sound.CHEST_OPEN, 1F, 1F);
            new GuiExtendedChest(this, event.getPlayer());
            return false;
        }
        return true;
    }

    @Override
    public JsonObject serialize() {
        JsonObject dto = new JsonObject();
        JsonArray invDto = new JsonArray();
        Arrays.stream(inv).forEach(stack -> invDto.add(JsonUtils.serItemStack(stack)));
        dto.add("inv", invDto);
        return dto;
    }

    @Override
    public void deserialize(JsonObject dto) {
        JsonArray invDto = dto.get("inv").getAsJsonArray();
        for (int i = 0; i < invDto.size(); i++)
            inv[i] = JsonUtils.deserItemStack(invDto.get(i));
    }

    @Override
    public void modifyDrops(Collection<ItemStack> drops) {
        Arrays.stream(inv)
                .filter(Objects::nonNull)
                .forEach(drops::add);
    }

    public ItemStack[] getInventory() {
        return inv;
    }

    public ChestTier getTier() {
        return tier;
    }

    @Override
    public ItemStack offer(ItemStack stack, int amount) {
        return null; // TODO Implement
    }

    @Override
    public boolean hasSpace(ItemStack stack, int amount) {
        return false; // TODO Implement
    }

    @Override
    public int space(ItemStack stack, int amount) {
        return 0; // TODO Implement
    }

    @Override
    public ItemStack request(Predicate<ItemStack> filter, int amount) {
        return null; // TODO Implement
    }

    @Override
    public boolean contains(Predicate<ItemStack> filter, int amount) {
        return false; // TODO Implement
    }

    @Override
    public int quantity(Predicate<ItemStack> filter) {
        return 0; // TODO Implement
    }

}
