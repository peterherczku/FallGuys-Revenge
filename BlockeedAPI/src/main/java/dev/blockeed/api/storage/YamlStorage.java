package dev.blockeed.api.storage;

/*
 * Copyright (c) Blockeed | All rights reserved
 *
 * Do not change the code!
 *
 */

import dev.blockeed.api.tools.MinecraftPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public abstract class YamlStorage extends StorageMethod<YamlStorage> {

    private File file;
    private FileConfiguration cfg;

    public YamlStorage(MinecraftPlugin plugin, String yamlNameWithExtension) {
        if (!plugin.getPlugin().getDataFolder().exists()) {
            try {
                plugin.getPlugin().getDataFolder().createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.file=new File(plugin.getPlugin().getDataFolder(), yamlNameWithExtension);
        this.cfg=YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getCfg() {
        return cfg;
    }

    public void writeLocation(Location location, ConfigurationSection section) {
        section.set("world", location.getWorld().getName());
        section.set("x", location.getX());
        section.set("y", location.getY());
        section.set("z", location.getZ());
        section.set("yaw", location.getYaw());
        section.set("pitch", location.getPitch());
        saveCfg();
    }

    public Location readLocation(ConfigurationSection section) {
        World world = Bukkit.getWorld(section.getString("world"));
        double x = section.getDouble("x");
        double y = section.getDouble("y");
        double z = section.getDouble("z");

        Location location = new Location(world, x, y, z);

        int yaw = section.getInt("yaw");
        int pitch = section.getInt("pitch");
        location.setY(yaw);
        location.setPitch(pitch);

        return location;
    }

    public void saveCfg() {
        try {
            this.cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public YamlStorage getMethod() {
        return this;
    }
}
