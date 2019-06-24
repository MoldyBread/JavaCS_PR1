package com.shop.rest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.RuntimeDelegate;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


public class App {


    static HttpServer startServer() throws IOException {
        final HttpServer server = HttpServer.create(new InetSocketAddress(getBaseURI().getPort()), 0);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                server.stop(0);
            }
        }));

        HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new JaxRsApplication(), HttpHandler.class);

        server.createContext(getBaseURI().getPath(), handler);

        server.start();

        return server;
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        startServer();

        System.out.println("Application started.\n"
                + "Try accessing " + getBaseURI() + "good in the browser.");

        Thread.currentThread().join();
    }

    private static int getPort(int defaultPort) {
        final String port = System.getProperty("jersey.config.test.container.port");
        if (null != port) {
            try {
                return Integer.parseInt(port);
            } catch (NumberFormatException e) {
            }
        }
        return defaultPort;
    }


    public static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(getPort(8080)).build();
    }
}