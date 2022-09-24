package me.naaihr.antiautoclicker.player;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MyPlayerProvider {
    @Getter
    private static List<MyPlayer> playerList = new ArrayList<>();

    public static void addPlayer(UUID uuid) {
        getPlayerList().add( new MyPlayer(uuid));
    }

    public static void removePlayer(UUID uuid) {
        getPlayerList().removeIf(myPlayer -> myPlayer.getUuid() == uuid);
    }

    public static MyPlayer getPlayerByUUID(UUID uuid) {
        MyPlayer myPlayer = null;

        for(MyPlayer myPlayer1 : getPlayerList()) {
            if(myPlayer1.getUuid() == uuid) {
                myPlayer = myPlayer1;
            }
        }
        return myPlayer;
    }
}
