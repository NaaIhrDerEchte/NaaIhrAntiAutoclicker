package me.naaihr.antiautoclicker.protocollLib;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import me.naaihr.antiautoclicker.player.MyPlayerProvider;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Bukkit.getLogger;

public class SwingPacket {

    public SwingPacket(Plugin plugin) {
        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();

        protocolManager.addPacketListener(
                new PacketAdapter(plugin, ListenerPriority.HIGHEST,
                        PacketType.Play.Client.ARM_ANIMATION) {
                    @Override
                    public void onPacketReceiving(PacketEvent event) {
                        //getLogger().info("Packet Swing");

                     //   if(MyPlayerProvider.getPlayerByUUID(event.getPlayer().getUniqueId()).isClickingAir()) {

                         //   getLogger().info(event.getPlayer().getName() + " clicked");
                       // }

                    }
                });
    }


}
