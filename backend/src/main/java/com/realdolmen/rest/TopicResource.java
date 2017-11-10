package com.realdolmen.rest;

import com.realdolmen.model.DevLabsTagImpl;
import com.realdolmen.model.Topic;
import com.realdolmen.model.TopicImpl;
import com.realdolmen.repository.storage.api.StorageResult;
import com.realdolmen.repository.storage.impl.FileStorage;
import com.realdolmen.repository.topics.impl.TopicRepository;
import com.realdolmen.util.Logger;
import com.realdolmen.util.LoggerImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/topics")
@Produces(MediaType.APPLICATION_JSON)
public class TopicResource {

    private Logger logger;
    private TopicRepository repository;

    public TopicResource() {
        logger = new LoggerImpl();
        this.repository = TopicRepository.create(FileStorage.create("./storage/"));
    }

    @GET
    public Response getTopics() {
        return Response.ok().entity(new GenericEntity<List<Topic>>(repository.findAll()) {}).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTopic(TopicImpl topic) {
        try {
            TopicImpl toSave = TopicImpl.of(topic);
            StorageResult result = toSave.save();
            if (result == StorageResult.OK) {
                return Response.accepted().build();
            }
        } catch (RuntimeException e) {
            logger.log("ERROR", e);
        }
        return Response.serverError().build();
    }

    @GET
    @Path("{id}")
    public Topic getTopic(@PathParam("id") String id) {
        return TopicImpl.of();
    }

    @POST
    @Path("{id}")
    public Response addTag(@PathParam("id") String id, DevLabsTagImpl tag) {
        tag.save();
        StorageResult storageResult = StorageResult.ERROR;//= storage.find(null);
        if (storageResult.equals(StorageResult.ERROR)) {
            return Response.serverError().build();
        }
        logger.log("Create tag " + tag.getName());
        return Response.ok().build();
    }
}
