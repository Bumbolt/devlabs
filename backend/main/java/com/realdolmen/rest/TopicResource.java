package com.realdolmen.rest;

import com.realdolmen.model.SessionImpl;
import com.realdolmen.model.Topic;
import com.realdolmen.model.TopicImpl;
import com.realdolmen.util.Logger;
import com.realdolmen.util.LoggerImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/topic")
@Produces(MediaType.APPLICATION_JSON)
public class TopicResource {

    Logger logger = new LoggerImpl();

    @GET
    public List<Topic> getTopics() {
        return new ArrayList<>();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createTopic(TopicImpl topic){
        logger.log("Create topic " + topic.getTitle());
    }

    @GET
    @Path("{id}")
    public Topic getTopic(@PathParam("id") String id){
        return new TopicImpl(
                "title", "description", new SessionImpl("1")
        );
    }
}
