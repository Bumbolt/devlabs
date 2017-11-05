package com.realdolmen;

import com.realdolmen.rest.ApplicationResource;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Application {

    private static final String BASE_URI = "http://localhost:5555";

    public static void main(String[] args) throws Exception {
        startServer();
        System.out.println("Server started at " + BASE_URI);
        System.out.println("Hit any key to stop the server...");
        System.in.read();
    }

    private static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages((ApplicationResource.class).getPackage().getName());
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }


}
