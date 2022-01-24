package it.vicky.custommodeldata.utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtil {

    public static ItemStack changeModelData(ItemStack is, int modelData) {
        ItemMeta meta = is.getItemMeta();
        meta.setCustomModelData(modelData);
        is.setItemMeta(meta);
        return is;
    }

}
