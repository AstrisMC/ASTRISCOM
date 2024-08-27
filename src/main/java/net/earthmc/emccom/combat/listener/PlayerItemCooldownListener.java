package net.earthmc.emccom.combat.listener;

import io.papermc.paper.event.player.PlayerItemCooldownEvent;
import net.earthmc.emccom.EMCCOM;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerItemCooldownListener implements Listener {
    private final EMCCOM plugin;

    public PlayerItemCooldownListener(EMCCOM plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerItemCooldown(PlayerItemCooldownEvent event) {
        if (event.getType() == Material.ENDER_PEARL) {
            event.setCooldown(plugin.getConfig().getInt("ender_pearl_cooldown_ticks", 240));
        } else if (event.getType() == Material.GOLDEN_APPLE) {
            event.setCooldown(plugin.getConfig().getInt("golden_apple_cooldown_ticks", 600));
        }
    }
}