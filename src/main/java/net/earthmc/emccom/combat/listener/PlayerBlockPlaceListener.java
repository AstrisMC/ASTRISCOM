package net.earthmc.emccom.combat.listener;

import net.earthmc.emccom.EMCCOM;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerBlockPlaceListener implements Listener {
    private final EMCCOM plugin;

    public PlayerBlockPlaceListener(EMCCOM plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.COBWEB) {
            Player player = event.getPlayer();
            player.setCooldown(Material.COBWEB, 100);

            Block block = event.getBlock();
            new BukkitRunnable() {
                @Override
                public void run() {
                    block.setType(Material.AIR);
                }
            }.runTaskLater(plugin, 60);
        }
    }
}