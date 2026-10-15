package org.lushplugins.unbreakableblocks;

import org.lushplugins.lushlib.utils.plugin.SpigotPlugin;
import org.lushplugins.unbreakableblocks.command.UnbreakableBlocksCommand;
import org.lushplugins.unbreakableblocks.config.ConfigManager;
import org.lushplugins.unbreakableblocks.listener.BlockListener;
import org.lushplugins.unbreakableblocks.listener.SpawnerListener;
import revxrsal.commands.bukkit.BukkitLamp;

public final class UnbreakableBlocks extends SpigotPlugin {
    private static UnbreakableBlocks plugin;

    private ConfigManager configManager;

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        this.configManager = new ConfigManager();
        this.configManager.reload();

        registerListeners(
            new BlockListener(),
            new SpawnerListener()
        );

        BukkitLamp.builder(this)
            .build()
            .register(new UnbreakableBlocksCommand());
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public static UnbreakableBlocks getInstance() {
        return plugin;
    }
}
