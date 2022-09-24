package me.naaihr.antiautoclicker.player;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Currency;
import java.util.List;
import java.util.UUID;

@Getter
public class MyPlayer {
    private final UUID uuid;
    @Setter
    private long lastClickedAirMillis = System.currentTimeMillis();

    @Setter
    private int usingAutoclicker = 0;
    private int highestUsingAutoclicker = 1;

    public void addUsingAutoclicker() {
        this.usingAutoclicker++;

        this.highestUsingAutoclicker = Math.max(usingAutoclicker,highestUsingAutoclicker);

    }


    public MyPlayer(UUID uuid) {
        this.uuid = uuid;
    }
}
