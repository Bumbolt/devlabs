package com.realdolmen.rest;

import com.realdolmen.model.Session;
import com.realdolmen.model.SessionImpl;
import com.realdolmen.util.Logger;
import com.realdolmen.util.LoggerImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/session")
@Produces(MediaType.APPLICATION_JSON)
public class SessionResource {

    Logger logger = new LoggerImpl();

    @GET
    public List<Session> getSessions(){
        return new ArrayList<>();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createSession(SessionImpl session){
        logger.log("Create topic " + session.getName());
    }

    @GET
    @Path("{id}")
    public Session getSession(@PathParam("id") String id){
        return new SessionImpl(id);
    }
}
