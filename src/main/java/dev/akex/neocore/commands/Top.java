package dev.akex.neocore.commands;

import dev.akex.neocore.utils.Data;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Top implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            System.out.println(Data.console());
            return true;
        }

        Player player = ((Player) sender).getPlayer();
        World world = player.getWorld();
        Block block = world.getHighestBlockAt(player.getLocation());
        Location location = block.getLocation().add(0, 1, 0);
        location.setPitch(player.getLocation().getPitch());
        location.setYaw(player.getLocation().getYaw());

        player.teleport(location);
        player.sendMessage(Data.color("&aHas sido teletransportado al bloque más alto"));

        return true;
    }
}
