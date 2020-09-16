package dev.blockeed.api.tools;

/*
 * Copyright (c) Blockeed | All rights reserved
 *
 * Do not change the code!
 *
 */

import org.bukkit.plugin.java.JavaPlugin;

public class MinecraftPlugin {

    private JavaPlugin plugin;
    private String pluginname;
    private String prefix;

    public MinecraftPlugin(JavaPlugin plugin, String pluginName, String prefix) {
        this.plugin=plugin;
        this.pluginname=pluginName;
        this.prefix=prefix;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public String getPluginname() {
        return pluginname;
    }

    public String getPrefix() {
        return prefix;
    }
}
