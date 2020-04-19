package com.wicket.video.demo;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class DemoServer {

    private static final Server server = new Server();

    public static void main(String[] args) {
        try {
            new DemoServer().startServer("src/main/webapp", 1024);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(100);
        }
    }

    public void startServer(String warPath, int port) throws Exception {
        System.setProperty("wicket.configuration", "development");

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(port);
        server.setConnectors(new Connector[]{connector});

        WebAppContext bb = new WebAppContext();
        bb.setServer(server);
        bb.setContextPath("/");

        bb.setWar(warPath);
        server.setHandler(bb);

        server.start();
    }

    public static Server getServer() {
        return server;
    }

}
