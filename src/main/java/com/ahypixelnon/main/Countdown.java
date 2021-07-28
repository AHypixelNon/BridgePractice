package com.ahypixelnon.main;

import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable {

    private Arena arena;
    private int seconds;

    public Countdown(Arena arena) {
        this.arena = arena;
        this.seconds = Config.getCountdownSeconds();

    }
    public void begin() {
        arena.setState(GameState.COUNTDOWN);
        this.runTaskTimer(Main.getInstance(), 0, 20);
    }


    @Override
    public void run() {
        if (seconds == 0) {
            cancel();
            arena.Start();
        }

        if(seconds % 30 == 0 || seconds <= 10) {
            if (seconds == 1) {
                arena.sendMessage(ChatColor.LIGHT_PURPLE + "Bridge Will Start in 1 second.");
            } else {
                arena.sendMessage(ChatColor.LIGHT_PURPLE + "Bridge Will Start in " + seconds + " seconds.");
            }
        }

        if (arena.getPlayers().size() < Config.getRequiredPlayers()) {
            cancel();
            arena.setState(GameState.RECRUITING);
            arena.sendMessage(ChatColor.RED + "There are not enough players. Countdown stopped.");
            return;
        }

        seconds--;

    }
}
