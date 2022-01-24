package it.vicky.custommodeldata.utils;

import it.mycraft.powerlib.inventory.InventoryBuilder;
import it.mycraft.powerlib.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CustomModelDataUI {
    public static void open(Player player, ItemStack item, int page) {
        Inventory inv = new InventoryBuilder()
                .setRows(6)
                .setTitle(item.getType() + " ModelData (page " + page + ")")
                .setItem(52, new ItemStack(new ItemBuilder().setMaterial(Material.ARROW).setName(StringUtil.cc("&fPrevious page")).build()))
                .setItem(53, new ItemStack(new ItemBuilder().setMaterial(Material.ARROW).setName(StringUtil.cc("&fNext page")).build()))
                .build();
        for (int i = (52*(page-1))+1; i < (52*(page-1))+54; i++) {
            ItemStack model = ItemUtil.changeModelData(
                    new ItemBuilder()
                            .setAmount(1)
                            .setMaterial(item.getType())
                            .setName(StringUtil.cc("&b" + item.getType() + " (&3&l" + i + "&b)"))
                            .build(), i
            );
            inv.addItem(model);
        }
        player.openInventory(inv);
    }
}