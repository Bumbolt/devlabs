package com.realdolmen.model;

import com.realdolmen.repository.storage.api.StorageResult;

import java.util.Set;

public class TopicImpl extends DevlabsEntityImpl implements Topic {
    private String title, description;
    private Set<DevLabsTag> tags;
    private Set<DevLabsUser> subscribers;
    private Session session;

    private TopicImpl() {}

    public static Topic create() {
        return new TopicImpl();
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
