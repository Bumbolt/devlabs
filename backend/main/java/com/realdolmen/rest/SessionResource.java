package com.realdolmen.rest;

import com.realdolmen.model.Session;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/session")
@Produces(MediaType.APPLICATION_JSON)
public class SessionResource {

    @GET
    public List<Session> getSessions(){
        return new ArrayList<>();
    }

    @GET
    @Path("{id}")
    public Session getSession(){
        return null;
    }
}
