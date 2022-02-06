package config;

import org.aeonbits.owner.ConfigCache;

public class ConfigManager {

    private static Configuration instance;

    private ConfigManager() {
    }

    public static Configuration getConfiguration() {
        if (instance == null) {
            instance = ConfigCache.getOrCreate(Configuration.class);
        }
        return instance;
    }
}
