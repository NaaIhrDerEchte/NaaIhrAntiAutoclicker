package me.naaihr.antiautoclicker.listeners;

import me.naaihr.antiautoclicker.player.MyPlayerProvider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        MyPlayerProvider.addPlayer(event.getPlayer().getUniqueId());
    }


    @EventHandler
    public void onPlayerDisconnect(PlayerQuitEvent event) {
        MyPlayerProvider.removePlayer(event.getPlayer().getUniqueId());
    }
}
