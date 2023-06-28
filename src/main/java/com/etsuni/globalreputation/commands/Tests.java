package com.etsuni.globalreputation.commands;

import com.etsuni.globalreputation.utils.ReputationUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.net.URISyntaxException;

public class Tests implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = ((Player) sender).getPlayer();

            if(command.getName().equalsIgnoreCase("getrep")) {
                try {
                    ReputationUtils.getPlayersReputation(p.getUniqueId());

                } catch (Exception e) {
                    Bukkit.broadcastMessage(e.toString());
                }
            }
            else if(command.getName().equalsIgnoreCase("addplayer")) {
                try {
                    ReputationUtils.addPlayerToDatabase(p.getUniqueId());
                } catch (Exception e) {
                    Bukkit.broadcastMessage(e.toString());
                }
            }
        }
        return false;
    }
}
