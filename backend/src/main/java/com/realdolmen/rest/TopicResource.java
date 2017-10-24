package com.realdolmen.rest;

import com.realdolmen.model.DevLabsTagImpl;
import com.realdolmen.model.SessionImpl;
import com.realdolmen.model.Topic;
import com.realdolmen.model.TopicImpl;
import com.realdolmen.repository.storage.api.Storage;
import com.realdolmen.repository.storage.api.StorageResult;
import com.realdolmen.util.Logger;
import com.realdolmen.util.LoggerImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/topic")
@Produces(MediaType.APPLICATION_JSON)
public class TopicResource {

    Logger logger = new LoggerImpl();
    Storage storage;

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

    @POST
    @Path("{id}")
    public Response addTag(
            @PathParam("id") String id,
            DevLabsTagImpl tag
    ){
        tag.save();
        StorageResult storageResult = StorageResult.ERROR;//= storage.find(null);
        if(storageResult.equals(StorageResult.ERROR)){
            return Response.serverError().build();
        }
        logger.log("Create tag " + tag.getName());
        return Response.ok().build();
    }
}
