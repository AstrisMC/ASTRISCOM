package net.earthmc.emccom.combat.listener;

import net.earthmc.emccom.EMCCOM;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.entity.Player;

public class PlayerItemConsumeListener implements Listener {
    private final EMCCOM plugin;

    public PlayerItemConsumeListener(EMCCOM plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {
        if (event.getItem().getType() == Material.GOLDEN_APPLE) {
            Player player = event.getPlayer();
            player.setCooldown(Material.GOLDEN_APPLE, plugin.getConfig().getInt("golden_apple_cooldown_ticks", 600));
        }
    }
}