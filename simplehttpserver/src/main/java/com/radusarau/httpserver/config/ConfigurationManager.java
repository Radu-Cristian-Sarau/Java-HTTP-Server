package com.radusarau.httpserver.config;

public class ConfigurationManager {

    private static ConfigurationManager myConfigurationManager; // singleton
    private static Configuration myCurrentConfiguration;

    private ConfigurationManager() {

    }

    public static ConfigurationManager getInstance() {
        if (myConfigurationManager == null) {
            myConfigurationManager = new ConfigurationManager();
        }
        return myConfigurationManager;
    }

    /**
     * Used to load a configuration file by the path provided.
     * @param filePath - the path to the configuration file
     */
    public void loadConfigurationFile(String filePath) {

    }

    /**
     * Returns the current configuration.
     */
    public void getCurrentConfiguration() {

    }
}
