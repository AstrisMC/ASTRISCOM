package net.earthmc.emccom.config;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    public static void init(FileConfiguration config) {
        config.addDefault("ender_pearl_cooldown_ticks", 240);
        config.addDefault("golden_apple_cooldown_ticks", 600);

        config.options().copyDefaults(true);
    }
}