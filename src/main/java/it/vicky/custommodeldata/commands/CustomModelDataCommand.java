package it.vicky.custommodeldata.commands;

import it.vicky.custommodeldata.utils.CustomModelDataUI;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CustomModelDataCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§4You cannot run this command from the CONSOLE!");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("modeldata.use")) {
            player.sendMessage("§cYou don't have permission to perform this command!");
            return true;
        }

        if (player.getInventory().getItemInMainHand().getType() == Material.AIR) {
            player.sendMessage("§cError! You must have an item in main hand!");
            return true;
        }

        ItemStack item = player.getInventory().getItemInMainHand();
        CustomModelDataUI.open(player, item, 1);
        return false;
    }
}
