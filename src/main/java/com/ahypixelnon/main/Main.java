package com.ahypixelnon.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Main.instance = this;

        new Config(this);


        new Manager();

        getCommand("arena").setExecutor(new ArenaCommand());

        Bukkit.getPluginManager().registerEvents(new GameListener(), this);

        }

        public static Main getInstance() { return instance; }
}

