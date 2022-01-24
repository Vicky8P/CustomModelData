package it.vicky.custommodeldata.listeners;

import it.vicky.custommodeldata.utils.CustomModelDataUI;
import it.vicky.custommodeldata.utils.StringUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().contains("ModelData (page")) {
            if (event.getClickedInventory() == event.getView().getBottomInventory()) return;

            ItemStack clicked = event.getCurrentItem();
            ItemStack item = player.getInventory().getItemInMainHand();
            int page = Integer.parseInt(event.getView().getTitle().replace(" ModelData (page ", "").replace(item.getType().toString(), "").replace(")", ""));

            if (clicked == null || clicked.getType() == Material.AIR) return;

            if (clicked.getType() == Material.ARROW && clicked.getItemMeta().getDisplayName().contains("Previous page")) {
                page--;
                if (page <= 0) {
                    player.sendMessage(StringUtil.cc("&cError! This page doesn't exist!"));
                    event.setCancelled(true);
                    return;
                }
                CustomModelDataUI.open(player, item, page);
            } else if (clicked.getType() == Material.ARROW && clicked.getItemMeta().getDisplayName().contains("Next page")) {
                page++;
                CustomModelDataUI.open(player, item, page);
            } else {
                player.getInventory().addItem(clicked);
            }

            event.setCancelled(true);
        }
    }
}
