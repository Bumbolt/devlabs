package com.realdolmen.model;

import com.realdolmen.repository.storage.api.StorageResult;

import java.util.List;

public class TopicImpl extends DevlabsEntityImpl implements Topic {
    private String title, description;
    private List<DevLabsTag> tags;
    private List<DevLabsUser> subscribers;
    private Session session;

    public TopicImpl(String title, String description, Session session) {
        this.title = title;
        this.description = description;
        this.session = session;
    }

    public TopicImpl(String title, String description, List<DevLabsTag> tags,
                     List<DevLabsUser> subscribers, Session session) {
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
    public List<DevLabsTag> getTags() {
        return tags;
    }

    @Override
    public List<DevLabsUser> getSubscribers() {
        return subscribers;
    }

    @Override
    public Session getSession() {
        return session;
    }
}
