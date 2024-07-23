package com.radusarau.httpserver;

import com.radusarau.httpserver.config.Configuration;
import com.radusarau.httpserver.config.ConfigurationManager;

public class HttpServer {

    public static void main(String[] args) {
        System.out.println("Server starting...");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration configuration = ConfigurationManager.getInstance().getCurrentConfiguration();

        System.out.println("Server started on port: " + configuration.getPort());
        System.out.println("Webroot: " + configuration.getWebroot());
    }
}
