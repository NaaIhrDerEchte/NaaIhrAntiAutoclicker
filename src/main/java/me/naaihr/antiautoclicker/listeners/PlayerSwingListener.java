package me.naaihr.antiautoclicker.listeners;

import me.naaihr.antiautoclicker.player.MyPlayer;
import me.naaihr.antiautoclicker.player.MyPlayerProvider;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;

import static org.bukkit.Bukkit.*;

public class PlayerSwingListener implements Listener {

    @EventHandler
    public void swing(PlayerInteractEvent event) {
        if (event.getAction() != Action.LEFT_CLICK_AIR) {
            return;
        }


        //In Creative funkt das nicht
        if (event.getPlayer().getGameMode() == GameMode.CREATIVE) {
            return;
        }

        Player player = event.getPlayer();
        MyPlayer myPlayer = MyPlayerProvider.getPlayerByUUID(player.getUniqueId());

        //Der Check funkt nur wenn er Spieler auf kein Entity schaut
        if(playerLookingAtEntity(player,3.2)) {
            return;
        }


        long lastClickMillis = myPlayer.getLastClickedAirMillis();
        myPlayer.setLastClickedAirMillis(System.currentTimeMillis());

        //Player is lagging
        if ((System.currentTimeMillis() - lastClickMillis) < 10) {
            return;
        }

        //SUS so schnell zu clicken
        if ((System.currentTimeMillis() - lastClickMillis) < 60) {
            myPlayer.addUsingAutoclicker();
            //nicht wirklich Prozent aber schon aussagekäftig, muss noch gucken ab was man bannen könnte
            int percentUsingAC = (int) (Math.log10(myPlayer.getUsingAutoclicker()) * 100);

            ChatColor chatColor = ChatColor.GREEN;
            if (percentUsingAC > 50) {
                chatColor = ChatColor.GOLD;
            }
            if (percentUsingAC > 95) {
                chatColor = ChatColor.RED;
            }

            if (percentUsingAC > 85) {
                ChatColor finalChatColor = chatColor;
                getServer().getOnlinePlayers().forEach(player1 -> {
                    if (!player1.isOp()) {
                        return;
                    }
                    player1.sendMessage(finalChatColor + event.getPlayer().getName() + " " + percentUsingAC + "% using Autoclicker");
                });
            }
        } else {
            myPlayer.setUsingAutoclicker(myPlayer.getUsingAutoclicker() / 2);
        }
    }

    //TODO Das funkt, aber setzt die Y Achse auf 0 und ist sehr hässlich, also wirklich beschissen
    private boolean playerLookingAtEntity(Player player, double maxDistance) {
        Location eyeLocation = player.getEyeLocation();

        //TODO machen dass die List nur aus Living entities besteht
        List<Entity> entityList = player.getNearbyEntities(5,5,5);
        entityList.removeIf(e -> (!(e instanceof LivingEntity)));

        for(double i = 0; i < maxDistance; i+=0.1) {
            eyeLocation.add(eyeLocation.getDirection().normalize().multiply(0.1));

            for(Entity entity : entityList) {
                if(!(entity instanceof LivingEntity)) {
                    continue;
                }

                Location entityLoc = entity.getLocation();
                entityLoc.setY(0);
                eyeLocation.setY(0);


                if(entityLoc.distance(eyeLocation) < 0.4) {
                    return true;
                }
            }
        }

        return false;
    }
}
