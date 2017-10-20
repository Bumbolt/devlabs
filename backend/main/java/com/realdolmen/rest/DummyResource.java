package com.realdolmen.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/dummy")
public class DummyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String dummyString() {
        return "Hello Jersey Plain";
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dummy dummy(@PathParam("id") String id){
        return new Dummy(id);
    }
}
