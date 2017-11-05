package com.realdolmen.repository;

import com.realdolmen.model.DevlabsEntity;
import com.realdolmen.repository.storage.api.StorageResult;

import java.util.UUID;

public class NeverPersistedEntity implements DevlabsEntity {
    @Override
    public UUID getId() {
        return null;
    }

    @Override
    public StorageResult save() {
        return null;
    }

    @Override
    public StorageResult delete() {
        return null;
    }
}
