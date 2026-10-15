package org.lushplugins.unbreakableblocks.command;

import org.lushplugins.unbreakableblocks.UnbreakableBlocks;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.actor.BukkitCommandActor;
import revxrsal.commands.bukkit.annotation.CommandPermission;

@SuppressWarnings("unused")
@Command("unbreakableblocks")
public class UnbreakableBlocksCommand {

    @Subcommand("reload")
    @CommandPermission("unbreakableblocks.reload")
    public void reload(BukkitCommandActor actor) {
        UnbreakableBlocks.getInstance().getConfigManager().reload();

        actor.sender().sendMessage(UnbreakableBlocks.getInstance().getConfigManager().getReloadMessage());
    }
}
