package com.realdolmen.model;

import com.realdolmen.repository.storage.api.StorageResult;

import java.util.Collections;
import java.util.Set;

public class TopicImpl extends DevlabsEntityImpl implements Topic {

    private String title, description;
    private Set<DevLabsTag> tags;
    private Set<DevLabsUser> subscribers;
    private Session session;

    private TopicImpl() {}

    public static Topic of() {
        return new TopicImpl();
    }

    public static TopicImpl of(Topic topic) {
        TopicImpl result = new TopicImpl();
        result.title = topic.getTitle();
        result.description = topic.getDescription();
        result.tags = topic.getTags();
        result.subscribers = result.getSubscribers();
        result.session = result.getSession();
        return result;
    }

    @Override
    public StorageResult save() {
        return StorageResult.ERROR;
    }

    @Override
    public StorageResult delete() {
        return StorageResult.ERROR;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Set<DevLabsTag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    @Override
    public Set<DevLabsUser> getSubscribers() {
        return Collections.unmodifiableSet(subscribers);
    }

    @Override
    public Session getSession() {
        return session;
    }
}
