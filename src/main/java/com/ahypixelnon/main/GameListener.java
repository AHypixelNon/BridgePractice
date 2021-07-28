package com.ahypixelnon.main;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;



public class GameListener implements Listener {

    private Player Killer;

    @EventHandler
    public void onKillPlayer(PlayerDeathEvent e) {

        Player player = e.getEntity().getPlayer();

        World world = Killer.getWorld();

        Location location1 = new Location(world, 998, 99, 993);

        Location location2 = new Location(world, 998, 99, 1007 );


            Killer.sendMessage(ChatColor.GOLD + "1 Point!");

            if (Manager.isPlaying(player) && (Manager.getArena(player)).getState().equals(GameState.LIVE)) {
                Manager.getArena(player).getGame().addPoint(player);

                player.sendMessage(ChatColor.GOLD + "+1 point");



                Killer = player.getKiller();

                Killer.teleport(location1); //insert location
                player.teleport(location2);  //insert location


            }

        }



    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        Player player = e.getPlayer();

        if (Manager.isPlaying(player)) {
            (Manager.getArena(player)).removePlayer(player);
        }
    }
}