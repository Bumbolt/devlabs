package com.realdolmen.rest;

import com.realdolmen.model.Topic;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/topic")
@Produces(MediaType.APPLICATION_JSON)
public class TopicResource {

    @GET
    public List<Topic> getTopics() {
        return new ArrayList<>();
    }

    @GET
    @Path("{id}")
    public Topic getTopic(@PathParam("id") String id){
        return null;
    }
}
