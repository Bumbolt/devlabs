package com.realdolmen.rest;

import com.realdolmen.model.Topic;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.ServletDeploymentContext;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Test;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TopicResourceTest extends JerseyTest {

    @Override
    protected TestContainerFactory getTestContainerFactory() {
        return new GrizzlyWebTestContainerFactory();
    }

    @Override
    protected DeploymentContext configureDeployment() {
        return ServletDeploymentContext.forPackages(getClass().getPackage().getName()).build();
    }

    @Test
    public void getTopics_returnsTopics() throws Exception {
        Response response = target("/topics").request().get();

        assertEquals(0, readList(response).size());
    }

    @Test
    public void getTopics_has200Code() throws Exception {
        Response response = target("/topics").request().get();

        assertEquals(200, response.getStatus());
    }

    private List<Topic> readList(Response response) {
        return response.readEntity(new GenericType<List<Topic>>(){});
    }
}