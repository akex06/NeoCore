package dev.akex.neocore;

import dev.akex.neocore.commands.Top;
import dev.akex.neocore.commands.Tpr;
import dev.akex.neocore.utils.Data;
import org.bukkit.plugin.java.JavaPlugin;

public final class NeoCore extends JavaPlugin {

    public static NeoCore instance;

    public static NeoCore getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        System.out.println(Data.color("&f----------------------------------------"));
        System.out.println(Data.color("&eGracias por usar NeoCore"));
        System.out.println(Data.color("&ePuedes apollarme entrando a mi Discord <3"));
        System.out.println(Data.color("&bhttps://discord.neomatrix.ml"));
        System.out.println(Data.color("&f----------------------------------------"));

        loadCommands();
    }

    @Override
    public void onDisable() {
        System.out.println(Data.color("&c----------------------------------------"));
        System.out.println(Data.color("&eGracias por usar NeoCore"));
        System.out.println(Data.color("&ePuedes apollarme entrando a mi Discord <3"));
        System.out.println(Data.color("&chttps://discord.neomatrix.ml"));
        System.out.println(Data.color("&c----------------------------------------"));
    }

    public void loadCommands() {
        this.getCommand("top").setExecutor(new Top());
        this.getCommand("tpr").setExecutor(new Tpr());
    }
}
