package com.realdolmen.rest;

import com.realdolmen.model.DevLabsTag;
import com.realdolmen.model.DevLabsTagImpl;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/tag")
@Produces(MediaType.APPLICATION_JSON)
public class DevlabTagResource {

    @GET
    public List<DevLabsTag> getTags(){
        return Arrays.asList(
                new DevLabsTagImpl("devlab"),
                new DevLabsTagImpl("app")
        );
    }

    @POST
    public void createTag(DevLabsTag tag){
        tag.save();
    }
}
