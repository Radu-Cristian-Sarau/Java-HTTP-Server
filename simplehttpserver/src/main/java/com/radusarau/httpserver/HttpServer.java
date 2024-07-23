package com.radusarau.httpserver;

import com.radusarau.httpserver.config.Configuration;
import com.radusarau.httpserver.config.ConfigurationManager;
import com.radusarau.httpserver.core.ServerListenerThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    public static void main(String[] args) {
        System.out.println("Server starting...");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration configuration = ConfigurationManager.getInstance().getCurrentConfiguration();

        System.out.println("Server started on port: " + configuration.getPort());
        System.out.println("Webroot: " + configuration.getWebroot());

        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(configuration.getPort(), configuration.getWebroot());
            serverListenerThread.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
            // TODO handle exception
        }
    }
}
