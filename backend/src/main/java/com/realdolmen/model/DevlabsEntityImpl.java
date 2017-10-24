package com.realdolmen.model;

import com.realdolmen.repository.storage.api.StorageResult;

import java.util.UUID;

public abstract class DevlabsEntityImpl implements DevlabsEntity {
    private UUID id;

    DevlabsEntityImpl() {
        id = UUID.randomUUID();
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public abstract StorageResult save();

    @Override
    public abstract StorageResult delete();
}
