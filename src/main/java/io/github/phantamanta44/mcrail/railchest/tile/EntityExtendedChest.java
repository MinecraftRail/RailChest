package io.github.phantamanta44.mcrail.railchest.tile;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.github.phantamanta44.mcrail.railchest.gui.GuiExtendedChest;
import io.github.phantamanta44.mcrail.sign.SignEntity;
import io.github.phantamanta44.mcrail.util.JsonUtils;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class EntityExtendedChest extends SignEntity {

    private ItemStack[] inv;
    private String name;

    public EntityExtendedChest(Block block, int size, String name, String id) {
        super(block, id);
        this.inv = new ItemStack[size];
        this.name = name;
    }

    @Override
    public void init() {
        // NO-OP
    }

    @Override
    public void tick() {
        double fillPercent = Arrays.stream(inv)
                .filter(Objects::nonNull)
                .mapToDouble(stack -> (double)stack.getAmount() / (double)stack.getMaxStackSize())
                .sum() * 100 / (double)inv.length;
        lines().a(String.format("%.2f%% Full", fillPercent));
        int filledSlots = Arrays.stream(inv)
                .mapToInt(stack -> stack == null ? 0 : 1)
                .sum();
        lines().b(String.format("%d/%d Slots Used", filledSlots, inv.length));
    }

    @Override
    public void onInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK)
            new GuiExtendedChest(this, event.getPlayer());
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

    public String getName() {
        return name;
    }

}
