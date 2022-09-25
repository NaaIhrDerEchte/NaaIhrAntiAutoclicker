package me.naaihr.antiautoclicker;

import me.naaihr.antiautoclicker.commands.AutoclickerCommand;
import me.naaihr.antiautoclicker.listeners.PlayerSwingListener;
import me.naaihr.antiautoclicker.listeners.PlayerConnectionListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

//TODO kann Luftschläge und schläge auf Spieler net unterscheidne und das zerstört alles

public final class AntiAutoclicker extends JavaPlugin {

    @Override
    public void onEnable() {

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerConnectionListener() , this);
        pm.registerEvents(new PlayerSwingListener() , this);


        this.getCommand("autoclicker").setExecutor(new AutoclickerCommand());



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
