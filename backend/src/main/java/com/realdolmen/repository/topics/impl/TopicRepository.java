package com.realdolmen.repository.topics.impl;

import com.realdolmen.model.Topic;
import com.realdolmen.repository.storage.api.Storage;
import com.realdolmen.repository.topics.api.Repository;

import java.util.List;

public class TopicRepository implements Repository {

    private static Storage storage;

    private TopicRepository(Storage storage) {
        TopicRepository.storage = storage;
    }

    public static TopicRepository create(Storage storage) {
        return new TopicRepository(storage);
    }

    public List<Topic> findAll() {
        return storage.findAll(Topic.class);
    }

}
