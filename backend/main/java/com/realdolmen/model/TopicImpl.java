package com.realdolmen.model;

import com.realdolmen.repository.storage.api.StorageResult;

import java.util.Set;

public class TopicImpl extends DevlabsEntityImpl implements Topic {
    private String title, description;
    private Set<DevLabsTag> tags;
    private Set<DevLabsUser> subscribers;
    private Session session;

    public TopicImpl() {
    }

    public TopicImpl(String title, String description, Session session) {
        this.title = title;
        this.description = description;
        this.session = session;
    }

    public TopicImpl(String title, String description, Set<DevLabsTag> tags,
                     Set<DevLabsUser> subscribers, Session session) {
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.subscribers = subscribers;
        this.session = session;
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
        return tags;
    }

    @Override
    public Set<DevLabsUser> getSubscribers() {
        return subscribers;
    }

    @Override
    public Session getSession() {
        return session;
    }
}
