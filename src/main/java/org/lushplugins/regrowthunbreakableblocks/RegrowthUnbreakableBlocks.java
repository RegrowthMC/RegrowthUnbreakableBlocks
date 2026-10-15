package org.lushplugins.regrowthunbreakableblocks;

import org.bukkit.plugin.java.JavaPlugin;

public final class RegrowthUnbreakableBlocks extends JavaPlugin {
    private static RegrowthUnbreakableBlocks plugin;

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        // Enable implementation
    }

    @Override
    public void onDisable() {
        // Disable implementation
    }

    public static RegrowthUnbreakableBlocks getInstance() {
        return plugin;
    }
}
