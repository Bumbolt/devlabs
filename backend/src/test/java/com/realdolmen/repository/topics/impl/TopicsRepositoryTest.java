package com.realdolmen.repository.topics.impl;

import com.realdolmen.model.Topic;
import com.realdolmen.model.TopicImpl;
import com.realdolmen.repository.storage.impl.FileStorage;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TopicsRepositoryTest {

    private FileStorage storage;

    @Test
    public void findAll_returnsAllTopics() throws Exception {
        TopicRepository repository = createRepositoryWithStoredEntities();

        List<Topic> result = repository.findAll();

        assertNotNull(result);
    }

    @Test
    public void findAll_returnsStoredTopics() throws Exception {
        TopicRepository repository = createRepositoryWithStoredEntities();

        List<Topic> result = repository.findAll();

        assertEquals(3, result.size());
    }

    @After
    public void cleanUp() throws IOException {
        storage.clear();
    }


    private TopicRepository createRepositoryWithStoredEntities() {
        storage = FileStorage.create("./teststorage/");
        storage.save(TopicImpl.create());
        storage.save(TopicImpl.create());
        storage.save(TopicImpl.create());
        return TopicRepository.create(storage);
    }
}