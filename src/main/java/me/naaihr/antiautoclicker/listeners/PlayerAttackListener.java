package me.naaihr.antiautoclicker.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerAttackListener implements Listener {

    @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent event) {
        //Wir wollen nur Spieler
        if(!(event.getDamager() instanceof Player)) {
            return;
        }

        //TODO

    }
}
