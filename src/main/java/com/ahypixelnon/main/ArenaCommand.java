package com.ahypixelnon.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;




public class ArenaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 1 && args[0].equalsIgnoreCase("list")) {
                player.sendMessage(ChatColor.GREEN + "These Are The Available Arenas:");
                for (Arena arena : Manager.getArenas()) {
                    System.out.println("Running");
                    player.sendMessage(ChatColor.GREEN + "- " + arena.getId());
                }
            } else if (args.length == 1 && args[0].equalsIgnoreCase("leave")) {
                if (Manager.isPlaying(player)) {
                    (Manager.getArena(player)).removePlayer(player);

                    player.sendMessage(ChatColor.GREEN + "You left the arena!");
                } else {
                    player.sendMessage(ChatColor.RED + "You are not in an arena!");
                }
            } else if (args.length == 2 && args[0].equalsIgnoreCase("join")) {
                try {
                    int id = Integer.parseInt(args[1]);

                    if (id >= 0 && id <= (Config.getArenaAmount() - 1)) {
                        if (Manager.isRecruiting(id)) {
                           (Manager.getArena(id)).addPlayer(player);

                            player.sendMessage(ChatColor.GREEN + "You are now playing in Arena " + id + "!");
                        } else {
                            player.sendMessage(ChatColor.RED + "You cannot join this game right now!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "Invalid arena! See /arena list for available arenas!");
                    }
                } catch (NumberFormatException x) {
                    player.sendMessage(ChatColor.RED + "Invalid arena! See /arena list for available arenas.");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid usage - these are the options:");
                player.sendMessage(ChatColor.RED + "- /arena list");
                player.sendMessage(ChatColor.RED + "- /arena join [id]");
                player.sendMessage(ChatColor.RED + "- /arena leave");

            }
        } else {
            System.out.println("Red you are noob, stop using console!");
        }


        return false;

    }

}
