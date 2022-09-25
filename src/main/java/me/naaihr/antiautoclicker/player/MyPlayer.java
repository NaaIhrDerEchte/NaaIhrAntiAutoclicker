package me.naaihr.antiautoclicker.player;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public class MyPlayer {
    private final UUID uuid;
    @Setter
    private long lastClickedAirMillisLeft = System.currentTimeMillis();
    @Setter
    private int usingAutoclickerLeft = 0;
    private int highestUsingAutoclickerLeft = 0;
    @Setter
    private long lastClickedMillisRight = System.currentTimeMillis();
    @Setter
    private int usingAutoclickerRight = 0;
    private int highestUsingAutoclickerRight = 0;


    public void addUsingAutoclickerLeft() {
        this.usingAutoclickerLeft++;
        this.highestUsingAutoclickerLeft = Math.max(usingAutoclickerLeft, highestUsingAutoclickerLeft);
    }

    public void addUsingAutoclickerRight() {
        this.usingAutoclickerRight++;
        this.highestUsingAutoclickerRight = Math.max(usingAutoclickerRight, highestUsingAutoclickerRight);
    }


    public MyPlayer(UUID uuid) {
        this.uuid = uuid;
    }
}
