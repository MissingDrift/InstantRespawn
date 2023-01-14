package missingdrift.instantrespawn;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Instantrespawn extends JavaPlugin implements Listener {

    private FileConfiguration config;

    @Override
    public void onEnable() {
        System.out.println("\n" +
                "  ___ _   _ ____ _____  _    _   _ _____   ____  _____ ____  ____   ___        ___   _ \n" +
                " |_ _| \\ | / ___|_   _|/ \\  | \\ | |_   _| |  _ \\| ____/ ___||  _ \\ / \\ \\      / / \\ | |\n" +
                "  | ||  \\| \\___ \\ | | / _ \\ |  \\| | | |   | |_) |  _| \\___ \\| |_) / _ \\ \\ /\\ / /|  \\| |\n" +
                "  | || |\\  |___) || |/ ___ \\| |\\  | | |   |  _ <| |___ ___) |  __/ ___ \\ V  V / | |\\  |\n" +
                " |___|_| \\_|____/ |_/_/   \\_\\_| \\_| |_|   |_| \\_\\_____|____/|_| /_/   \\_\\_/\\_/  |_| \\_|\n" +
                "                                                                                       \n" +
                "\n" +
                "Version: 1.0.0\n" +
                "Author: MissingDrift");
        saveDefaultConfig();
        config = getConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (!config.getBoolean("keep-death-message")) {
            event.setDeathMessage(null);
        }
        event.setKeepInventory(config.getBoolean("keep-inventory"));
        event.getEntity().spigot().respawn();
    }
}
