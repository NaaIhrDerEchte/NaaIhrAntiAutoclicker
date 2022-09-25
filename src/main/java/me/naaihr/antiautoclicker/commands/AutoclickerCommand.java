package me.naaihr.antiautoclicker.commands;

import me.naaihr.antiautoclicker.player.MyPlayer;
import me.naaihr.antiautoclicker.player.MyPlayerProvider;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutoclickerCommand implements CommandExecutor {

    String name = "autoclicker";

    public String getName() {
        return this.name;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player)  sender;

        if(command.getName().equalsIgnoreCase(getName())){
            if(!player.isOp()) {
                player.sendMessage("You don't have the permissions to use this command");
            }

            try {

                Player target = Bukkit.getPlayer(args[0]);

                if (target == null) {
                    player.sendMessage(args[0] + " is not online");
                }

                MyPlayer myPlayerTarget = MyPlayerProvider.getPlayerByUUID(target.getUniqueId());

                int highestPercentUsingAC = (int) (Math.log10(myPlayerTarget.getHighestUsingAutoclickerLeft()) * 100);

                ChatColor chatColor = ChatColor.GREEN;
                if(highestPercentUsingAC > 50) {
                    chatColor = ChatColor.GOLD;
                }
                if(highestPercentUsingAC > 95) {
                    chatColor = ChatColor.RED;
                }

                player.sendMessage(chatColor + target.getName() + " is using AC: " + highestPercentUsingAC + "%");

            } catch (Exception ignored) {
                player.sendMessage("Usage: /" + this.getName() + " <PlayerName>");

            }

            return true;
        }

        return false;
    }
}
