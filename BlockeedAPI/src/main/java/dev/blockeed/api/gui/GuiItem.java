package dev.blockeed.api.gui;

/*
 * Copyright (c) Blockeed | All rights reserved
 *
 * Do not change the code!
 *
 */

import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import java.util.function.Consumer;

public class GuiItem implements Listener {

    private ItemStack itemStack;
    private Consumer<InventoryClickEvent> eventConsumer;

    public GuiItem(ItemStack itemStack, Consumer<InventoryClickEvent> eventConsumer) {
        this.itemStack=itemStack;
        this.eventConsumer=eventConsumer;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
