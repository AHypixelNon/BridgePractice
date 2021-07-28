package com.ahypixelnon.main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Game {

    private Arena arena;
    private HashMap<UUID, Integer> points;

    public Game(Arena arena) {
        this.arena = arena;
        this.points = new HashMap<>();

    }

    public void start() {
        arena.setState(GameState.LIVE);

        arena.sendMessage(ChatColor.GREEN + "Game has started! Kill your opponent");

        for (UUID uuid : arena.getPlayers()) {
            points.put(uuid, 0);
        }
    }

    public void addPoint(Player player) {
        int p = points.get(player.getUniqueId()) + 1;

        if (p == 5) {
            arena.sendMessage(ChatColor.GOLD + player.getName() + " Has Won");

            arena.reset();
            return;
        }
            points.replace(player.getUniqueId(), p);
    }
}
