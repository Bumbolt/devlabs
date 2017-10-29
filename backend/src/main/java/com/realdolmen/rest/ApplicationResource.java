package com.realdolmen.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class ApplicationResource {

    @GET
    public String root() {
        return "Welcome to the DevLabs application REST API.";
    }
}
