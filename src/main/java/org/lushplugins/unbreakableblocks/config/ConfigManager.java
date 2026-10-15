package org.lushplugins.unbreakableblocks.config;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.Registry;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;
import org.lushplugins.lushlib.utils.registry.RegistryUtils;
import org.lushplugins.unbreakableblocks.UnbreakableBlocks;

import java.util.List;

public class ConfigManager {
    private List<Material> unbreakableBlocks;
    private List<EntityType> torchDisabledSpawners;
    private Component denyMessage;
    private Component bypassMessage;
    private Component reloadMessage;

    public ConfigManager() {
        UnbreakableBlocks.getInstance().saveDefaultConfig();
    }

    public void reload() {
        UnbreakableBlocks.getInstance().reloadConfig();
        ConfigurationSection config = UnbreakableBlocks.getInstance().getConfig();

        this.unbreakableBlocks = RegistryUtils.fromStringList(config.getStringList("unbreakable-blocks"), Registry.MATERIAL);
        this.torchDisabledSpawners = RegistryUtils.fromStringList(config.getStringList("torch-disabled-spawners"), Registry.ENTITY_TYPE);

        MiniMessage miniMessage = MiniMessage.miniMessage();
        this.denyMessage = miniMessage.deserialize(config.getString("messages.deny-break", "<#ff6969>This block is unbreakable"));
        this.bypassMessage = miniMessage.deserialize(config.getString("messages.bypass", "<#ffda54>You have broken an unbreakable block"));
        this.reloadMessage = miniMessage.deserialize(config.getString("messages.reload", "<#b7faa2>UnbreakableBlocks has been reloaded"));
    }

    public List<Material> getUnbreakableBlocks() {
        return unbreakableBlocks;
    }

    public List<EntityType> getTorchDisabledSpawners() {
        return torchDisabledSpawners;
    }

    public Component getDenyMessage() {
        return denyMessage;
    }

    public Component getBypassMessage() {
        return bypassMessage;
    }

    public Component getReloadMessage() {
        return reloadMessage;
    }
}
