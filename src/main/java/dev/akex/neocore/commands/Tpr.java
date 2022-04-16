package dev.akex.neocore.commands;

import dev.akex.neocore.NeoCore;
import dev.akex.neocore.utils.Data;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class Tpr implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            System.out.println(Data.console());
            return true;
        }

        Random random = new Random();

        FileConfiguration config = NeoCore.getInstance().getConfig();

        Player player = ((Player) sender).getPlayer();

        List<?> list = config.getList("tpr.worlds");
        assert player != null;
        assert list != null;
        if (list.contains(player.getWorld().getName())) {
            player.sendMessage(Data.color("&cNo puedes usar este comando en este mundo!"));
            return true;
        }
        World world = player.getWorld();

        double x = random.nextInt(config.getInt("tpr.x"));
        double z = random.nextInt(config.getInt("tpr.z"));
        double y = world.getHighestBlockYAt((int) x, (int) z);

        Location location = new Location(world, x, y, z, player.getLocation().getPitch(), player.getLocation().getYaw());
        player.teleport(location);
        player.sendMessage(Data.color("&aHas sido teletransportado a x:" + location.getBlockX() + ", y:" + location.getBlockY() + ", z:" + location.getBlockZ()));

        return true;
    }
}
