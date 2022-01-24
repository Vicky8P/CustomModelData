package it.vicky.custommodeldata;

import it.vicky.custommodeldata.commands.CustomModelDataCommand;
import it.vicky.custommodeldata.listeners.InventoryListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomModelData extends JavaPlugin {

    @Getter
    private static CustomModelData instance;

    @Override
    public void onEnable() {
        instance = this;

        registerCommands();
        registerListeners();
    }

    @Override
    public void onDisable() {}

    private void registerCommands() {
        getCommand("modeldata").setExecutor(new CustomModelDataCommand());
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
    }
}
