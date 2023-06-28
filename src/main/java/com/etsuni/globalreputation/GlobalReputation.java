package com.etsuni.globalreputation;

import com.etsuni.globalreputation.commands.Tests;
import com.etsuni.globalreputation.menus.PlayerMenuUtility;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class GlobalReputation extends JavaPlugin {

    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();

    @Override
    public void onEnable() {
        this.getCommand("getrep").setExecutor(new Tests());
        this.getCommand("addplayer").setExecutor(new Tests());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public PlayerMenuUtility getPlayerMenuUtility(Player player) {
        PlayerMenuUtility playerMenuUtility;

        if(playerMenuUtilityMap.containsKey(player)) {
            return playerMenuUtilityMap.get(player);
        }
        else {
            playerMenuUtility = new PlayerMenuUtility(player);
            playerMenuUtilityMap.put(player, playerMenuUtility);

            return playerMenuUtility;
        }
    }
}
