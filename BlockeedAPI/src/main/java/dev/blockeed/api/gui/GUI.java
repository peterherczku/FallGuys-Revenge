package dev.blockeed.api.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUI {

    private Inventory inventory;

    public GUI(int rows, String inventoryName) {
        inventory= Bukkit.createInventory(null,rows*9, inventoryName);
        new GuiItem(new ItemStack(Material.STONE), event -> {
            event.setCancelled(true);
        });
    }

    public void setItem(GuiItem item, Integer slot) {
        inventory.setItem(slot, item.getItemStack());
    }

    public void setItem(GuiItem item, Integer row, Integer col) {
        inventory.setItem(((row-1)*9)+col-1, item.getItemStack());
    }

    public void open(HumanEntity entity) {
        entity.openInventory(inventory);
    }

}
